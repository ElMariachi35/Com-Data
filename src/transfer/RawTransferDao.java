package transfer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import cdi.Dao;
import dao.EntityDao;

@Dao
public class RawTransferDao extends EntityDao<RawTransfer> {

	@Override
	protected Class<RawTransfer> getResponseClass() {
		return RawTransfer.class;
	}

	public BigDecimal determineAccumulatedPurchases(String userName) {
		BigDecimal result = getEntityManager().createNamedQuery(RawTransfer.SUM_OF_PURCHASES_BY_USER, BigDecimal.class)
				.setParameter(RawTransfer.PARAM_USER, userName).getSingleResult();
		if (result == null) {
			return BigDecimal.ZERO;
		}
		return result;
	}

	public BigDecimal determineAccumulatedSales(String userName) {
		BigDecimal result = getEntityManager().createNamedQuery(RawTransfer.SUM_OF_SALES_BY_USER, BigDecimal.class)
				.setParameter(RawTransfer.PARAM_USER, userName).getSingleResult();
		if (result == null) {
			return BigDecimal.ZERO;
		}
		return result;
	}

	public List<RawTransfer> findLatest(int numberOfResults) {
		return getEntityManager().createNamedQuery(RawTransfer.FIND_LATEST, RawTransfer.class).setMaxResults(numberOfResults)
				.getResultList();
	}

	public RawTransfer findBy(String playerName, Date transferDate) {
		List<RawTransfer> resultList = getEntityManager()
				.createNamedQuery(RawTransfer.FIND_BY_PLAYER_NAME_AND_TRANSFER_DATE, RawTransfer.class)
				.setParameter(RawTransfer.PARAM_PLAYER_NAME, playerName).setParameter(RawTransfer.PARAM_TRANSFER_DATE, transferDate)
				.getResultList();
		if (resultList.isEmpty()) {
			return null;
		}
		return resultList.get(0);
	}
}
