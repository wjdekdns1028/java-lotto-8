package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = new LottoService();
    }

    public void start() {
        int amount = inputView.readPurchaseAmount();

        List<Lotto> purchased = lottoService.buyLottos(amount);
        outputView.printPurchasedLottos(purchased);

        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonus = inputView.readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

        LottoResult result = lottoService.calculateResult(purchased, winningLotto);
        double yield = lottoService.calculateYield(result, amount);
        outputView.printStatistics(result, yield);
    }
}
