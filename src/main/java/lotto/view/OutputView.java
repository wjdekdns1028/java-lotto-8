package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.List;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printStatistics(LottoResult result, double yield) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        printLine(result, LottoRank.FIFTH);
        printLine(result, LottoRank.FOURTH);
        printLine(result, LottoRank.THIRD);
        printLine(result, LottoRank.SECOND);
        printLine(result, LottoRank.FIRST);
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    private void printLine(LottoResult result, LottoRank rank) {
        String display = rank.display();
        if (display.isEmpty()) {
            return;
        }
        System.out.println(display + " - " + result.countOf(rank) + "개");
    }
}
