package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarTest {

    @Test
    void n대의_차_이름_입력() {
        String[] names = new String[]{"ping1", "ping2", "ping3"};
        String input = String.join(",", names);
        Race race = new Race(input);
        List<Car> cars = race.getCars();
        for (int i = 0; i<cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(names[i]);
        }

    }
}
