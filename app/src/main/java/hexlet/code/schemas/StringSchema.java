package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;
import java.util.function.Predicate;

@Getter
@Setter
public class StringSchema extends BaseSchema {

//    private List<Predicate<Object>> conditions = new ArrayList<>();

    public final StringSchema required() {
/*        Predicate<Integer> lesserthan = i -> (i < 18);// Creating predicate
        System.out.println(lesserthan.test(10));// Calling Predicate method*/
        Predicate<Object> strCondition = s -> !(Objects.equals(s, "") || s == null) && s instanceof String;
        addCondition(strCondition);
        return this;
    }
    public final StringSchema minLength(int length) {
        Predicate<Object> strCondition = s -> ((String) s).length() > length;
        addCondition(strCondition);
        return this;
    }
    public final StringSchema contains(String content) {
        Predicate<Object> strCondition = s -> ((String) s).contains(content);
        addCondition(strCondition);
        return this;
    }

}
