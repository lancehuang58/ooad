package ch2;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class Remote {
    private DorDoor door;

    public Remote(DorDoor door) {
        this.door = door;
    }

    public void pressButton() {
        log.info("user press button");
        if (door.isOpen()) {
            door.close();
        } else {
            door.open();
            final Timer timer = new Timer();
            timer.schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            door.close();
                            log.info("door close automatically");
                            timer.cancel();
                        }
                    }, 1);
        }
    }
}
