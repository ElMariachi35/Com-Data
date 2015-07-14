package configuration.user;

import model.User;
import cdi.Dao;
import dao.EntityDao;

@Dao
public class UserDao extends EntityDao<User> {

	@Override
	protected Class<User> getResponseClass() {
		return User.class;
	}
}
