package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.model.Record;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer actualAnswer;
    //private Answer wrongAnswer;
    @Before
    public void setList()
    {
        actualAnswer = Answer.createAnswer("1 2 3 4");
        //wrongAnswer = Answer.createAnswer("5 6 7 8");
    }
    @Test
    public void should_return_0A0B_when_all_number_is_incorrect(){
        String inputAnswerStr = "5 6 7 8";
        String exceptValue = "0A0B";
        validateGuessNumber(inputAnswerStr, exceptValue);
    }
    @Test
    public void should_return_4A0B_when_all_number_is_correct(){
        String inputAnserStr = "1 2 3 4";
        String exceptValue = "4A0B";
        validateGuessNumber(inputAnserStr, exceptValue);
    }
    @Test
    public void should_return_0A4B_when_all_number_is_only_inculd(){
        String inputAnserStr = "4 3 2 1";
        String exceptValue = "0A4B";
        validateGuessNumber(inputAnserStr, exceptValue);
    }

    public void validateGuessNumber(String inputAnswerStr, String exceptValue) {
        Answer inputAnswer = Answer.createAnswer(inputAnswerStr);
        Record result = actualAnswer.check(inputAnswer);
        assertEquals(exceptValue,result.getValue());
    }

}