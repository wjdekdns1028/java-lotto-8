package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;

    LottoRank(int matchCount, boolean requiresBonus, int prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public static LottoRank of(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatched) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return MISS;
    }

    public int getPrize() {
        return prize;
    }

    public String display() {
        if (this == FIRST) return "6개 일치 (2,000,000,000원)";
        if (this == SECOND) return "5개 일치, 보너스 볼 일치 (30,000,000원)";
        if (this == THIRD) return "5개 일치 (1,500,000원)";
        if (this == FOURTH) return "4개 일치 (50,000원)";
        if (this == FIFTH) return "3개 일치 (5,000원)";
        return "";
    }
}
