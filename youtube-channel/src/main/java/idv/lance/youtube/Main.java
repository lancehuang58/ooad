package idv.lance.youtube;

public class Main {
    public static void main(String[] args) {
        Channel waterBall = new Channel("水球軟體學院");
        Channel pewDiePie = new Channel("PewDiePie");

        Observer<Video> subscriber = new WaterBall("水球");
        Observer<Video> subscriber2 = new FireBall("火球");

        subscriber.subscribe(waterBall);
        subscriber.subscribe(pewDiePie);

        subscriber2.subscribe(waterBall);
        subscriber2.subscribe(pewDiePie);

        waterBall.upload(new Video("C1M1S2", "This world is OOAD", 120));
        pewDiePie.upload(new Video("Hello Guys", "Clickbait", 30));
        waterBall.upload(new Video("C1M1S3", "物件VS物件", 60));
        pewDiePie.upload(new Video("Minecraft", "Let's play Minecraft", 1800));
    }
}
