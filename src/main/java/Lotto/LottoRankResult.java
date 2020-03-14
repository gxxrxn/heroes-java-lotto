import java.util.ArrayList;
import java.util.List;

public class LottoRankResult {
    private List<Rank> ranks;

    public LottoRankResult(WinningLotto winningLotto, LottoTicket lottoTicket) {
        this.ranks = new ArrayList<>();

        for (Lotto lotto : lottoTicket.getAllLottoGames()) {
            ranks.add(
                    Rank.valueOf(
                            winningLotto.getCountOfSameNumber(lotto),
                            winningLotto.isWinningBonus(lotto)
                    )
            );
        }
    }

    public int getCount(Rank rank) {
        return (int) ranks.stream().filter(t -> t.equals(rank)).count();
    }

    public Money getTotalWinningMoney() {
        Money earnings = Money.ZERO;

        for (Rank rank : ranks) {
            earnings = earnings.add(rank.getWinningMoney());
        }

        return earnings;
    }

    public double getEarningsRate(Money invest) {
        Money earnings = getTotalWinningMoney();

        return (double)(earnings.intValue()) / invest.intValue() * 100.0;
    }

}