package idv.lance.youtube;

public interface Subject<T> {
    void addObserver(Observer<T> observer);

    void removeObserver(Observer<T> channelSubscriber);

    String getName();
}
