package qqqbbb.homework2dot5;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Employee Not Found")
class EmployeeNotFoundException extends RuntimeException
{
}
