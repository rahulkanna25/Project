package com.exception;
<<<<<<< HEAD
import java.time.LocalDateTime;

=======
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        Response response = new Response(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
    	
        Response response = new Response("SERVER_ERROR", "An unexpected error occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
<<<<<<< HEAD
    
    @ExceptionHandler(DriverNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(DriverNotFoundException exe)
	{
		ErrorResponse err= new ErrorResponse();
	    err.setTimestamp(LocalDateTime.now());
		err.setStatus( HttpStatus.NOT_FOUND);
		err.setMessage( exe.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(OrderNotFoundException exe)
	{
		ErrorResponse err= new ErrorResponse();
	    err.setTimestamp(LocalDateTime.now());
		err.setStatus( HttpStatus.NOT_FOUND);
		err.setMessage( exe.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<ErrorResponse> handleException(EmptyListException exe)
	{
		ErrorResponse err= new ErrorResponse();
	    err.setTimestamp(LocalDateTime.now());
		err.setStatus( HttpStatus.NOT_FOUND);
		err.setMessage( exe.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(CustomerNotFoundException exe)
	{
		ErrorResponse err= new ErrorResponse();
	    err.setTimestamp(LocalDateTime.now());
		err.setStatus( HttpStatus.NOT_FOUND);
		err.setMessage( exe.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RestaurantNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(RestaurantNotFoundException exe)
	{
		ErrorResponse err= new ErrorResponse();
	    err.setTimestamp(LocalDateTime.now());
		err.setStatus( HttpStatus.NOT_FOUND);
		err.setMessage( exe.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler()
	public ResponseEntity<ErrorResponse> handleException(Exception exe)
	{
		ErrorResponse err= new ErrorResponse();
	    err.setTimestamp(LocalDateTime.now());
		err.setStatus( HttpStatus.BAD_REQUEST);
		err.setMessage( exe.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.BAD_REQUEST);
	}
	

}

=======
}
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
