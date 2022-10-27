package qqqbbb.Coursework2;

import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/exam/java" )
public class JavaQuestionController
{
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService)
    {
        this.javaQuestionService = javaQuestionService;
    }

//    "/exam/java/add?question=QuestionText&answer=QuestionAnswer"
    @GetMapping( "/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer)
    {
        return javaQuestionService.add(question, answer);
    }

    // /exam/java/remove?question=QuestionText&answer=QuestionAnswer
    @GetMapping( "/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer)
    {
        return javaQuestionService.remove(new Question(question, answer));
    }

    // /exam/java
    @GetMapping( )
    public Collection<Question> getAllQuestions()
    {
        return javaQuestionService.getAll();
    }
}
