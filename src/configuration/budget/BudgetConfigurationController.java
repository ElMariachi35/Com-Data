package configuration.budget;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.Transactional;

import configuration.user.UserService;
import model.User;
import cdi.Controller;

@Controller
public class BudgetConfigurationController implements Serializable {

	@Inject
	private UserService userService;

	private List<User> userList = new ArrayList<User>();
	
	@PostConstruct
	public void initializeController(){
		userList= userService.findAll();
	}

	@Transactional
	public void save() {
		userService.saveAll(userList);
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
