package idv.lance.channel;

public class WaterBall extends ChannelSubscriber {
    public WaterBall(String name) {
        super(name);
    }

    @Override
    public void notify(Video video) {
        if (video.getLength() > 90) {
            video.like(this);
        }
    }
}
