import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NWDTest {
    private NumberWithDimension nwd1= new NumberWithDimension("5 km/kg");
    private NumberWithDimension nwd2= new NumberWithDimension("2000 m");
    private NumberWithDimension nwd3= new NumberWithDimension(10.0,"km" );
    private NumberWithDimension nwd4= new NumberWithDimension(7.0,"km" );
    private NumberWithDimension nwd5= new NumberWithDimension(2.0, "kg");
    private NumberWithDimension nwd6= new NumberWithDimension(17.0,"km" );
    private NumberWithDimension nwd7= new NumberWithDimension(2.0,"Pa" );
    private NumberWithDimension nwd8= new NumberWithDimension(10000.0,"mm/g*Pa" );
    @Test
    public void GetD(){
        assertEquals("m/g",nwd1.GetDim());
        assertEquals("m", nwd2.GetDim());
        assertEquals("m", nwd3.GetDim());
        assertEquals("m", nwd4.GetDim());
        assertEquals("g", nwd5.GetDim());
        assertEquals("m", nwd6.GetDim());
        assertEquals("Pa", nwd7.GetDim());
        assertEquals("m/g*Pa", nwd8.GetDim());


    }
    @Test
    public void GetN(){
        assertEquals(5.0, nwd1.GetNumber(),0 );
        assertEquals(2000.0, nwd2.GetNumber(),0 );
        assertEquals(10000.0, nwd3.GetNumber(),0 );
        assertEquals(7000.0, nwd4.GetNumber(),0 );
        assertEquals(2000.0, nwd5.GetNumber(),0 );
        assertEquals(17000.0, nwd6.GetNumber(),0 );
        assertEquals(2.0, nwd7.GetNumber(),0 );
        assertEquals(10.0, nwd8.GetNumber(),0 );
    }
    @Test
    public void sum() {
        assertEquals(nwd6, nwd3.Sum(nwd4));
    }
    @Test
    public void sub() {
        assertEquals(nwd3, nwd6.Sub(nwd4));
    }
    @Test
    public void multi() {
        assertEquals(nwd8,nwd1.Multi(nwd7));
    }

    @Test
    public void div() {
        assertEquals(nwd1, nwd3.Div(nwd5));
    }

    @Test
    public void Compare() {
        assertEquals(1,nwd3.compareTo(nwd4));

    }
}
