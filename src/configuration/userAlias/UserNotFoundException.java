package configuration.userAlias;


public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String userId) {
		System.out.println("User with id: "+userId+" not found!");
	}
}
