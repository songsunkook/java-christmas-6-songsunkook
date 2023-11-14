package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import view.dto.OrderDto;

public class InputView {
    
    private static final String MENU_DELIMITER = ",";
    private static final String SEPARATOR_BETWEEN_MENU_NAME_AND_NUMBER = "-";
    
    public int readDate() {
        return this.catchDateException(this::inputDate);
    }
    
    private int inputDate() {
        return Integer.parseInt(readLine());
    }
    
    private int catchDateException(Supplier<Integer> logic) {
        try {
            return logic.get();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]숫자가 아닌 입력");
        }
    }
    
    public List<OrderDto> readMenus() {
        return catchOrderDtosExceptions(this::inputMenus);
    }
    
    private List<OrderDto> inputMenus() {
        List<OrderDto> result = new ArrayList<>();
        String[] line = readLine().split(MENU_DELIMITER);
        for (String menu : line) {
            String[] menuElements = menu.split(SEPARATOR_BETWEEN_MENU_NAME_AND_NUMBER);
            result.add(new OrderDto(menuElements[0], Integer.parseInt(menuElements[1])));
        }
        return result;
    }
    
    private List<OrderDto> catchOrderDtosExceptions(Supplier<List<OrderDto>> logic) {
        try {
            return logic.get();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]숫자가 아닌 입력");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
