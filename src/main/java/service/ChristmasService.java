package service;

import constant.Badge;
import domain.giveaway.Giveaway;
import domain.order.Order;
import domain.order.Orders;
import java.util.List;
import mapper.dto.BenefitDto;
import view.dto.OrderDto;

public class ChristmasService {
    private Giveaway giveaway;
    private Orders orders;
    private int date;
    
    public void setVisitDate(int date) {
        this.date = date;
    }
    
    public void setOrders(List<Order> order) {
        orders = new Orders(order, date);
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
    
    public Giveaway getGiveaway() {
        giveaway = new Giveaway(getPrincipal());
        return giveaway;
    }
    
    public BenefitDto getBenefitDetails() {
        return null;
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
