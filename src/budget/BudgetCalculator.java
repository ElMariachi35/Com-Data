package budget;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.inject.Inject;

import transfer.RawTransferService;
import model.User;
import cdi.Service;

@Service
public class BudgetCalculator implements Serializable{

	private static final String BONUS_PER_POINT = "10000";
	@Inject
	private RawTransferService rawTransferService;
	
	public BigDecimal calculateBudget(User user) {
		return calculateNetTransferSum(user).add(user.getStartCapital()).add(user.getBalanceOffset()).add(calculateBonus(user.getPoints()));
	}
	
	private BigDecimal calculateNetTransferSum(User user){
		BigDecimal accumulatedSales = rawTransferService.determineAccumulatedSales(user);
		BigDecimal accumulatedPurchases = rawTransferService.determineAccumulatedPurchases(user);
		return accumulatedSales.subtract(accumulatedPurchases);
	}

	private BigDecimal calculateBonus(long points) {
		return new BigDecimal(points).multiply(new BigDecimal(BONUS_PER_POINT));
	}

}
