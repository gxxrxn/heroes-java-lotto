public final class WinningResultView {
    private LottoRankResult lottoRankResult = null;

    private void setRankResult(WinningLotto winningLotto, LottoTicket lottoTicket) {
        if (lottoRankResult == null) {
            this.lottoRankResult = new LottoRankResult(winningLotto, lottoTicket);
        }
    }

    public void printWinningResult(WinningLotto winningLotto, LottoTicket lottoTicket) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");

        setRankResult(winningLotto, lottoTicket);

        for (Rank rank : Rank.valuesNotMiss()) {
            RankResult rankResult = new RankResult(rank);
            rankResult.countUp(lottoRankResult.getCount(rank));
            printRankResult(rankResult);
        }
    }

    public void printEarningsRate(WinningLotto winningLotto, LottoTicket lottoTicket) {
        setRankResult(winningLotto, lottoTicket);

        System.out.printf("총 수익률은 %.2f%%입니다.\n",
                lottoRankResult.getEarningsRate(
                        lottoTicket.getTicketPrice()
                )
        );
    }

    public void printRankResult(RankResult rankResult) {
        System.out.println(
                createMatchResultText(rankResult.getRank()) +
                        rankResult.getCountOfRank() +
                        "개"
        );
    }

    private String createMatchResultText(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return rank.getCountOfMatch() + "개 일치, 보너스볼 일치 (" + rank.getWinningMoney() + "원) - ";
        }

        return rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원) - ";
    }
}
