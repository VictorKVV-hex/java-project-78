package hexlet.code;

import java.util.Map;

import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
//        Predicate<Object> strCondition =
//        m -> m instanceof Map && ((Map<?, ?>) m).keySet().stream().anyMatch(Objects::isNull);
        Predicate<Object> strCondition = m -> m instanceof Map;
        conditions.add(strCondition);
        return this;
    }
    public MapSchema sizeof(Integer size) {
        Predicate<Object> strCondition = m -> ((Map<?, ?>) m).size() == size;
        conditions.add(strCondition);
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema> map) {

        return this;
    }
}
