import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoPurchaseService {
    public final static Money LOTTO_PRICE = Money.valueOf(1000);

    public static Money validatePurchase(Money inputMoney, int countOfManualLotto) throws OutOfConditionException {
        if (inputMoney.intValue() < LOTTO_PRICE.intValue()) {
            throw new OutOfConditionException(LOTTO_PRICE + "원 이상이 필요합니다.");
        }

        if (countOfManualLotto * LOTTO_PRICE.intValue() > inputMoney.intValue()) {
            throw new IllegalArgumentException("금액이 작아 원하는 만큼 수동 로또를 살 수 없습니다.");
        }

        return inputMoney;
    }

    public static Money calculateChange(Money inputMoney) {
        return Money.valueOf(inputMoney.intValue() % LOTTO_PRICE.intValue());
    }

    public Lotto createManualLotto(List<LottoNo> lottoNums) {
        Collections.sort(lottoNums);
        return new Lotto(lottoNums);
    }

    public Lotto createAutoLotto() {
        List<LottoNo> auto = new ArrayList<>(shuffleAllLottoNo().subList(0, 6));
        Collections.sort(auto);

        return new Lotto(auto);
    }

    public Lottos createAutoLottos(int countOfAutoLotto) {
        Lottos autoLottos = new Lottos();

        for (int i = 0; i < countOfAutoLotto; i++) {
            autoLottos.addLotto(
                    createAutoLotto()
            );
        }

        return autoLottos;
    }

    public LottoTicket createLottoTicket(Money ticketPrice, int countOfAutoLotto, Lottos manualLottos) {
        return new LottoTicket(
                ticketPrice,
                createAutoLottos(countOfAutoLotto),
                manualLottos);
    }

    private List<LottoNo> shuffleAllLottoNo() {
        List<LottoNo> lottoNums = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            lottoNums.add(new LottoNo(i));
        }
        Collections.shuffle(lottoNums);

        return lottoNums;
    }
}
