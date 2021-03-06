package app.model.token;

import app.model.util.Probability;
import org.junit.Test;

import static app.model.token.TokenColor.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TokenColorTest {
    @Test
    public void shouldGetRandomCardColor() {
        // given
        Probability probability = mock(Probability.class);
        when(probability.nextInt(0, values().length)).thenReturn(0, 1, 2, 3, 4);

        // when
        TokenColor color1 = getRandom(probability);
        TokenColor color2 = getRandom(probability);
        TokenColor color3 = getRandom(probability);
        TokenColor color4 = getRandom(probability);
        TokenColor color5 = getRandom(probability);

        // then
        assertEquals(Green, color1);
        assertEquals(Purple, color2);
        assertEquals(Blue, color3);
        assertEquals(Black, color4);
        assertEquals(Red, color5);
        verify(probability, times(5)).nextInt(0, values().length);
    }
}
