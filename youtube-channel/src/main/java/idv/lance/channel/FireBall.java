package idv.lance.channel;

public class FireBall extends ChannelSubscriber {
    public FireBall(String name) {
        super(name);
    }

    @Override
    public void notify(Video video) {
        if (video.getLength() <= 60) {
            Channel channel = video.getChannel();
            unSubscribe(channel);
        }
    }
}
