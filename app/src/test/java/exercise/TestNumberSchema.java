package exercise;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestNumberSchema {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 100;
    private static final int IN_RANGE = 25;
    private static final int NEGATIVE = -5;
    private static final int MIN = 18;
    private static final int MAX = 35;

    @Test
    public void testNumberValidator() {
        NumberSchema schema = Validator.number();
        boolean actual;
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));

        schema.positive();
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
        assertTrue(schema.isValid(10));

        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));

        schema.range(6, 9);
        assertFalse(schema.isValid(5));
        assertFalse(schema.isValid(10));

        actual = schema.isValid(1);
        assertFalse(actual);
        actual = schema.isValid(null);
        assertFalse(actual);
        actual = schema.required().isValid(null);
        assertFalse(actual);
        actual = schema.required().positive().isValid(null);
        assertFalse(actual);
        actual = schema.required().isValid(null);
        assertFalse(actual);
    }


}
