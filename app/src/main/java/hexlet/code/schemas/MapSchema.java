package hexlet.code.schemas;

import java.util.Map;

import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public final MapSchema required() {
        Predicate<Object> strCondition = m -> m instanceof Map;

        addCondition(strCondition);
        return this;
    }
    public final MapSchema sizeof(Integer size) {
        Predicate<Object> strCondition = m -> ((Map<?, ?>) m).size() == size;
        addCondition(strCondition);
        return this;
    }
    public final MapSchema shape(Map<String, BaseSchema> schemas) {

        for (Map.Entry<String, BaseSchema> entry : schemas.entrySet()) {
            String key = entry.getKey();
            BaseSchema shema = entry.getValue();
            Predicate<Object> strCondition = o -> shema.isValid(((Map) o).get(key));
            addCondition(strCondition);
        }
        return this;
    }
}
