package exercise;

import hexlet.code.NumberSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNumberSchema {
    private NumberSchema schema;
    private static final int DIGIT_MINUS_TEN = -10;
    private static final int DIGIT_TEN = 10;
    private static final int DIGIT_ELEVEN = 10;
    private static final int DIGIT_FIVE = 5;
    @BeforeEach
    public void beforeEach() {
        Validator v = new Validator();
        schema = v.number();
    }
    @Test
    public void requiredTest() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("5"));
        assertTrue(schema.isValid(DIGIT_TEN));
        assertFalse(schema.isValid(DIGIT_MINUS_TEN));
        
        schema.range(DIGIT_FIVE, DIGIT_TEN);

        assertTrue(schema.isValid(DIGIT_FIVE));
        assertFalse(schema.isValid(DIGIT_ELEVEN));
    }
}
