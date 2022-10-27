package qqqbbb.Coursework2;

import org.junit.jupiter.api.Test;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest
{
    JavaQuestionService out = new JavaQuestionService();

    @Test
    void testAdd()
    {
        assertEquals(out.getNumberOfAvailableQuestions(), 0);
        Question questionExpected = new Question("q", "a");
        Question questionReturned = out.add("q", "a");
        assertEquals(out.getNumberOfAvailableQuestions(), 1);
        assertEquals(questionExpected, questionReturned);
        Question questionReturned1 = out.add(questionExpected);
        assertEquals(out.getNumberOfAvailableQuestions(), 1);
        assertEquals(questionExpected, questionReturned1);
        Question questionReturned2 = out.add("a", "q");
        assertEquals(out.getNumberOfAvailableQuestions(), 2);
        assertNotEquals(questionExpected, questionReturned2);
    }

    @Test
    void testRemove()
    {
        Question questionExpected = new Question("q", "a");
        out.add("q", "a");
        Question questionReturned = out.remove(questionExpected);
        assertEquals(questionExpected, questionReturned);
        assertEquals(out.getNumberOfAvailableQuestions(), 0);
    }

    @Test
    void testGetAll()
    {
        Question questionExpected1 = new Question("q", "a");
        Question questionExpected2 = new Question("qq", "aa");
        Question questionExpected3 = new Question("qqq", "aaa");
        out.add(questionExpected1);
        out.add(questionExpected2);
        out.add(questionExpected3);
        Collection<Question> returnedList = out.getAll();
        assert (returnedList.contains(questionExpected1));
        assert (returnedList.contains(questionExpected2));
        assert (returnedList.contains(questionExpected3));
    }

    @Test
    void testGetRandomQuestion()
    {
        Question questionExpected1 = new Question("q", "a");
        Question questionExpected2 = new Question("qq", "aa");
        Question questionExpected3 = new Question("qqq", "aaa");
        out.add(questionExpected1);
        out.add(questionExpected2);
        out.add(questionExpected3);
        Question randomQuestion = out.getRandomQuestion();
        if (randomQuestion.equals(questionExpected1) || randomQuestion.equals(questionExpected2) || randomQuestion.equals(questionExpected3))
            assert (true);
        else
            assert (false);
    }

}