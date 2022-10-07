package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    private List<Car> cars = new ArrayList();
    private int moveCount;
    private Map<Integer, Map<String, Integer>> raceMap;

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

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public void setRaceMap(Map<Integer, Map<String, Integer>> raceMap) {
        this.raceMap = raceMap;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void run() {
        raceMap = new HashMap<>();

        for (int i = 1; i <= moveCount; i++) {
            Map<String, Integer> roundMap = roundStart();
            raceMap.put(i, roundMap);
        }
    }

    private Map<String, Integer> roundStart() {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int distance = car.move();
            map.put(car.getName(), distance);
        }

        return map;
    }

    public List getWinners() {
        Map<String, Integer> roundMap = raceMap.get(moveCount);
        List<String> keySet = new ArrayList<>(roundMap.keySet());
        List winners = new ArrayList();
        int winnerDistance = 0;

        for (String key : keySet) {
            int distance = roundMap.get(key);
            if (winnerDistance < distance) {
                winnerDistance = distance;
                winners.clear();
                winners.add(key);
            } else if (winnerDistance == distance) {
                winners.add(key);
            } else {

            }
        }

        return winners;
    }
}
