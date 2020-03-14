import java.util.List;

public class LottoUser {
    private Money investMoney;
    private int countOfManualLotto;
    private List<List<LottoNo>> numbersOfManualLottos;

    private LottoTicket lottoTicket;

    public LottoUser(Money investMoney, int countOfManualLotto, List<List<LottoNo>> numbersOfManualLottos) {
        this.investMoney = investMoney;
        this.countOfManualLotto = countOfManualLotto;
        this.numbersOfManualLottos = numbersOfManualLottos;
    }

    public void setLottoTicket(LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    public int getCountOfManualLotto() {
        return countOfManualLotto;
    }

    public List<List<LottoNo>> getNumbersOfManualLottos() {
        return numbersOfManualLottos;
    }

    public Money getInvestMoney() {
        return investMoney;
    }
}
