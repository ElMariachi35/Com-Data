package transfer;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import selenium.ComunioLoginPage;
import selenium.ComunioTeamNewsPage;
import cdi.Service;

@Service
public class TransferParser implements Serializable {

	public List<RawTransfer> parseTransfers() throws IOException,
			InterruptedException {
		List<Element> newsList = extractNewsElements();
		List<RawTransfer> transfers = new ArrayList<RawTransfer>();
		for (int i = 0; i < newsList.size(); i++) {
			if (!isTransferNews(newsList, i)) {
				continue;
			}
			String dateString = newsList.get(i).select(".newsheader span")
					.attr("title");
			Date date = determineNewsDate(dateString);
			Element body = newsList.get(i + 2);
			transfers.addAll(parseNewsBody(body, date));
		}
		return transfers;
	}

	private List<Element> extractNewsElements() throws InterruptedException, IOException {
        String newsPage = getSourceFromFile();
        Document document = Jsoup.parse(newsPage);
        Element newsMessages = document.select("#postwrap").first();
        Thread.sleep(3000);
        Iterator<Element> iterator = newsMessages.children().iterator();
        List<Element> newsList = new ArrayList<Element>();
        while (iterator.hasNext()) {
            Element newsElement = iterator.next();
            newsList.add(newsElement);
        }
        return newsList;
    }

	private List<RawTransfer> parseNewsBody(Element element, Date date) {
		String[] lines = element.html().split("<br />");
		List<RawTransfer> transfers = new ArrayList<RawTransfer>();
		for (int j = 0; j < lines.length; j++) {

			String transferLine = Jsoup.parse(lines[j].trim()).text();
			String[] token = transferLine.split(" ");
			String playerName = determinePlayerName(token);
			double sum = determineSum(token);
			String from = determineFrom(token);
			String to = determineTo(token);
			if (StringUtils.isEmpty(playerName) || sum == -1) {
				continue;
			}
			transfers.add(createTransfer(date, playerName, sum, from, to));
		}
		return transfers;
	}

	public RawTransfer createTransfer(Date date, String playerName, double sum,
			String from, String to) {
		RawTransfer transfer = new RawTransfer();
		transfer.setFromUser(from);
		transfer.setToUser(to);
		transfer.setPlayerName(playerName);
		transfer.setTransferDate(date);
		transfer.setTransferFee(new BigDecimal(sum));
		return transfer;
	}

	private boolean isTransferNews(List<Element> newsList, int i) {
		return newsList.get(i).select(".newsheader").text()
				.contains("Computer > Transfers");
	}

	private String determineTo(String[] token) {
		if (token.length < 2) {
			return "";
		}
		int indexOfZu = 0;
		String to = "";
		for (int i = 0; i < token.length; i++) {
			if (token[i].equals("zu")) {
				indexOfZu = i;
			}
		}

		to = StringUtils.join(
				Arrays.copyOfRange(token, indexOfZu + 1, token.length), " ")
				.trim();
		return to.substring(0, to.length() - 1);
	}

	private String determineFrom(String[] token) {
		if (token.length < 2) {
			return "";
		}
		int indexOfVon = 0;
		int indexOfZu = 0;
		for (int i = 0; i < token.length; i++) {
			if (token[i].equals("von")) {
				indexOfVon = i;
			}
			if (token[i].equals("zu")) {
				indexOfZu = i;
			}
		}
		return StringUtils.join(
				Arrays.copyOfRange(token, indexOfVon + 1, indexOfZu), " ")
				.trim();
	}

	private double determineSum(String[] token) {
		for (int i = 0; i < token.length; i++) {
			if (token.length < 2) {
				continue;
			}
			if (token[i].equals("für")) {
				return Double.parseDouble(token[i + 1].replace(".", ""));

			}
		}
		return -1;
	}

	private String determinePlayerName(String[] token) {
		String playerName = "";
		for (int i = 0; i < token.length; i++) {
			if (token.length < 2) {
				continue;
			}
			if (token[i].equals("wechselt")) {
				return playerName.trim();
			}
			playerName = playerName + token[i] + " ";
		}
		return "";
	}

	private Date determineNewsDate(String dateString) {
		String rawFormatString = "dd.MM.yy HH:mm";
		DateTimeFormatter formatter = DateTimeFormat
				.forPattern(rawFormatString);
		return formatter.parseDateTime(dateString).toDate();

	}

	private String getSourceOfNewsPage() {
		ComunioLoginPage loginPage = new ComunioLoginPage();
		ComunioTeamNewsPage teamNewsPage = loginPage.login("Hotboy48",
				"Thinkp4d");
		String source = teamNewsPage.getPageSource();
		teamNewsPage.close();
		return source;
	}

	private String getSourceFromFile() throws IOException {
		return readFile("/home/ghoheneder/Documents/transfers.txt",
				Charset.defaultCharset());
	}

	private String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
