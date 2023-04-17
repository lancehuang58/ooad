package idv.lance.channel;

import lombok.Data;

@Data

public class Video {
    String title;
    String description;
    int length;

    public Video(String title, String description, int length) {
        this.title = title;
        this.description = description;
        this.length = length;
    }

    private Channel channel;

    public void like(ChannelSubscriber subscriber) {
        System.out.printf("%s 對影片 \"%s\"按讚\n", subscriber.getName(), title);
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
