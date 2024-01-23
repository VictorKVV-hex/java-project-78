package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Абстрактный класс, хранит "List<conditions>".
 * + Общий для наследователей метод "isValid", проверяющий в цикле все условия.
 */
public abstract class BaseSchema {
    private List<Predicate<Object>> conditions = new ArrayList<>();

    public final void addCondition(Predicate<Object> condition) {
        conditions.add(condition);
    }

    /**
     * Метод "isValid", проверяет в цикле все условия(предикаты) на "true".
     * @param data - Object - String, Integer or Map
     * @return возвращает "true", если все условия выполнились, "false", если хоть одно не выполнилось.
     */
    public final boolean isValid(Object data) {
        for (Predicate<Object> condition : conditions) {
            if (!condition.test(data)) {
                return false;
            }
        }
        return true;
    }

}
