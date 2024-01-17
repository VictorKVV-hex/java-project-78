package hexlet.code;

import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.List;

@Getter
@Setter
public class StringSchema extends BaseSchema{

//    private List<Predicate<Object>> conditions = new ArrayList<>();

    public StringSchema required() {
/*        Predicate<Integer> lesserthan = i -> (i < 18);// Creating predicate
        System.out.println(lesserthan.test(10));// Calling Predicate method*/
        Predicate<Object> strCondition = s -> !(Objects.equals(s, "") || s == null) && s instanceof String;
        conditions.add(strCondition);
        return this;
    }
    public StringSchema minLength(int length) {
        Predicate<Object> strCondition = s -> ((String) s).length() > length;
        conditions.add(strCondition);
        return this;
    }
    public StringSchema contains(String content) {
        Predicate<Object> strCondition = s -> ((String) s).contains(content);
        conditions.add(strCondition);
        return this;
    }
/*    public boolean isValid(Object data) {
        for (Predicate<Object> condition : conditions) {
            if (!condition.test(data)) {
                return false;
            }
        }
        return true;
    }*/

}
