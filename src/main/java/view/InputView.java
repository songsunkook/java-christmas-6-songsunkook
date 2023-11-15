package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import constant.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import view.dto.OrderDto;

public class InputView {
    
    private static final String MENU_DELIMITER = ",";
    private static final String SEPARATOR_BETWEEN_MENU_NAME_AND_NUMBER = "-";
    
    public int readDate() {
        return parseDate(readLine());
    }
    
    private int parseDate(String string) {
        try {
            int date = Integer.parseInt(string);
            if (date < 1 || date > 31) {
                throw new IllegalArgumentException();
            }
            return date;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE.get());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE.get());
        }
    }
    
    public List<OrderDto> readMenus() {
        try {
            List<OrderDto> result = new ArrayList<>();
            String[] line = readLine().split(MENU_DELIMITER);
            for (String menu : line) {
                String[] menuElements = menu.split(SEPARATOR_BETWEEN_MENU_NAME_AND_NUMBER);
                result.add(new OrderDto(menuElements[0], parseMenu(menuElements[1])));
            }
            return result;
        } catch (ArrayIndexOutOfBoundsException e) {
            //-로 구분되어 개수가 명시되지 않은 경우 menuElements[1]을 인식받지 못할 수 있다.
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.get());
        }
    }
    
    private int parseMenu(String string) {
        try {
            int menu = Integer.parseInt(string);
            if (menu < 1) {
                throw new IllegalArgumentException();
            }
            return menu;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.get());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.get());
        }
    }
}
