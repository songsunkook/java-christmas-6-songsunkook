package view;

import static constant.message.OutputMessage.*;

public class OutputView {
    
    public void startEventPlanner() {
        System.out.print(START_EVENT_PLANNER.get());
    }
    
    public void inputDateOfVisit() {
        System.out.print(INPUT_DATE_OF_VISIT.get());
    }
    
    public void inputMenuInformation() {
        System.out.println(INPUT_MENU_INFORMATION.get());
    }
    
    public void previewEventBenefits(int date) {
        System.out.print(PREVIEW_EVENT_BENEFITS.get(date));
    }
    
    public void orderMenuHeader() {
        System.out.print(ORDER_MENU_HEADER.get());
    }
    
    public void totalOrderAmountBeforeDiscountHeader() {
        System.out.print(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT_HEADER.get());
    }
    
    public void giveawayMenuHeader() {
        System.out.print(GIVEAWAY_MENU_HEADER.get());
    }
    
    public void benefitDetailsHeader() {
        System.out.print(BENEFIT_DETAILS_HEADER.get());
    }
    
    public void totalBenefitAmountHeader() {
        System.out.print(TOTAL_BENEFIT_AMOUNT_HEADER.get());
    }
    
    public void amountAfterDiscountHeader() {
        System.out.print(AMOUNT_AFTER_DISCOUNT_HEADER.get());
    }
    
    public void monthEventBadgeHeader() {
        System.out.print(MONTH_EVENT_BADGE_HEADER.get());
    }
}
