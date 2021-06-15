package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmailExistsException extends RuntimeException{
	
private String message;
	
	public EmailExistsException(String msg) {
		this.message = msg;
	}

}
