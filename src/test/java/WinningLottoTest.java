import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    WinningLotto winningLotto;

    @Before
    public void 올바른_로또번호와_보너스번호를_넣으면_당첨로또가_생성된다() {
        List<LottoNo> lottoNums = Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(6)
        );
        LottoNo bonusNo = new LottoNo(7);
        assertThat(winningLotto = new WinningLotto(lottoNums, bonusNo))
                .isNotInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구입로또를_넣으면_당첨로또에_해당하는_로또번호_개수를_반환한다() {
        Lotto purchasedLotto = new Lotto(
                Arrays.asList(
                        new LottoNo(1),
                        new LottoNo(2),
                        new LottoNo(3),
                        new LottoNo(4),
                        new LottoNo(5),
                        new LottoNo(6)
                )
        );
        assertThat(winningLotto.getCountOfSameNumber(purchasedLotto)).isEqualTo(6);
    }

    @Test
    public void 구입로또를_넣으면_보너스_로또번호가_있는지_확인한다() {
        Lotto purchasedLotto = new Lotto(
                Arrays.asList(
                        new LottoNo(1),
                        new LottoNo(2),
                        new LottoNo(3),
                        new LottoNo(4),
                        new LottoNo(5),
                        new LottoNo(6)
                )
        );
        assertThat(winningLotto.isWinningBonus(purchasedLotto)).isEqualTo(false);

        Lotto purchasedLotto2 = new Lotto(
                Arrays.asList(
                        new LottoNo(1),
                        new LottoNo(2),
                        new LottoNo(3),
                        new LottoNo(4),
                        new LottoNo(5),
                        new LottoNo(7)
                )
        );
        assertThat(winningLotto.isWinningBonus(purchasedLotto2)).isEqualTo(true);
    }

}