package idv.lance.channel;

import lombok.Getter;

@Getter
public abstract class ChannelSubscriber implements Observer<Video> {

    String name;

    public ChannelSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Subject<Video> subject) {
        System.out.printf("%s 訂閱了 %s\n", getName(), subject.getName());
        subject.addObserver(this);
    }

    public void unSubscribe(Subject<Video> subject) {
        System.out.printf("%s 解除訂閱了 %s\n", getName(), subject.getName());
        subject.removeObserver(this);
    }

}
