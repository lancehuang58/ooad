package idv.lance.youtube;

public class Main {
    public static void main(String[] args) {
        ChannelSubscriber subscriber = new ChannelSubscriber("Alex");
        ChannelSubscriber subscriber2 = new ChannelSubscriber("Jimmy");
        Channel youtube = new Channel("Youtube");
        youtube.addSubscriber(subscriber);
        youtube.addSubscriber(subscriber2);
        youtube.publish(new Video("Iron Man", "Tony Stark", 211));

        Channel pdp = new Channel("PewDiePie");
        pdp.addSubscriber(subscriber);
        pdp.publish(new Video("Hidding Dragon", "Ann Lee", 342));
    }
}
