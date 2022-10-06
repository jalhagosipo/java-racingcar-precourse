package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 차의_이름은_5자_이하여야_한다() {
        String[] names = new String[]{"ping1", "ping2", "ping1123123"};
        String input = String.join(",", names);

        assertThatThrownBy(() -> new Race(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 몇_번의_이동을_할_것인지_입력할_수_있다() {
        String[] names = new String[]{"ping1", "ping2", "ping3"};
        String input = String.join(",", names);
        int moveCount = 5;

        Race race = new Race(input);
        race.setMoveCount(moveCount);

        assertThat(race.getMoveCount()).isEqualTo(moveCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void 한_번의_이동에_전진_또는_멈추는_행동을_할_수_있다(int number, int expected) {
        Car car = new Car("ping1");
        car.setRandomNumber(number);
        assertThat(car.move()).isEqualTo(expected);
    }
}
