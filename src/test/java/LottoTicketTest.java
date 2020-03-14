import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    LottoTicket lottoTicket;

    @Before
    public void 구입금액_수동로또_자동로또를_넣으면_로또티켓이_생성된다() {
        Lottos autoLottos = new LottoPurchaseService().createAutoLottos(3);
        Lottos manualLottos = new LottoPurchaseService().createAutoLottos(2);

        lottoTicket = new LottoTicket(Money.valueOf(5000), autoLottos, manualLottos);
    }

    @Test
    public void 구입한_로또티켓의_티켓값을_알수있다() {
        assertThat(lottoTicket.getTicketPrice()).isEqualTo(Money.valueOf(5000));
    }

    @Test
    public void 구입한_로또티켓의_자동로또_수를_알수있다() {
        assertThat(lottoTicket.getCountOfAutoLotto()).isEqualTo(3);
    }

    @Test
    public void 구입한_로또티켓의_수동로또_수를_알수있다() {
        assertThat(lottoTicket.getCountOfManualLotto()).isEqualTo(2);
    }
}