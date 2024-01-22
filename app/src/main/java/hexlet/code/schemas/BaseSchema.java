package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private List<Predicate<Object>> conditions = new ArrayList<>();

    public final void addCondition(Predicate<Object> condition) {
        conditions.add(condition);
    }

    public final boolean isValid(Object data) {
        for (Predicate<Object> condition : conditions) {
            if (!condition.test(data)) {
                return false;
            }
        }
        return true;
    }

}
