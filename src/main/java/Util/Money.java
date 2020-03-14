import java.util.Objects;

public class Money {
    public static final Money ZERO = Money.valueOf(0);
    private static final int MINIMUM_VALUE = 0;

    private final int value;

    private Money(int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("값이 " + MINIMUM_VALUE + " 보다 커야합니다.");
        }

        this.value = value;
    }

    public static Money valueOf(int value) {
        return new Money(value);
    }

    public Money divideBy(Money money) {
        if (money.equals(ZERO)) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return new Money(value / money.value);
    }

    public Money add(Money money) {
        return new Money(value + money.value);
    }

    public int intValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return value == ((Money) obj).intValue();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
