package budget;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.User;
import cdi.Service;

@Service
public class BudgetUpdater implements Serializable {

	@Inject
	private BudgetCalculator budgetCalculator;
	@Inject
	private BudgetService budgetService;

	@Transactional
	public void updateBudgets(List<User> users) {
		for (User user : users) {
			Budget budget = budgetService.findLatestBy(user);
			if(budget==null){
				budget = new Budget();
				budget.setUser(user);
			}
			BigDecimal currentBudget = budgetCalculator.calculateBudget(user);
			budget.setBudget(currentBudget);
			budget.setTimeStamp(new Date());
			budgetService.save(budget);
		}
	}
}
