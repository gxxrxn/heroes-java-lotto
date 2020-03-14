import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private Money ticketPrice;
    private Lottos autoLottos;
    private Lottos manualLottos;

    public LottoTicket(Money ticketPrice, Lottos autoLottos, Lottos manualLottos) {
        this.ticketPrice = ticketPrice;
        this.autoLottos = autoLottos;
        this.manualLottos = manualLottos;
    }

    public List<Lotto> getAllLottoGames() {
        List<Lotto> lottos = new ArrayList<>();

        lottos.addAll(getManualLottos());
        lottos.addAll(getAutoLottos());

        return lottos;
    }

    public List<Lotto> getAutoLottos() {
        return autoLottos.getLottos();
    }

    public List<Lotto> getManualLottos() {
        return manualLottos.getLottos();
    }

    public int getCountOfAutoLotto() {
        return autoLottos.getSize();
    }

    public int getCountOfManualLotto() {
        return manualLottos.getSize();
    }

    public Money getTicketPrice() {
        return ticketPrice;
    }
}
