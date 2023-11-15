package constant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DayOfTheWeekTest {
    
    @Test
    public void 요일을_정상적으로_계산하는가() {
        //given
        DayOfTheWeek friday = DayOfTheWeek.from(1);
        DayOfTheWeek monday = DayOfTheWeek.from(11);
        DayOfTheWeek sunday = DayOfTheWeek.from(17);
        
        //then
        assertEquals(DayOfTheWeek.FRIDAY, friday);
        assertEquals(DayOfTheWeek.MONDAY, monday);
        assertEquals(DayOfTheWeek.SUNDAY, sunday);
    }
}
