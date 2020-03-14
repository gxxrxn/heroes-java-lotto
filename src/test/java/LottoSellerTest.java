import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoSellerTest {
    List<List<LottoNo>> lottoNums;

    @Before
    public void 수동로또_번호들을_세팅한다() {
        lottoNums = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lottoNums.add(
                    Arrays.asList(
                            new LottoNo(1),
                            new LottoNo(2),
                            new LottoNo(3),
                            new LottoNo(4),
                            new LottoNo(5),
                            new LottoNo(6)
                    )
            );
        }
    }

    @Test
    public void 로또유저가_로또한장_금액보다_적은_돈을_가지고_있으면_예외가_발생한다() {
        LottoUser lottoUser = new LottoUser(Money.valueOf(100), 3, lottoNums);

        assertThatThrownBy(() -> {
            new LottoSeller().sellTicketTo(lottoUser);
        }).isInstanceOf(OutOfConditionException.class)
                .hasMessage(LottoPurchaseService.LOTTO_PRICE + "원 이상이 필요합니다.");
    }

    @Test
    public void 로또구입금액과_수동로또수를_넣으면_자동로또수를_알려준다() {
        assertThat(new LottoSeller().getCountOfAutoGame(Money.valueOf(10000), 3))
                .isEqualTo(7);
    }

    @Test
    public void 로또구입금액으로는_원하는_수동로또를_살_수_없으면_예외가_발생한다() {
        LottoUser lottoUser = new LottoUser(Money.valueOf(2000), 3, lottoNums);

        assertThatThrownBy(() -> {
            new LottoSeller().sellTicketTo(lottoUser);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액이 작아 원하는 만큼 수동 로또를 살 수 없습니다.");
    }

}