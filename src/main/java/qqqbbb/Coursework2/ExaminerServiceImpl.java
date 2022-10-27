package qqqbbb.Coursework2;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService
{

    private final QuestionService questionService;
    private final Random random;

    public ExaminerServiceImpl(QuestionService questionService)
    {
        this.questionService = questionService;
        random = new Random();
    }

    @Override
    public Collection<Question> getQuestions(int amount)
    {
        List<Question> questions = new ArrayList<>(questionService.getAll());
        List<Question> returnedQuestions = new ArrayList<>();

        if (amount < 1 || amount > questions.size())
            throw new BadNumberOfQuestionsException();

        while (amount > 0)
        {
            int randomIndex = random.nextInt(questions.size());
            Question randomQuestion = questions.remove(randomIndex);
            returnedQuestions.add(randomQuestion);
            amount--;
        }
        return returnedQuestions;
    }

}
