package budget;

public class NoBudgetFoundException extends RuntimeException {
	
	public NoBudgetFoundException(String message) {
		super(message);
	}
}
