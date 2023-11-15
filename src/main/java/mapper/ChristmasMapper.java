package mapper;

import constant.Badge;
import constant.message.OutputMessage;
import domain.discount.Discount;
import domain.giveaway.Giveaway;
import domain.order.Order;
import java.util.ArrayList;
import java.util.List;
import mapper.dto.DiscountDto;
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
        return new OrderDto(christmasService.getGiveawayMenu(), christmasService.getGiveawayCount());
    }
    
    public List<DiscountDto> getBenefitDetails() {
        List<DiscountDto> discountDtos = new ArrayList<>(
                christmasService.getBenefitDetails().stream()
                        .map(this::discountToDiscountDto)
                        .toList()
        );
        
        if (christmasService.isHaveGiveaway()) {
            discountDtos.add(new DiscountDto(
                    OutputMessage.GIVEAWAY_EVENT.get(),
                    christmasService.getGiveawayMenu().getPrice() * christmasService.getGiveawayCount()
            ));
        }
        return discountDtos;
    }
    
    private DiscountDto discountToDiscountDto(Discount discount) {
        return new DiscountDto(discount.getName(), discount.discountAmount());
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
