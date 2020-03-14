import java.util.Scanner;

public class LottoApplication {
    private static boolean APP_SUCCESS = false;

    public static void main(String[] args) {
        runUntilAppSuccess();
    }

    public static void runUntilAppSuccess() {
        while (!APP_SUCCESS) {
            run();
        }
    }

    public static void run() {
        final Scanner scanner = new Scanner(System.in);
        int countOfManualLotto;

        try {
            LottoService lottoService = new LottoService(
                    InputView.scanMoney(scanner),
                    countOfManualLotto = InputView.scanCountOfManualLotto(scanner),
                    InputView.scanNumbersOfManualLotto(scanner, countOfManualLotto),
                    new LottoSeller()
            );

            lottoService.purchaseLottoTicket();
            lottoService.printPurchaseResult();

            lottoService.setWinningLotto(
                    InputView.scanWinningLotto(scanner),
                    InputView.scanBonusNo(scanner)
            );

            lottoService.printWinningResult();

            APP_SUCCESS = true;
        } catch (OutOfConditionException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
