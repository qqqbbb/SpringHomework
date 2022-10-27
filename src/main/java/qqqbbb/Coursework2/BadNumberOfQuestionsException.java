package qqqbbb.Coursework2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad Number Of Questions")
public class BadNumberOfQuestionsException extends RuntimeException
{

}
