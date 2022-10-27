package qqqbbb.Coursework2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService
{

    private Set<Question> questions = new HashSet<>();
    private Random random = new Random();

    @Override
    public Question add(String question, String answer)
    {
//        System.out.println("JavaQuestionService add " + question);
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question)
    {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question)
    {
        for (Question q: questions)
        {
            if (q.equals(question))
            {
                questions.remove(question);
                return question;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public Collection<Question> getAll()
    {
        return questions;
    }

    @Override
    public Question getRandomQuestion()
    {
        int randomIndex = random.nextInt(questions.size());
        int i = 0;
        for(Question q : questions)
        {
            if (i == randomIndex)
                return q;

            i++;
        }
        throw new RuntimeException();
    }

    public int getNumberOfAvailableQuestions()
    {
        return questions.size();
    }
}
