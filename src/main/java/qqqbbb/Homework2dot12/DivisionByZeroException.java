package qqqbbb.Homework2dot12;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Делить на 0 нельзя")
public class DivisionByZeroException extends IllegalArgumentException
{

}
