package mapper;

import constant.Badge;
import domain.giveaway.Giveaway;
import domain.order.Order;
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
        return christmasService.getOrders().stream()
                .map(this::orderToOrderDto)
                .toList();
    }
    
    public int getOrderAmountBeforeDiscount() {
        return christmasService.getPrincipal();
    }
    
    public OrderDto getGiveaway() {
        return giveawayToOrderDto(christmasService.getGiveaway());
    }
    
    private OrderDto giveawayToOrderDto(Giveaway giveaway) {
        if (!giveaway.isHave()) {
            return null;
        }
        return new OrderDto(giveaway.getGivewayPrize(), giveaway.getCount());
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
        return new Order(orderDto.getMenu(), orderDto.getCount());
    }
    
    private OrderDto orderToOrderDto(Order order) {
        return new OrderDto(order.getMenu(), order.getCount());
    }
    
    public Badge getEventBadge() {
        return christmasService.getEventBadge();
    }
}
