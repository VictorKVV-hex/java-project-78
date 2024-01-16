package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NumberSchema {

    private List<Predicate<Object>> conditions = new ArrayList<>();

    public NumberSchema required() {
        Predicate<Object> numberCondition = n -> (n instanceof Integer);
        conditions.add(numberCondition);
        return this;
    }
    public NumberSchema positive() {
        Predicate<Object> numberCondition = n -> (n instanceof Integer i && i > 0 || n == null);
        conditions.add(numberCondition);
        return this;
    }
    public NumberSchema range(Integer min, Integer max) {
        Predicate<Object> numberCondition = n ->  min <= (Integer) n && (Integer) n <= max;
        conditions.add(numberCondition);
        return this;
    }
    public boolean isValid(Object data) {
        for (Predicate<Object> condition : conditions) {
            if (!condition.test(data)) {
                return false;
            }
        }
        return true;
    }
}
