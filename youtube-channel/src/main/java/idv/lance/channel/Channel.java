package idv.lance.channel;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Channel implements Subject<Video>{

    String name;

    private List<Observer<Video>> observers;

    public Channel(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public void upload(Video video) {
        video.setChannel(this);
        System.out.printf("頻道 %s 上架了一則新影片 %s\n", getName(), video.getTitle());
        for (Observer<Video> subscriber : observers) {
            subscriber.notify(video);
        }
    }

    @Override
    public void addObserver(Observer<Video> observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<Video> observer) {
        this.observers = this.observers
                .stream().filter(t -> !observer.equals(t)).collect(Collectors.toList());
    }
}
