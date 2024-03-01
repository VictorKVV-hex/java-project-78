package exercise;

import hexlet.code.schemas.StringSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestStringShema {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 100;
    private static final int IN_RANGE = 25;
    private static final int NEGATIVE = -5;
    private static final int MIN = 18;
    private static final int MAX = 35;
    @Test
    public void testValidStringSchema() {
        StringSchema schema = Validator.string();
        boolean actual;
        actual = schema.isValid("");
        assertTrue(actual);
        actual = schema.isValid(null);
        assertTrue(actual);

        assertTrue(schema.isValid(""));

        schema.required();
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));

        schema.required().contains("ab").minLength(5);
        actual = schema.required().contains("ab").minLength(5).isValid("abcdef");
        assertTrue(actual);
        actual = schema.required().isValid(null);
        assertFalse(actual);
        actual = schema.required().isValid("");
        assertFalse(actual);
        actual = schema.isValid(String.valueOf(5));
        assertFalse(actual);
        actual = schema.minLength(6).isValid("abcdefgh");
        assertTrue(actual);
        actual = schema.minLength(10).isValid("ab");
        assertFalse(actual);

    }
}
