package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private final Answer actualAnswer = Answer.createAnswer("1 2 3 4");
    private Game game;

    @Before
    public void setUp() throws Exception {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
    }
    @Test
    public void should_return_guessResult_when_input_answer(){
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");
        assertEquals("4A0B", game.guess(inputAnswer).getResult());
        assertEquals(inputAnswer, game.guess(inputAnswer).getInputAnswer());
    }
    @Test
    public void should_return_guess_history_when_input_several_times(){
        game.guess(Answer.createAnswer("1 2 5 6"));
        game.guess(Answer.createAnswer("1 3 5 6"));
        game.guess(Answer.createAnswer("0 2 5 6"));
        List<GuessResult> guessResults = game.guessHistory();
        assertThat(guessResults.size(),is(3));
        assertThat(guessResults.get(0).getResult(),is("2A0B"));
        assertThat(guessResults.get(2).getInputAnswer().toString(), is("0 2 5 6"));
    }
    @Test
    public void should_return_success_when_inputAnswer_is_correct(){
        game.guess(Answer.createAnswer("1 3 5 8"));
        assertThat(game.checkStatus(), is("continue"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        assertThat(game.checkStatus(), is("success"));
        game.guess(Answer.createAnswer("1 2 3 5"));
        game.guess(Answer.createAnswer("1 2 3 8"));
        game.guess(Answer.createAnswer("1 2 3 1"));
        game.guess(Answer.createAnswer("1 2 3 9"));
        assertThat(game.checkStatus(), is("fail"));
    }


}
