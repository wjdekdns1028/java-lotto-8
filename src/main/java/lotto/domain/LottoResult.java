package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> counts = new EnumMap<>(LottoRank.class);

    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            counts.put(rank, 0);
        }
    }

    public void add(LottoRank rank) {
        counts.put(rank, counts.get(rank) + 1);
    }

    public int countOf(LottoRank rank) {
        return counts.get(rank);
    }

    public long totalPrize(){
        long total = 0;
        for (LottoRank rank : counts.keySet()) {
            total += (long) rank.getPrize() * counts.get(rank);
        }
        return total;
    }

    public double yieldPercent(int purchaseAmount){
        if (purchaseAmount == 0) return 0.0;
        double yield = (double) totalPrize() / purchaseAmount * 100.0;
        return Math.round(yield * 10.0) / 10.0;
    }
}
