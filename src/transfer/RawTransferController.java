package transfer;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.Transactional;

import cdi.Controller;

@Controller
public class RawTransferController implements Serializable {

	@Inject
	RawTransferDao rawTransferDao;
	@Inject
	TransferParser transferParser;
	@Inject
	RawTransferService rawTransferService;

	private List<RawTransfer> rawTransfers;

	@PostConstruct
	public void initializeRawTransfers() {
		rawTransfers = rawTransferService.findLatest(25);
	}

	@Transactional
	public void parseTransfers() throws IOException, InterruptedException {
		List<RawTransfer> transfers = transferParser.parseTransfers();
		for (RawTransfer rawTransfer : transfers) {
			persistTransfer(rawTransfer);
		}
		System.out.println("Finished parse and persist of Transfers!");
	}

	public void persistTransfer(RawTransfer rawTransfer) {
		if (transferAlreadySaved(rawTransfer)) {
			System.out.println("Duplicate entry: " + rawTransfer.getPlayerName() + " from " + rawTransfer.getFromUser() + " to "
					+ rawTransfer.getToUser() + " for " + rawTransfer.getTransferFee());
			return;
		}
		rawTransferDao.create(rawTransfer);
		System.out.println("Added transfer: " + rawTransfer.getPlayerName() + " from " + rawTransfer.getFromUser() + " to "
				+ rawTransfer.getToUser() + " for " + rawTransfer.getTransferFee());
	}

	private boolean transferAlreadySaved(RawTransfer rawTransfer) {
		RawTransfer storedTransfer = rawTransferService.findBy(rawTransfer.getPlayerName(), rawTransfer.getTransferDate());
		return storedTransfer != null;
	}

	public List<RawTransfer> getRawTransfers() {
		return rawTransfers;
	}

	public void setRawTransfers(List<RawTransfer> rawTransfers) {
		this.rawTransfers = rawTransfers;
	}
}
