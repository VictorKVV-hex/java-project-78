package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        addCheck("required", value -> value != null);
    }
    public final NumberSchema required() {
        required = true;
        return this;
    }
    public final NumberSchema positive() {
        addCheck("positive", value -> value > 0);
        return this;
    }
    public final NumberSchema range(int min, int max) {
        addCheck("range", value -> value >= min && value <= max);
        return this;
    }
}
