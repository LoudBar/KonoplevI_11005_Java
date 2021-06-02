import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CRUDHolderTests {

    private ArrayList<Person> arr;
    private Main.CRUDHolder<Person> holder;

    @Before
    public void prepareItems() {
        arr = new ArrayList<>();
        arr.add(new Person("BOBA", 10));
        arr.add(new Person("BIBA", 12));
        holder = new Main.CRUDHolder<>(arr);
    }

    @Test
    public void createItemTestSucceed() {
        holder.create(new Person("DALEK", Integer.MAX_VALUE));

        assertEquals("DALEK", arr.get(2).getName());
        assertEquals(Integer.MAX_VALUE, arr.get(2).getAge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemTestFailed() {
        holder.create(new Person("BOBA", 10));
    }

    @Test
    public void readItemTestSucceed() {
        Person ans = holder.read(0);

        assertEquals(ans, arr.get(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void readItemTestFailed() {
        Person ans = holder.read(10);
    }

    @Test
    public void updateItemTestSucceed() {
        Person ans = new Person("BOBA", 18);
        holder.update(ans);

        assertEquals("BOBA", arr.get(0).getName());
        assertEquals(18, arr.get(0).getAge());
    }

    @Test(expected = NoSuchElementException.class)
    public void updateItemTestFailed() {
        Person ans = new Person("MASTER", Integer.MAX_VALUE);
        holder.update(ans);
    }

    @Test
    public void deleteItemTestSucceed() {
        Person ans = arr.get(1);
        holder.delete(ans);

        assertEquals(1, arr.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteItemTestFailed() {
        Person ans = new Person("DOCTOR", Integer.MAX_VALUE);
        holder.delete(ans);
    }

}
