package waterball;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomEnumGenerator<T extends Enum<T>> {
    private static final Random PRNG = new Random();
    private final T[] values;

    public RandomEnumGenerator(Class<T> e) {
        values = e.getEnumConstants();
    }

    public List<T> times(int size) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            T t = randomEnum();
            list.add(t);
        }
        return list;
    }

    public T randomEnum() {
        return values[PRNG.nextInt(values.length)];
    }
}
