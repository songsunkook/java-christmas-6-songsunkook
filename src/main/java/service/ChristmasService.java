package service;

import constant.Badge;
import constant.Discounts;
import constant.menu.Menu;
import domain.discount.Discount;
import domain.giveaway.Giveaway;
import domain.order.Order;
import domain.order.Orders;
import java.util.Arrays;
import java.util.List;

public class ChristmasService {
    private Giveaway giveaway;
    private Orders orders;
    private int date;
    
    public void setVisitDate(int date) {
        this.date = date;
    }
    
    public void setOrders(List<Order> order) {
        orders = new Orders(order, date);
        giveaway = new Giveaway(orders.getTotalPrice());
    }
    
    public int getDate() {
        return date;
    }
    
    public List<Order> getOrders() {
        return orders.getOrders();
    }
    
    public int getPrincipal() {
        return orders.getTotalPrice();
    }
    
    public boolean isHaveGiveaway() {
        return giveaway.isHave();
    }
    
    public Menu getGiveawayMenu() {
        return giveaway.getGivewayPrize();
    }
    
    public int getGiveawayCount() {
        return giveaway.getCount();
    }
    
    public List<Discount> getBenefitDetails() {
        return Arrays.stream(Discounts.values())
                .map(discount -> discount.getFunction().apply(orders))
                .filter(Discount::isDiscountable)
                .toList();
    }
    
    public int getTotalBenefitAmount() {
        return 0;
    }
    
    public int getAmountAfterDiscount() {
        return 0;
    }
    
    public Badge getEventBadge() {
        return null;
    }
}
