package racingcar;

import java.util.Map;

public class Race {

    private final Map<Integer, Round> race;

    public Race(Map<Integer, Round> race) {
        this.race = race;
    }

    public Round getLastRound() {
        return race.get(race.size());
    }
}
