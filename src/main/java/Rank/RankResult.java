public class RankResult {
    private Rank rank;
    private int countOfRank;

    RankResult(Rank rank) {
        this.rank = rank;
        this.countOfRank = 0;
    }

    public Rank getRank() {
        return rank;
    }

    public int getCountOfRank() {
        return countOfRank;
    }

    public void countUp(int count) {
        countOfRank += count;
    }
}
