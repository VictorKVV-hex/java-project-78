package exercise;

import hexlet.code.BaseSchema;
import hexlet.code.MapSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMapSchema {
    private MapSchema schema;
    Validator v;

    @BeforeEach
    public void beforeEach() {
        v = new Validator();
        schema = v.map();
    }
    @Test
    public void requiredTest() {
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));

        schema.sizeof(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }
    @Test
    public void shapeTest() {
// shape позволяет описывать валидацию для значений каждого ключа объекта Map
// Создаем набор схем для проверки каждого ключа проверяемого объекта
// Для значения каждого ключа - своя схема
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
// Настраиваем схему `MapSchema`. Передаем созданный набор схем в метод shape()
        schema.shape(schemas);
// Проверяем объекты
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(schema.isValid(human1)); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human2)); // true

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3)); // false

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertFalse(schema.isValid(human4)); // false
    }
    @Test
    public void shapeTest2() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required().minLength(4).contains("l"));
        schemas.put("age", v.number().positive());
        schema.shape(schemas);
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(schema.isValid(human1)); // true
        Map<String, Object> human2 = new HashMap<>();
        human1.put("name", "Nic");
        human1.put("age", 100);
        assertFalse(schema.isValid(human2)); // false
    }
}
