public final class PurchaseResultView {
    public void notifyIfChangeLeft(LottoSeller seller) {
        if (!seller.getChange().equals(Money.ZERO)) {
            System.out.println("잔돈 " + seller.getChange() + "원이 남았습니다.");
            System.out.println();
        }
    }

    public void printPurchasedTicket(LottoUser lottoUser) {
        LottoTicket lottoTicket = lottoUser.getLottoTicket();

        System.out.println("수동으로 " + lottoTicket.getCountOfManualLotto() + "장, 자동으로 " + lottoTicket.getCountOfAutoLotto() + "개를 구매했습니다.");

        for (Lotto manualGame : lottoTicket.getManualLottos()) {
            System.out.println(manualGame.getNums());
        }

        for (Lotto autoGame : lottoTicket.getAutoLottos()) {
            System.out.println(autoGame.getNums());
        }

        System.out.println();
    }


}
