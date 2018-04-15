import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NWDTest {
    @Test
    public void sum() {
        assertEquals("5.0", new NumberWithDimension("2").sum(new NumberWithDimension("3")).toString());
        assertEquals("7000.0 m", new NumberWithDimension("5 km").sub(new NumberWithDimension("2000 m")).toString());
    }

    @Test
    public void sub() {
        assertEquals("3000.0 m", new NumberWithDimension("5 km").sub(new NumberWithDimension("2000 m")).toString());
    }

    @Test
    public void multi() {
        assertEquals("10000.0 m/g*Pa", new NumberWithDimension("5 km/g").multi(new NumberWithDimension("2 Pa")).toString());
        assertEquals("1.0E7 m*m", new NumberWithDimension("5 km").multi(new NumberWithDimension("2 km")).toString());
    }

    @Test
    public void div() {
        assertEquals("5000.0 m/g/Pa", new NumberWithDimension("10 km/g").div(new NumberWithDimension("2 Pa")).toString());
        assertEquals("5.0", new NumberWithDimension("10 km").div(new NumberWithDimension("2 km")).toString());
    }

    @Test
    public void Compare() {
        assertEquals(0, new NumberWithDimension("10 km")
                .compareTo(new NumberWithDimension("2 km")));

    }
}
