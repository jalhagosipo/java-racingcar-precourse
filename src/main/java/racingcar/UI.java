package racingcar;

import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UI {
    void start() {
        RaceGame raceGame = null;
        boolean isValidNames = false;
        while (!isValidNames) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = readLine();
            try {
                raceGame = new RaceGame(input);
                isValidNames = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }

        boolean isValidCount = false;
        while (!isValidCount) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                String count = readLine();
                raceGame.setMoveCount(Integer.parseInt(count));
                isValidCount = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }

        Race race = raceGame.run();
        System.out.println("실행 결과");
        for (int i = 1; i <= race.getSize(); i++) {
            Round round = race.getRound(i);
            Set<String> racerNames = round.getRacerNames();
            for (String racerName : racerNames) {
                String distanceStr = new String(new char[round.getDistance(racerName)]).replace("\0", "-");
                System.out.println(racerName + " : " + distanceStr);
            }
            System.out.println();
        }

        System.out.print("최종 우승자 : " + String.join(", ", raceGame.getWinners()));
   }
}
