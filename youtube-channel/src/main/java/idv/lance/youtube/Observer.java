package idv.lance.youtube;

public interface Observer<T> {
    void notify(T t);
    void subscribe(Subject<T> subject);

    void unSubscribe(Subject<T> subject);
}
