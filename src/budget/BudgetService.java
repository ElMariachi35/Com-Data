package budget;

import java.util.List;

import javax.inject.Inject;

import model.User;
import service.entity.EntityService;
import dao.EntityDao;

public class BudgetService extends EntityService<Budget> {
	@Inject
	BudgetDao budgetDao;

	@Override
	protected EntityDao<Budget> getDao() {
		return budgetDao;
	}

	public Budget findLatestBy(User user) {
		return budgetDao.findLatestBy(user);
	}

	public List<Budget> findAll() {
		return budgetDao.findAll();
	}
}
