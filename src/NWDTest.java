import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NWDTest {
    @Test
    public void sum() {
        assertEquals(new NumberWhitDimension("3 m/g").toString(), new NumberWhitDimension("1 m/g").sum(new NumberWhitDimension("2 km/kg")).toString());
    }

    @Test
    public void sub() {
        assertEquals(new NumberWhitDimension("3 km").toString(), new NumberWhitDimension("5 km").sub(new NumberWhitDimension("2000 m")).toString());
    }

    @Test
    public void multi() {
        assertEquals(new NumberWhitDimension("10 km/g*pa").toString(), new NumberWhitDimension("5 km/g").multi(new NumberWhitDimension("2 pa")).toString());
        assertEquals(new NumberWhitDimension("10 km*km").toString(), new NumberWhitDimension("5 km").multi(new NumberWhitDimension("2 km")).toString());
    }

    @Test
    public void div() {
        assertEquals(new NumberWhitDimension("5").toString(), new NumberWhitDimension("10 km").div(new NumberWhitDimension("2 km")).toString());
        assertEquals(new NumberWhitDimension("5 km/g/pa").toString(), new NumberWhitDimension("10 km/g").div(new NumberWhitDimension("2 pa")).toString());
    }

    @Test
    public void compare() {
        assertEquals(1, new NumberWhitDimension("10 km").compare(new NumberWhitDimension("2 km")));
    }
}
