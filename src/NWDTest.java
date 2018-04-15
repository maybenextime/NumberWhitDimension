import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NWDTest {
    @Test
    public void sum() {
        assertEquals("5.0", new NumberWithDimension("2").Sum(new NumberWithDimension("3")).toString());
        assertEquals("7000.0 m", new NumberWithDimension("5 km").Sum(new NumberWithDimension("2000 m")).toString());
    }

    @Test
    public void sub() {
        assertEquals("3000.0 m", new NumberWithDimension("5 km").Sub(new NumberWithDimension("2000 m")).toString());
    }

    @Test
    public void multi() {
        assertEquals("10000.0 m/g*Pa", new NumberWithDimension("5 km/g").Multi(new NumberWithDimension("2 Pa")).toString());
        assertEquals("1.0E7 m*m", new NumberWithDimension("5 km").Multi(new NumberWithDimension("2 km")).toString());
    }

    @Test
    public void div() {
        assertEquals("5000.0 m/g/Pa", new NumberWithDimension("10 km/g").Div(new NumberWithDimension("2 Pa")).toString());
        assertEquals("5.0", new NumberWithDimension("10 km").Div(new NumberWithDimension("2 km")).toString());
    }

    @Test
    public void Compare() {
        assertEquals(0, new NumberWithDimension("10 km")
                .compareTo(new NumberWithDimension("2 km")));

    }
}
