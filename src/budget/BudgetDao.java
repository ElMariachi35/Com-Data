package budget;

import java.util.List;

import model.User;
import cdi.Dao;
import dao.EntityDao;

@Dao
public class BudgetDao extends EntityDao<Budget> {

	@Override
	protected Class<Budget> getResponseClass() {
		return Budget.class;
	}

	public Budget findLatestBy(User user) {
		List<Budget> budgets = getEntityManager().createNamedQuery(Budget.FIND_LATEST_BY_USER, Budget.class)
				.setParameter(Budget.PARAM_USER, user).setMaxResults(1).getResultList();
		if (budgets.isEmpty()) {
			return null;
		}
		return budgets.get(0);
	}

}
