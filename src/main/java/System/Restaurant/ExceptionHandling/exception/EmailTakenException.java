package System.Restaurant.ExceptionHandling.exception;

public class EmailTakenException extends RuntimeException {
	public  EmailTakenException(String email){ super("Email: " + email + " is already taken");}
}
