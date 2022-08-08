package System.Restaurant.ExceptionHandling.exception;

public class DishNameTakenException extends RuntimeException{
	public  DishNameTakenException(String dish){ super("Dish: " + dish + " is already taken");}
}
