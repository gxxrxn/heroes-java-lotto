import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoTest {

    @Test
    public void 로또번호가_5개_이면_예외가_발생한다() {
        List<LottoNo> lottoNums = Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5)
        );

        assertThatThrownBy(() -> {
            new Lotto(lottoNums);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("6개의 로또 번호를 입력해 주세요.");
    }

    @Test
    public void 로또번호가_6개_이면_테스트가_성공한다() {
        List<LottoNo> lottoNums = Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(6)
        );

        assertThat(new Lotto(lottoNums).getLottoNums()).isEqualTo(lottoNums);
    }

    @Test
    public void 로또번호가_1부터_45_사이_수가_아니면_예외가_발생한다() {
        List<LottoNo> lottoNums = Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(99)
        );

        assertThatThrownBy(() -> {
            new Lotto(lottoNums);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 45 안의 정수를 입력하세요.");
    }

    @Test
    public void 로또번호가_중복되면_예외가_발생한다() {
        List<LottoNo> lottoNums = Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(1),
                new LottoNo(5),
                new LottoNo(9)
        );

        assertThatThrownBy(() -> {
            new Lotto(lottoNums);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복될 수 없습니다.");
    }

}