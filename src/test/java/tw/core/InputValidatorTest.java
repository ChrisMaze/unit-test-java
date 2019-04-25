package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import static org.junit.Assert.*;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();
 @Test
    public void should_return_true_when_input_is_valid(){
     String input = "0 4 5 6";
     boolean flag = inputValidator.validate(input);
     assertTrue(flag);
 }
 @Test
    public void should_return_false_when_input_less_than_4(){
     String input = "0 4 5";
     boolean flag = inputValidator.validate(input);
     assertFalse(flag);
 }
 @Test
    public void should_return_false_when_input_greater_than_10(){
     String input = "0 4 15 6";
     boolean flag = inputValidator.validate(input);
     assertFalse(flag);
 }
    @Test
    public void should_return_false_when_input_has_the_same_number(){
        String input = "0 4 0 4";
        boolean flag = inputValidator.validate(input);
        assertFalse(flag);
    }
    @Test
    public void should_return_false_when_input_more_than_4(){
        String input = "0 4 5 6 8";
        boolean flag = inputValidator.validate(input);
        assertFalse(flag);
    }
}
