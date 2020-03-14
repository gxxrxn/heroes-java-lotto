import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    public void 돈의_값이_0_보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            Money.valueOf(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값이 " + Money.ZERO + " 보다 커야합니다.");
    }

    @Test
    public void 돈을_0으로_나누려고_하면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            Money.valueOf(1000).divideBy(Money.ZERO);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }

    @Test
    public void 두_돈을_더할_수_있다() {
        assertThat(Money.valueOf(1000).add(Money.valueOf(500)))
                .isEqualTo(Money.valueOf(1500));
    }

    @Test
    public void 돈_액수가_같으면_같은_객체이다() {
        assertThat(Money.valueOf(1000)).isEqualTo(Money.valueOf(1000));
        assertThat(Money.valueOf(5000)).isEqualTo(Money.valueOf(5000));
        assertThat(Money.valueOf(10000)).isEqualTo(Money.valueOf(10000));
    }

}