import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final static int LOTTO_NUM_SIZE = 6;
    private final List<LottoNo> lottoNums;

    public Lotto(List<LottoNo> lottoNums) {
        checkSizeValid(lottoNums);
        checkNumbersValid(lottoNums);
        checkDuplicated(lottoNums);

        this.lottoNums = lottoNums;
    }

    public List<Integer> getNums() {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (LottoNo lottoNo : lottoNums) {
            lottoNumbers.add(lottoNo.getLottoNumber());
        }

        return lottoNumbers;
    }

    public List<LottoNo> getLottoNums() {
        return lottoNums;
    }

    public void checkSizeValid(List<LottoNo> lotto) {
        if (!isValidLottoSize(lotto)) {
            throw new IllegalArgumentException("6개의 로또 번호를 입력해 주세요.");
        }
    }

    public void checkNumbersValid(List<LottoNo> lotto) {
        if (lotto.contains(LottoNo.INVALID_LOTTO_NO)) {
            throw new IllegalArgumentException("1 ~ 45 안의 정수를 입력하세요.");
        }
    }

    public void checkDuplicated(List<LottoNo> lotto) {
        if (!isValidLottoSize(new HashSet<>(lotto))) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    boolean isValidLottoSize(List<LottoNo> lotto) {
        return lotto.size() == LOTTO_NUM_SIZE;
    }

    boolean isValidLottoSize(Set<LottoNo> lotto) {
        return lotto.size() == LOTTO_NUM_SIZE;
    }
}
