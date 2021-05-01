import Serialization.Order;
import Serialization.OrdersRuntimeSaver;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.*;
import static org.junit.Assert.*;
import Serialization.Warehouse;

public class WarehouseTests {

    private Warehouse warehouse;
    private OrdersRuntimeSaver saver;

    @Before
    public void prepareOrders() {

        saver = new OrdersRuntimeSaver();
        saver.orders.add(new Order("chair", 10));
        saver.orders.add(new Order("table", 5));
        warehouse = new Warehouse(saver);
    }

    @Test
    public void addOrdersTest() {

        warehouse.addOrder("phone", 15);

        assertEquals(3, saver.orders.size());
        assertEquals("phone", saver.orders.get(2).name);
        assertEquals(15, saver.orders.get(2).quantity);
    }

    @Test
    public void getOrderTestSucceed() {

        Order p = warehouse.getOrder("table");

        assertNotNull(p);
        assertEquals("table", p.name);
        assertEquals(5, p.quantity);
    }

    @Test
    public void getOrderTestFailed() {

        Order p = warehouse.getOrder("phone");

        assertNull(p);
    }

    @Test
    public void removeOrderTestSucceed() {

        warehouse.removeOrder("table");

        assertEquals(1, saver.orders.size());
    }

    @Test
    public void removeOrderTestFailed() {
    
        warehouse.removeOrder("phone");
        
        assertEquals(2, saver.orders.size());
    }

    @Test
    public void changeQuantityTestSucceed() {

        Order p = warehouse.getOrder("chair");
        p.setQuantity(5);

        assertEquals(5, p.quantity);
    }

    @Test
    public void changeQuantityTestFailed() {

        Order p = warehouse.getOrder("phone");

        assertNull(p);
    }

}
