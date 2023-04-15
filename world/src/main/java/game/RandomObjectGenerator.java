package game;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class RandomObjectGenerator<T> implements Generator<T>, Iterable<T> {

  private int size = 0;

  public RandomObjectGenerator() {}

  public RandomObjectGenerator(int size) {
    this.size = size;
  }

  abstract List<Class<? extends T>> getClazz();

  public T next() {
    T t;
    try {
      int i = ThreadLocalRandom.current().nextInt(getClazz().size());
      t = getClazz().get(i).getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return t;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      @Override
      public boolean hasNext() {
        return size != 0;
      }

      @Override
      public T next() {
        T c = RandomObjectGenerator.this.next();
        size--;
        return c;
      }
    };
  }
}
