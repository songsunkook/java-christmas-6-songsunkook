package service;

import constant.Badge;
import domain.order.Order;
import java.util.List;
import mapper.dto.BenefitDto;
import view.dto.OrderDto;

public class ChristmasService {
    private int date;
    private int principal;
    
    public void setVisitDate(int date) {
        this.date = date;
    }
    
    public void setOrders(List<Order> order) {
    
    }
    
    public int getDate() {
        return date;
    }
    
    public List<OrderDto> getOrders() {
        return null;
    }
    
    public int getPrincipal() {
        return principal;
    }
    
    public OrderDto getGiveaway() {
        return null;
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
