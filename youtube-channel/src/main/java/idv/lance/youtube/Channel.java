package idv.lance.youtube;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Channel {

    String name;

    private List<ChannelSubscriber> subscriberList;

    public Channel(String name) {
        this.name = name;
        this.subscriberList = new ArrayList<>();
    }

    public void addSubscriber(ChannelSubscriber channelSubscriber) {
        this.subscriberList.add(channelSubscriber);
    }

    public void publish(Video video) {
        for (ChannelSubscriber subscriber : subscriberList) {
            subscriber.accept(video);
        }
    }
}
