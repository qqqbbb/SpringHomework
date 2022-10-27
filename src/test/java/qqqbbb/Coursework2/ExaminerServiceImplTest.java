package qqqbbb.Coursework2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest
{
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    void getQuestionsTest()
    {
        List<Question> list = new ArrayList<>();
        when(questionService.getAll()).thenReturn(list);
        assertThrows(BadNumberOfQuestionsException.class, () -> out.getQuestions(-1));
        assertThrows(BadNumberOfQuestionsException.class, () -> out.getQuestions(0));
        assertThrows(BadNumberOfQuestionsException.class, () -> out.getQuestions(1));
        Question question1 = new Question("q", "a");
        Question question2 = new Question("qq", "aa");
        Question question3 = new Question("qqq", "aaa");
        list = Arrays.asList(question1, question2, question3);
        when(questionService.getAll()).thenReturn(list);
        assertDoesNotThrow(() -> out.getQuestions(1));
        assertThrows(BadNumberOfQuestionsException.class, () -> out.getQuestions(11));
        List<Question> testedList = new ArrayList<>(out.getQuestions(3));
        assert (testedList.contains(question1));
        assert (testedList.contains(question2));
        assert (testedList.contains(question3));
    }

}