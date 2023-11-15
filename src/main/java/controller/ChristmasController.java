package controller;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import mapper.ChristmasMapper;
import view.InputView;
import view.OutputView;
import view.dto.OrderDto;

public class ChristmasController {
    
    private final InputView inputView;
    private final OutputView outputView;
    private final ChristmasMapper christmasMapper;
    
    public ChristmasController(
            InputView inputView,
            OutputView outputView,
            ChristmasMapper christmasMapper) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.christmasMapper = christmasMapper;
    }
    
    public void startPlanner() {
        outputView.startEventPlanner();
    }
    
    public void inputOrder() {
        outputView.inputDateOfVisit();
        repeat(christmasMapper::setVisitDate, inputView::readDate);
        outputView.inputMenuInformation();
        repeat(christmasMapper::setOrders, inputView::readMenus);
    }
    
    public void outputResult() {
        outputView.previewEventBenefits(christmasMapper.getDate());
        outputDetailResult();
    }
    
    private void outputDetailResult() {
        outputOrderMenu();
        outputTotalOrderAmountBeforeDiscount();
        outputGiveawayMenu();
        outputBenefitDetails();
        outputTotalBenefitAmount();
        outputAmountAfterDiscount();
        outputEventBadge();
    }
    
    private void outputOrderMenu() {
        outputView.orderMenu(christmasMapper.getOrders());
    }
    
    private void outputTotalOrderAmountBeforeDiscount() {
        outputView.totalOrderAmountBeforeDiscount(christmasMapper.getOrderAmountBeforeDiscount());
    }
    
    private void outputGiveawayMenu() {
        outputView.giveawayMenu(christmasMapper.getGiveaway());
    }
    
    private void outputBenefitDetails() {
        outputView.benefitDetails(christmasMapper.getBenefitDetails());
    }
    
    private void outputTotalBenefitAmount() {
        outputView.totalBenefitAmount(christmasMapper.getTotalBenefitAmount());
    }
    
    private void outputAmountAfterDiscount() {
        outputView.amountAfterDiscount(christmasMapper.getAmountAfterDiscount());
    }
    
    private void outputEventBadge() {
        outputView.eventBadge(christmasMapper.getEventBadge());
    }
    
    private <T> void repeat(Consumer<T> consumer, Supplier<T> parameterSupplier) {
        try {
            consumer.accept(parameterSupplier.get());
        } catch (IllegalArgumentException e) {
            outputView.exceptionMessage(e.getMessage());
            repeat(consumer, parameterSupplier);
        }
    }
}
