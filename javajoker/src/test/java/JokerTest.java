
import com.lukasanda.TheJoker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class JokerTest {
    @Test
    public void testMakeMeLaugh() {
        TheJoker joker = new TheJoker();
        assertThat(joker.giveMeAJoke(), notNullValue());
    }
}
