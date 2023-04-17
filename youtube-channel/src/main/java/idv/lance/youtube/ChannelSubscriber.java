package idv.lance.youtube;

import lombok.Getter;

@Getter
public class ChannelSubscriber {

    String name;


    public ChannelSubscriber(String name) {
        this.name = name;
    }

    public void subscribe(Channel channel) {
        channel.addSubscriber(this);
    }

    public void accept(Video video) {
        System.out.printf("subscriber %s, video %s\n", name , video);
    }
}
