package view;

import static constant.message.OutputMessage.*;

import constant.Badge;
import java.text.DecimalFormat;
import java.util.List;
import mapper.dto.DiscountDto;
import view.dto.OrderDto;

public class OutputView {
    
    private static final String KRW = "원";
    private static final String NONE = "없음";
    private static final String NAME_SEPARATOR = ": ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final DecimalFormat formatter = new DecimalFormat("###,###");
    
    public void startEventPlanner() {
        println(START_EVENT_PLANNER.get());
    }
    
    public void inputDateOfVisit() {
        println(INPUT_DATE_OF_VISIT.get());
    }
    
    public void inputMenuInformation() {
        println(INPUT_MENU_INFORMATION.get());
    }
    
    public void previewEventBenefits(int date) {
        println(PREVIEW_EVENT_BENEFITS.get(date));
    }
    
    public void orderMenu(List<OrderDto> orderDtos) {
        println();
        println(ORDER_MENU_HEADER.get());
        orderDtos.stream().forEach(orderDto -> optionalPrintln(orderDto, false));
    }
    
    public void totalOrderAmountBeforeDiscount(int principal) {
        println();
        println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT_HEADER.get());
        println(formatter.format(principal) + KRW);
    }
    
    public void giveawayMenu(OrderDto giveaway) {
        println();
        println(GIVEAWAY_MENU_HEADER.get());
        optionalPrintln(giveaway, giveaway.getCount() == 0);
    }
    
    public void benefitDetails(List<DiscountDto> discountDtos) {
        println();
        println(BENEFIT_DETAILS_HEADER.get());
        String message = generateBenefitDetailsMessage(discountDtos);
        optionalPrint(message, message.equals(""));
    }
    
    private static String generateBenefitDetailsMessage(List<DiscountDto> discountDtos) {
        StringBuilder message = new StringBuilder();
        for (var discountDto : discountDtos) {
            message.append(
                    discountDto.getName() +
                            NAME_SEPARATOR +
                            "-" +
                            formatter.format(discountDto.getBenefitAmount()) + KRW + "\n"
            );
        }
        return message.toString();
    }
    
    public void totalBenefitAmount(int totalBenefitAmount) {
        println();
        println(TOTAL_BENEFIT_AMOUNT_HEADER.get());
        if (totalBenefitAmount == 0) {
            println(formatter.format(totalBenefitAmount) + KRW);
            return;
        }
        println("-" + formatter.format(totalBenefitAmount) + KRW);
    }
    
    public void amountAfterDiscount(int amountAfterDiscount) {
        println();
        println(AMOUNT_AFTER_DISCOUNT_HEADER.get());
        println(formatter.format(amountAfterDiscount) + KRW);
    }
    
    public void eventBadge(Badge badge) {
        println();
        println(EVENT_BADGE_HEADER.get());
        optionalPrintln(badge.getName(), badge.equals(Badge.NONE));
    }
    
    public void exceptionMessage(String message) {
        println(message);
    }
    
    private void print(Object object) {
        System.out.print(object);
    }
    
    private void println() {
        System.out.print(LINE_SEPARATOR);
    }
    
    private void println(Object object) {
        System.out.print(object + LINE_SEPARATOR);
    }
    
    private void optionalPrint(Object object, boolean isNull) {
        if (isNull) {
            println(NONE);
            return;
        }
        print(object);
    }
    
    private void optionalPrintln(Object object, boolean isNull) {
        optionalPrint(object, isNull);
        if (!isNull) {
            println();
        }
    }
}
