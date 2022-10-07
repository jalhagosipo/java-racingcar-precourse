package racingcar;

import java.util.*;

public class RaceGame {

    private List<Car> cars = new ArrayList();
    private int moveCount;
    private Map<Integer, Round> raceMap;

    public RaceGame(String input) {
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

    public void setRaceMap(Map<Integer, Round> raceMap) {
        this.raceMap = raceMap;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void run() {
        raceMap = new HashMap<>();

        for (int i = 1; i <= moveCount; i++) {
            Round roundMap = roundStart();
            raceMap.put(i, roundMap);
        }
    }

    private Round roundStart() {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int distance = car.move();
            map.put(car.getName(), distance);
        }

        return new Round(map);
    }

    public List getWinners() {
        Round round = raceMap.get(moveCount);
        Set<String> racerNames = round.getRacerNames();
        List winners = new ArrayList();
        int winnerDistance = 0;

        for (String racer : racerNames) {
            int distance = round.getDistance(racer);
            if (winnerDistance < distance) {
                winnerDistance = distance;
                winners.clear();
                winners.add(racer);
            } else if (winnerDistance == distance) {
                winners.add(racer);
            }
        }

        return winners;
    }
}
