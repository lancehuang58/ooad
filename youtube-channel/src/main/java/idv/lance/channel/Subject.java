package idv.lance.channel;

public interface Subject<T> {
    void addObserver(Observer<T> observer);

    void removeObserver(Observer<T> channelSubscriber);

    String getName();
}
