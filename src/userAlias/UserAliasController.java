package userAlias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;

import service.entity.UserService;
import model.User;
import model.UserAlias;
import cdi.Controller;

@Controller
public class UserAliasController implements Serializable {

	@Inject
	private UserService userService;
	@Inject
	private UserAliasService userAliasService;

	private List<User> userList = new ArrayList<User>();
	private String userId;
	private String userAlias;

	@PostConstruct
	public void initializeController() {
		userId = "";
		userAlias = "";
		setUserList(userService.findAll());
	}

	public String printAliase(User user) {
		String aliase = "";
		for (UserAlias alias : user.getUserAlias()) {
			aliase = aliase.concat(alias.getAlias()).concat(", ");
		}
		return aliase;
	}

	@Transactional
	public void addAlias() {
		UserAlias alias = new UserAlias();
		if(StringUtils.EMPTY.equals(userId)){
			return;
		}
		User user = userService.findById(Long.valueOf(userId));
		if (user == null) {
			throw new UserNotFoundException(userId);
		}
		alias.setUser(user);
		alias.setAlias(userAlias);
		userAliasService.save(alias);
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
}
