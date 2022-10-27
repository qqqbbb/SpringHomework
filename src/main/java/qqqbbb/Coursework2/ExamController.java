package qqqbbb.Coursework2;

import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
public class ExamController
{
    ExaminerService examinerService;

    public ExamController(ExaminerService examinerService)
    {
        this.examinerService = examinerService;
    }

//    /exam/get/{amount}
    @GetMapping("/exam/get")
    Collection<Question> getQuestions(@RequestParam("amount") int amount)
    {
        return examinerService.getQuestions(amount);
    }
}
