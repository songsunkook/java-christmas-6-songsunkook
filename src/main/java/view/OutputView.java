package view;

import static constant.message.OutputMessage.*;

import constant.Badge;
import java.text.DecimalFormat;
import java.util.List;
import mapper.dto.DiscountDto;
import view.dto.OrderDto;

public class OutputView {
    
    private static final DecimalFormat formatter = new DecimalFormat("###,###");
    private static final String KRW = "원";
    private static final String NONE = "없음";
    private static final String NAME_SEPARATOR = ": ";
    
    public void startEventPlanner() {
        System.out.print(START_EVENT_PLANNER.get());
    }
    
    public void inputDateOfVisit() {
        System.out.print(INPUT_DATE_OF_VISIT.get());
    }
    
    public void inputMenuInformation() {
        System.out.print(INPUT_MENU_INFORMATION.get());
    }
    
    public void previewEventBenefits(int date) {
        System.out.print(PREVIEW_EVENT_BENEFITS.get(date));
    }
    
    public void orderMenu(List<OrderDto> orderDtos) {
        System.out.print(ORDER_MENU_HEADER.get());
        orderDtos.stream().forEach(System.out::println);
    }
    
    public void totalOrderAmountBeforeDiscount(int principal) {
        System.out.print(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT_HEADER.get());
        System.out.println(formatter.format(principal) + KRW);
    }
    
    public void giveawayMenu(OrderDto giveaway) {
        System.out.print(GIVEAWAY_MENU_HEADER.get());
        optionalPrint(giveaway, giveaway.getCount() == 0);
    }
    
    private void optionalPrint(Object object, boolean isNull) {
        if (isNull) {
            System.out.println(NONE);
            return;
        }
        System.out.println(object);
    }
    
    public void benefitDetails(List<DiscountDto> discountDtos) {
        System.out.print(BENEFIT_DETAILS_HEADER.get());
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
                            formatter.format(discountDto.getBenefitAmount()) + KRW
            );
        }
        return message.toString();
    }
    
    public void totalBenefitAmount(int totalBenefitAmount) {
        System.out.print(TOTAL_BENEFIT_AMOUNT_HEADER.get());
        if (totalBenefitAmount == 0) {
            System.out.println(formatter.format(totalBenefitAmount) + KRW);
            return;
        }
        System.out.println("-" + formatter.format(totalBenefitAmount) + KRW);
    }
    
    public void amountAfterDiscount(int amountAfterDiscount) {
        System.out.print(AMOUNT_AFTER_DISCOUNT_HEADER.get());
        System.out.println(formatter.format(amountAfterDiscount) + KRW);
    }
    
    public void eventBadge(Badge badge) {
        System.out.print(EVENT_BADGE_HEADER.get());
        optionalPrint(badge.getName(), badge.equals(Badge.NONE));
    }
}
