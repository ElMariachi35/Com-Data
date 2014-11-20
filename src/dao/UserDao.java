package dao;

import model.User;
import cdi.Dao;

@Dao
public class UserDao extends EntityDao<User> {

	@Override
	protected Class<User> getResponseClass() {
		return User.class;
	}
}
