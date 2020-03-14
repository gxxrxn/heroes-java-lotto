import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {
    private final static int INVALID_NUM = 0;
    public final static LottoNo INVALID_LOTTO_NO = new LottoNo(INVALID_NUM);

    private int lottoNumber;

    public LottoNo(int lottoNumber) {
        try {
            this.lottoNumber = validateLottoNo(lottoNumber);
        } catch (IllegalArgumentException e) {
            this.lottoNumber = INVALID_NUM;
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private int validateLottoNo(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException();
        }

        return lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (lottoNumber == ((LottoNo)obj).lottoNumber)
            return true;

        return false;
    }

    @Override
    public int compareTo(LottoNo o) {
        return lottoNumber - o.lottoNumber;
    }
}
