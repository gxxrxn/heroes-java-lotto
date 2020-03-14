import java.util.List;

public class LottoSeller {
    private LottoPurchaseService lottoPurchaseService;
    private Money change;

    public LottoSeller() {
        change = Money.ZERO;
        lottoPurchaseService = new LottoPurchaseService();
    }

    public LottoTicket sellTicketTo(LottoUser lottoUser) throws OutOfConditionException {
        Money investMoney = LottoPurchaseService
                .validatePurchase(
                        lottoUser.getInvestMoney(),
                        lottoUser.getCountOfManualLotto()
                );

        this.change = LottoPurchaseService
                .calculateChange(investMoney);

        return lottoPurchaseService
                .createLottoTicket(
                        investMoney,
                        getCountOfAutoGame(investMoney, lottoUser.getCountOfManualLotto()),
                        changeToLottos(lottoUser.getNumbersOfManualLottos())
                );
    }

    public int getCountOfAutoGame(Money investMoney, int countOfManualLotto) {
        return investMoney.divideBy(LottoPurchaseService.LOTTO_PRICE).intValue()
                - countOfManualLotto;
    }

    private Lottos changeToLottos(List<List<LottoNo>> numbers0fManualLottos) {
        Lottos manualLottos = new Lottos();

        for (List<LottoNo> lottoNums : numbers0fManualLottos) {
            manualLottos.addLotto(
                    lottoPurchaseService.createManualLotto(lottoNums)
            );
        }

        return manualLottos;
    }

    public Money getChange() {
        return change;
    }
}
