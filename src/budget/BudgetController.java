package budget;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import configuration.user.UserService;
import model.User;
import cdi.Controller;

@Controller
public class BudgetController implements Serializable {

	@Inject
	private BudgetUpdater budgetUpdater;
	@Inject
	private UserService userService;
	@Inject
	private BudgetService budgetService;
	
	private List<Budget> budgets;

	@PostConstruct
	public void initializeBudgets() {
		budgets = findAllBudgets();
	}
	
	public void updateBudgets() {
		List<User> users = userService.findAll();
		budgetUpdater.updateBudgets(users);
		budgets = findAllBudgets();
	}

	private List<Budget> findAllBudgets() {
		return budgetService.findAll();
	}
	
	public List<Budget> getBudgets() {
		return budgets;
	}

	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
	}

}
