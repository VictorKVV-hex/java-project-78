package exercise;

import hexlet.code.StringSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStringShema {
    private StringSchema schema;
    private static final int INTEGER_DIGIT = 5;

    @BeforeEach
    public void beforeEach() {
        Validator v = new Validator();
        schema = v.string();
    }
    @Test
    public void RequiredTest() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(INTEGER_DIGIT));
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("String"));
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(INTEGER_DIGIT));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
    }
    @Test
    public void minLengthTest() {
        assertTrue(schema.minLength(INTEGER_DIGIT).isValid("whatthe"));
        assertFalse(schema.minLength(INTEGER_DIGIT).isValid("wha"));
    }
    @Test
    public void containsTest() {
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("???").isValid("what does the fox say"));
    }
}
