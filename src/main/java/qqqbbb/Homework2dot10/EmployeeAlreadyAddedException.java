package qqqbbb.Homework2dot10;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Employee Already Added")
public class EmployeeAlreadyAddedException extends RuntimeException
{
}