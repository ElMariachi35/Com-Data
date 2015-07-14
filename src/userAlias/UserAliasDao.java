package userAlias;

import model.UserAlias;
import dao.EntityDao;

public class UserAliasDao extends EntityDao<UserAlias> {

	@Override
	protected Class<UserAlias> getResponseClass() {
		return UserAlias.class;
	}

}
