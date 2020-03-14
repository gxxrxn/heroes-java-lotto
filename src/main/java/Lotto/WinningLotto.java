import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNo bonusNo;

    public WinningLotto(List<LottoNo> winningLottoNumbers, LottoNo lottoNo) {
        if (winningLottoNumbers == null) {
            throw new IllegalArgumentException("'lotto' must not be null");
        }
        if (lottoNo == null) {
            throw new IllegalArgumentException("'lottoNo' must not be null");
        }

        this.winningLotto = new Lotto(winningLottoNumbers);
        this.bonusNo = lottoNo;
    }

    public int getCountOfSameNumber(Lotto purchasedLotto) {
        return (int) winningLotto.getLottoNums()
                .stream()
                .filter(purchasedLotto.getLottoNums()::contains)
                .count();
    }

    public boolean isWinningBonus(Lotto purchasedLotto) {
        return purchasedLotto.getLottoNums().contains(bonusNo);
    }
}
