import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {

    @Test
    public void 로또번호가_1부터_45사이_수가_아니면_INVALID_LOTTO_NO_로_초기화된다() {
        assertThat(new LottoNo(0)).isEqualTo(LottoNo.INVALID_LOTTO_NO);

        assertThat(new LottoNo(1)).isNotEqualTo(LottoNo.INVALID_LOTTO_NO);
        assertThat(new LottoNo(2)).isNotEqualTo(LottoNo.INVALID_LOTTO_NO);
        assertThat(new LottoNo(44)).isNotEqualTo(LottoNo.INVALID_LOTTO_NO);
        assertThat(new LottoNo(45)).isNotEqualTo(LottoNo.INVALID_LOTTO_NO);

        assertThat(new LottoNo(46)).isEqualTo(LottoNo.INVALID_LOTTO_NO);
        assertThat(new LottoNo(50)).isEqualTo(LottoNo.INVALID_LOTTO_NO);
        assertThat(new LottoNo(100)).isEqualTo(LottoNo.INVALID_LOTTO_NO);
    }

    @Test
    public void 로또번호_값이_같으면_같은_객체_이다() {
        assertThat(new LottoNo(1)).isEqualTo(new LottoNo(1));
        assertThat(new LottoNo(2)).isEqualTo(new LottoNo(2));
        assertThat(new LottoNo(44)).isEqualTo(new LottoNo(44));
        assertThat(new LottoNo(45)).isEqualTo(new LottoNo(45));
    }

    @Test
    public void 로또번호_값이_다르면_다른_객체_이다() {
        assertThat(new LottoNo(1)).isNotEqualTo(new LottoNo(2));
        assertThat(new LottoNo(2)).isNotEqualTo(new LottoNo(3));
        assertThat(new LottoNo(43)).isNotEqualTo(new LottoNo(44));
        assertThat(new LottoNo(44)).isNotEqualTo(new LottoNo(45));
    }

}