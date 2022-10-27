package qqqbbb.Homework2dot13;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Employee Not Found")
class EmployeeNotFoundException extends RuntimeException
{
}
