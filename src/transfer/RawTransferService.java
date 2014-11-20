package transfer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import model.User;
import model.UserAlias;
import service.entity.EntityService;
import cdi.Service;
import dao.EntityDao;

@Service
public class RawTransferService extends EntityService<RawTransfer> {

	@Inject
	RawTransferDao rawTransferDao;

	@Override
	protected EntityDao<RawTransfer> getDao() {
		return rawTransferDao;
	}

	public BigDecimal determineAccumulatedPurchases(User user) {
		return determinePurchases(user);
	}
	
	private BigDecimal determinePurchases(User user){
		BigDecimal purchases = BigDecimal.ZERO;
		purchases = purchases.add(rawTransferDao.determineAccumulatedPurchases(user.getName()));
		for (UserAlias alias : user.getUserAlias()) {
			purchases = purchases.add(rawTransferDao.determineAccumulatedPurchases(alias.getAlias()));
		}
		return purchases;
	}

	public BigDecimal determineAccumulatedSales(User user) {
		return determineSales(user);
	}
	
	private BigDecimal determineSales(User user){
		BigDecimal sales = BigDecimal.ZERO;
		sales = sales.add(rawTransferDao.determineAccumulatedSales(user.getName()));
		for (UserAlias alias : user.getUserAlias()) {
			sales = sales.add(rawTransferDao.determineAccumulatedSales(alias.getAlias()));
		}
		return sales;
	}
	

	public List<RawTransfer> findLatest(int numberOfResults) {
		return rawTransferDao.findLatest(numberOfResults);
	}

	public RawTransfer findBy(String playerName, Date transferDate) {
		return rawTransferDao.findBy(playerName, transferDate);
	}
}
