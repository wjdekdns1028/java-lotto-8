package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int PRICE_PER_TICKET = 1_000;

    public List<Lotto> buyLottos(int purchaseAmount) {
        int count = purchaseAmount / PRICE_PER_TICKET;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .toList();
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }

    public LottoResult calculateResult(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : purchasedLottos) {
            LottoRank rank = winningLotto.match(lotto);
            result.add(rank);
        }
        return result;
    }

    public double calculateYield(LottoResult result, int purchaseAmount) {
        return result.yieldPercent(purchaseAmount);
    }
}
