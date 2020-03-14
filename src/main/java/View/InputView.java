import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class InputView {

    public static Money scanMoney(Scanner scanner) {
        System.out.println("\n구입금액을 입력해 주세요.");

        return Money.valueOf(Integer.parseInt(scanner.nextLine()));
    }

    public static int scanCountOfManualLotto(Scanner scanner) {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

    public static List<List<LottoNo>> scanNumbersOfManualLotto(Scanner scanner, int countOfManualGame) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");

        List<List<LottoNo>> manualLotto = new ArrayList<>();
        String input = scanner.nextLine();
        int count = countOfManualGame;

        while (!input.isEmpty() && count != 0) {
            count--;
            addScannedNumbers(manualLotto, input);
            input = scanner.nextLine();
        }

        return manualLotto;
    }

    private static void addScannedNumbers(List<List<LottoNo>> manualLotto, String input) {
        manualLotto.add(
                Arrays.asList(input.replaceAll(" ", "").split(","))
                        .stream()
                        .map(Integer::parseInt)
                        .map(LottoNo::new)
                        .collect(Collectors.toList())
        );
    }

    public static List<LottoNo> scanWinningLotto(Scanner scanner) {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");

        return Arrays.asList(scanner.nextLine()
                .replaceAll(" ", "")
                .split(","))
                .stream()
                .map(Integer::parseInt)
                .map(LottoNo::new)
                .collect(Collectors.toList());
    }

    public static LottoNo scanBonusNo(Scanner scanner) {
        System.out.println("보너스 볼을 입력해 주세요.");

        return new LottoNo(Integer.parseInt(scanner.nextLine()));
    }

}
