package transfer;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import model.BaseEntity;

@Entity
@Table(name = "rawtransfer")
@NamedQueries({
		@NamedQuery(name = RawTransfer.SUM_OF_PURCHASES_BY_USER, query = "SELECT SUM(r.transferFee) FROM RawTransfer r WHERE r.toUser=:"
				+ RawTransfer.PARAM_USER),
		@NamedQuery(name = RawTransfer.SUM_OF_SALES_BY_USER, query = "SELECT SUM(r.transferFee) FROM RawTransfer r WHERE r.fromUser=:"
				+ RawTransfer.PARAM_USER),
		@NamedQuery(name = RawTransfer.FIND_LATEST, query = "SELECT r FROM RawTransfer r ORDER BY r.transferDate DESC"),
		@NamedQuery(name = RawTransfer.FIND_BY_PLAYER_NAME_AND_TRANSFER_DATE, query = "SELECT r FROM RawTransfer r WHERE r.playerName=:"
				+ RawTransfer.PARAM_PLAYER_NAME + " AND r.transferDate=:" + RawTransfer.PARAM_TRANSFER_DATE) })
public class RawTransfer extends BaseEntity {

	public static final String SUM_OF_PURCHASES_BY_USER = "RawTransfer.sumOfPurchasesByUser";
	public static final String SUM_OF_SALES_BY_USER = "RawTransfer.sumOfSalesByUser";
	public static final String FIND_BY_PLAYER_NAME_AND_TRANSFER_DATE = "RawTransfer.findByNameAndTransferDate";
	public static final String FIND_LATEST = "RawTransfer.findLatest";
	public static final String PARAM_USER = "user";
	public static final String PARAM_PLAYER_NAME = "playerName";
	public static final String PARAM_TRANSFER_DATE = "transferDate";
	private String fromUser;
	private String toUser;
	private String playerName;
	private BigDecimal transferFee;
	private Date transferDate;

	public RawTransfer() {
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public BigDecimal getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(BigDecimal transferFee) {
		this.transferFee = transferFee;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
}
