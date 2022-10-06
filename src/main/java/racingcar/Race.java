package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars = new ArrayList();

    public Race(String input) {
        String[] names = input.split(",");
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
