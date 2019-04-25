package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.Record;

import java.util.ArrayList;

import static junit.framework.TestCase.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer actualAnswer;
    private Answer wrongAnswer;
    @Before
    public void setList()
    {
        actualAnswer = Answer.createAnswer("1 2 3 4");
        wrongAnswer = Answer.createAnswer("11 10 7 8");
    }
    @Test
    public void testExceptionMessage() {
        try {
            wrongAnswer.validate();
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (OutOfRangeAnswerException anOutOfRangeAnswerException) {
            assertThat(anOutOfRangeAnswerException.getMessage(), is("Answer format is incorrect"));
        }
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
    @Test
    public void should_return_1A2B_when_all_number_is_only_inculd(){
        String inputAnserStr = "1 3 2 9";
        String exceptValue = "1A2B";
        validateGuessNumber(inputAnserStr, exceptValue);
    }

    public void validateGuessNumber(String inputAnswerStr, String exceptValue) {
        Answer inputAnswer = Answer.createAnswer(inputAnswerStr);
        Record result = actualAnswer.check(inputAnswer);
        assertEquals(exceptValue,result.getValue());
    }

}