package ch2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DorDoor {
    private boolean open;

    public DorDoor() {
        this.open = false;
    }

    public void open() {
        log.info("door open");
        this.open = true;
    }

    public void close() {
        log.info("door close");
        this.open = false;
    }

    public boolean isOpen() {
        return open;
    }
}
