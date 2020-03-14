import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int countOfMatch;
    private Money winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = Money.valueOf(winningMoney);
    }

    public static Rank valueOf(int countOfGame, boolean matchBonus) {
        if (countOfGame == SECOND.getCountOfMatch()) {
            return getSecondOrThird(matchBonus);
        }

        return Arrays.stream(values())
                .filter(r -> countOfGame == r.countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    public static Rank[] valuesNotMiss() {
        return new Rank[]{FIRST, SECOND, THIRD, FOURTH, FIFTH};
    }

    private static Rank getSecondOrThird(boolean matchBonus) {
        if (matchBonus)
            return SECOND;
        return THIRD;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

}
