package configuration.user;

import java.util.List;

import javax.inject.Inject;

import service.entity.EntityService;
import model.User;
import cdi.Service;
import dao.EntityDao;

@Service
public class UserService extends EntityService<User>{

	@Inject
	UserDao userDao;
	

	public List<User> findAll() {
		return userDao.findAll();
	}
	
	public void saveAll(List<User> userList) {
		for (User user : userList) {
			save(user);
		}
	}

	@Override
	protected EntityDao<User> getDao() {
		return userDao;
	}
}
