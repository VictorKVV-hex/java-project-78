package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    public List<Predicate<Object>> conditions = new ArrayList<>();
    public final boolean isValid(Object data) {
        for (Predicate<Object> condition : conditions) {
            if (!condition.test(data)) {
                return false;
            }
        }
        return true;
    }

}
