package System.Restaurant.ExceptionHandling;

public record ValidationError(
	String field,
	String message
) { }
