package System.Restaurant.ExceptionHandling;



import System.Restaurant.ExceptionHandling.exception.DishNameTakenException;
import System.Restaurant.ExceptionHandling.exception.EmailTakenException;
import System.Restaurant.ExceptionHandling.exception.UserNameTakenException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
public class AdController extends ResponseEntityExceptionHandler {

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException exception , HttpHeaders headers
		, HttpStatus status, WebRequest request){
		
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(new ExceptionMessage(
				HttpStatus.BAD_REQUEST.toString(),
				getValidationErrors(exception)
			));
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstaintViolationException(ConstraintViolationException exception){
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body( new ExceptionMessage(
				HttpStatus.BAD_REQUEST.toString(),
				getValidationErrors(exception)
			));
	}
	@ExceptionHandler(value = {
		DishNameTakenException.class,
		EmailTakenException.class,
		UserNameTakenException.class
		}
	)
	public ResponseEntity<Object> handleResourceAlreadyTakenException(Exception exception){
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body( new ExceptionMessage(
				HttpStatus.BAD_REQUEST.toString(),
				exception.getMessage()
			));
	}
	
	private List<ValidationError> getValidationErrors(MethodArgumentNotValidException exception){
		return exception.getBindingResult()
			.getFieldErrors()
			.stream()
			.map(error -> new ValidationError(error.getField(),error.getDefaultMessage()))
			.toList();
	}
	
	private List<ValidationError> getValidationErrors(ConstraintViolationException exception){
		return exception.getConstraintViolations()
			.stream()
			.map(error -> new ValidationError(error.getPropertyPath().toString(),error.getMessage()))
			.toList();
	}
	
	
}
