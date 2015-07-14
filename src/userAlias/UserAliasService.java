package userAlias;

import javax.inject.Inject;

import model.UserAlias;
import service.entity.EntityService;
import cdi.Service;
import dao.EntityDao;

@Service
public class UserAliasService extends EntityService<UserAlias>{

	@Inject
	private UserAliasDao userAliasDao;
	
	@Override
	protected EntityDao<UserAlias> getDao() {
		return userAliasDao;
	}
	
	

}
