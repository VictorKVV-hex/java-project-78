package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NumberSchema {

    private List<Predicate<Object>> conditions = new ArrayList<>();

    public NumberSchema required() {
        Predicate<Object> numberCondition = n -> (n != null && n instanceof Integer);
        conditions.add(numberCondition);
        return this;
    }
    public NumberSchema positive() {
        Predicate<Object> numberCondition = n -> (Integer) n > 0 ;
        conditions.add(numberCondition);
        return this;
    }
    public NumberSchema range(Integer min, Integer max) {
        Predicate<Object> numberCondition = n ->  min <= (Integer) n && (Integer) n >= max;
        conditions.add(numberCondition);
        return this;
    }
}
