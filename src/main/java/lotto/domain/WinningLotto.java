package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public LottoRank match(Lotto userLotto) {
        int matchCount = winningLotto.countMatch(userLotto);
        boolean bonusMatch = userLotto.contains(bonusNumber);
        return LottoRank.of(matchCount, bonusMatch);
    }
}
