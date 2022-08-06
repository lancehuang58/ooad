package ch2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoteTest {
    @Test
    void test_door_button() {
        DorDoor door = new DorDoor();
        Remote re = new Remote(door);
        re.pressButton();
        Assertions.assertThat(door.isOpen()).isTrue();
    }
}