package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars = new ArrayList();

    public Race(String input) {
        String[] names = input.split(",");
        validateNames(names);
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    private void validateNames(String[] names) {
        for (String name : names) {
            checkNameSize(name);
        }
    }

    private void checkNameSize(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 차 이름은 5자 이하여야 합니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
