package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import model.User;
import service.entity.UserService;
import cdi.Controller;

@Named
@Controller
public class UserController implements Serializable{

	@Inject
	UserService userService;
	
	private User user;
	
	@PostConstruct
	public void initializeUserName(){
		this.user=new User();
	}
	
	public void saveUser(){
		userService.save(getUser());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
