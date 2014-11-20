package service.entity;

import java.util.List;

import javax.inject.Inject;

import model.User;
import cdi.Service;
import dao.EntityDao;
import dao.UserDao;

@Service
public class UserService extends EntityService<User>{

	@Inject
	UserDao userDao;
	

	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	protected EntityDao<User> getDao() {
		return userDao;
	}
}
