package mapper.dto;

public class DiscountDto {
    private final String name;
    private final int benefitAmount;
    
    public DiscountDto(String name, int benefitAmount) {
        this.name = name;
        this.benefitAmount = benefitAmount;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBenefitAmount() {
        return benefitAmount;
    }
}
