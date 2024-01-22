package hexlet.code.schemas;

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
    public MapSchema shape(Map<String, BaseSchema> schemas) {

        for (Map.Entry<String, BaseSchema> entry : schemas.entrySet()) {
            // entry === "name", v.string().required()
            String key = entry.getKey(); // name
            BaseSchema shema = entry.getValue(); // v.string().required()

/*            Predicate<Object> strCondition = o -> {
                                                    Object obj = ((Map) o).get(key);
                                                    return shema.isValid(obj);
                                                    };*/
            Predicate<Object> strCondition = o -> shema.isValid(((Map) o).get(key));
//            Predicate<Object> strCondition = o -> entry.getValue().isValid(((Map<?, ?>) o).get(key));
            conditions.add(strCondition);
        }
        return this;
    }
}
