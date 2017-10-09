import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;


public class RentACatTest {


    @Test
    public void testReturnRentedCat() {
      RentACat rc = new RentACat();
      Cat c = Mockito.mock(Cat.class);
      Mockito.when(c.getRented()).thenReturn(true);
      assertTrue(rc.returnCat(c));
    }

    @Test
    public void testRentNonRentedCat() {
      RentACat rc = new RentACat();
      Cat c = Mockito.mock(Cat.class);
      Mockito.when(c.getRented()).thenReturn(false);
      assertTrue(rc.rentCat(c));
    }

    @Test
    public void testList3NonRentedCats() {
      RentACat rc = new RentACat();
      ArrayList<Cat> list = new ArrayList<Cat>();
      Cat c1 = Mockito.mock(Cat.class);
      Cat c2 = Mockito.mock(Cat.class);
      Cat c3 = Mockito.mock(Cat.class);
      Mockito.when(c1.getRented()).thenReturn(false);
      Mockito.when(c2.getRented()).thenReturn(false);
      Mockito.when(c3.getRented()).thenReturn(false);
      Mockito.when(c1.toString()).thenReturn("str1");
      Mockito.when(c2.toString()).thenReturn("str2");
      Mockito.when(c3.toString()).thenReturn("str3");
      list.add(c1);
      list.add(c2);
      list.add(c3);
      String val = rc.listCats(list);
      assertEqual(val, "str1\nstr2\nstr3\n");
    }

    @Test
    public void testList2NonRented1RentedCats() {
      RentACat rc = new RentACat();
      ArrayList<Cat> list = new ArrayList<Cat>();
      Cat c1 = Mockito.mock(Cat.class);
      Cat c2 = Mockito.mock(Cat.class);
      Cat c3 = Mockito.mock(Cat.class);
      Mockito.when(c1.getRented()).thenReturn(false);
      Mockito.when(c2.getRented()).thenReturn(true);
      Mockito.when(c3.getRented()).thenReturn(false);
      Mockito.when(c1.toString()).thenReturn("str1");
      Mockito.when(c2.toString()).thenReturn("str2");
      Mockito.when(c3.toString()).thenReturn("str3");
      list.add(c1);
      list.add(c2);
      list.add(c3);
      String val = rc.listCats(list);
      assertEqual(val, "str1\nstr3\n");
    }

    @Test
    public void testExistsEmptyList() {
      RentACat rc = new RentACat();
      ArrayList<Cat> list = new ArrayList<Cat>();
      assertFalse(rc.catExists(1, list));
    }

    @Test
    public void testExistsValid() {
      RentACat rc = new RentACat();
      ArrayList<Cat> list = new ArrayList<Cat>();
      Cat c1 = Mocito.mock(Cat.class);
      Mockito.when(c1.getId()).thenReturn(1);
      assertTrue(rc.catExists(1, list));
    }
}
