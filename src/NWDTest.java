import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NWDTest {
    @Test
    public void sum() {
        assertEquals(new NumberWithDimension("3 m/g").toString(), new NumberWithDimension("1 m/g").sum(new NumberWithDimension("2 km/kg")).toString());
    }

    @Test
    public void sub() {
        assertEquals(new NumberWithDimension("3 km").toString(), new NumberWithDimension("5 km").sub(new NumberWithDimension("2000 m")).toString());
    }

    @Test
    public void multi() {
        assertEquals(new NumberWithDimension("10 km/g*pa").toString(), new NumberWithDimension("5 km/g").multi(new NumberWithDimension("2 pa")).toString());
        assertEquals(new NumberWithDimension("10 km*km").toString(), new NumberWithDimension("5 km").multi(new NumberWithDimension("2 km")).toString());
    }

    @Test
    public void div() {
        assertEquals(new NumberWithDimension("5").toString(), new NumberWithDimension("10 km").div(new NumberWithDimension("2 km")).toString());
        assertEquals(new NumberWithDimension("5 km/g/pa").toString(), new NumberWithDimension("10 km/g").div(new NumberWithDimension("2 pa")).toString());
    }

    @Test
    public void compare() {
        assertEquals(1, new NumberWithDimension("10 km").compare(new NumberWithDimension("2 km")));
    }
}
