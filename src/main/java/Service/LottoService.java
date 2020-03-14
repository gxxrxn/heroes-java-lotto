import java.util.List;

public class LottoService {
    LottoUser lottoUser;
    LottoSeller lottoSeller;
    LottoTicket purchasedLottoTicket = null;
    WinningLotto winningLotto = null;
    PurchaseResultView purchaseResultView = null;
    WinningResultView winningResultView = null;

    public LottoService(Money investMoney, int countOfManualLotto, List<List<LottoNo>> numbersOfManualLotto,
                        LottoSeller lottoSeller) {
        this.lottoUser = new LottoUser(investMoney, countOfManualLotto, numbersOfManualLotto);
        this.lottoSeller = lottoSeller;
    }
    
    public LottoTicket purchaseLottoTicket() throws OutOfConditionException {
        purchasedLottoTicket = lottoSeller.sellTicketTo(lottoUser);
        lottoUser.setLottoTicket(purchasedLottoTicket);
        
        return purchasedLottoTicket;
    }

    public void printPurchaseResult() {
        purchaseResultView = new PurchaseResultView();

        purchaseResultView.notifyIfChangeLeft(lottoSeller);
        purchaseResultView.printPurchasedTicket(lottoUser);
    }

    public void setWinningLotto(List<LottoNo> winningLottoNumbers, LottoNo bonusNo) {
        winningLotto =  new WinningLotto(winningLottoNumbers, bonusNo);
    }

    public void printWinningResult() {
        winningResultView = new WinningResultView();

        winningResultView.printWinningResult(winningLotto, purchasedLottoTicket);
        winningResultView.printEarningsRate(winningLotto, purchasedLottoTicket);
    }

}
