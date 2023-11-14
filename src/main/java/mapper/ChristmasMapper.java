package mapper;

import constant.Badge;
import domain.Order;
import java.util.List;
import mapper.dto.BenefitDto;
import service.ChristmasService;
import view.dto.OrderDto;

public class ChristmasMapper {
    private final ChristmasService christmasService = new ChristmasService();
    
    public void setVisitDate(int date) {
        christmasService.setVisitDate(date);
    }
    
    public void setOrders(List<OrderDto> orderDto) {
        christmasService.setOrders(
                orderDto.stream()
                        .map(this::orderDtoToOrder)
                        .toList()
        );
    }
    
    public int getDate() {
        return christmasService.getDate();
    }
    
    public List<OrderDto> getOrders() {
        return christmasService.getOrders();
    }
    
    public int getOrderAmountBeforeDiscount() {
        return christmasService.getPrincipal();
    }
    
    public OrderDto getGiveaway() {
        return christmasService.getGiveaway();
    }
    
    public BenefitDto getBenefitDetails() {
        return christmasService.getBenefitDetails();
    }
    
    public int getTotalBenefitAmount() {
        return christmasService.getTotalBenefitAmount();
    }
    
    public int getAmountAfterDiscount() {
        return christmasService.getAmountAfterDiscount();
    }
    
    private Order orderDtoToOrder(OrderDto orderDto) {
        return null;
    }
    
    public Badge getEventBadge() {
        return christmasService.getEventBadge();
    }
}
