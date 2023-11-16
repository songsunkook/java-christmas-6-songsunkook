package constant;

import static org.junit.jupiter.api.Assertions.*;

import domain.EventBadge;
import org.junit.jupiter.api.Test;

class BadgeTest {
    
    @Test
    public void 할인_금액에_따라_이벤트_배지가_올바르게_부여되는가() {
        //given
        EventBadge nonBadge = new EventBadge(1000);
        EventBadge starBadge = new EventBadge(5000);
        EventBadge treeBadge = new EventBadge(10000);
        EventBadge santaBadge = new EventBadge(20000);
        
        //then
        assertEquals(Badge.NONE, nonBadge.getBadge());
        assertEquals(Badge.STAR, starBadge.getBadge());
        assertEquals(Badge.TREE, treeBadge.getBadge());
        assertEquals(Badge.SANTA, santaBadge.getBadge());
    }
}
