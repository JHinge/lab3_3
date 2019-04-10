package lab3_3;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.time.FakeDateTime;
import edu.iis.mto.time.Order;
import edu.iis.mto.time.OrderExpiredException;

public class OrderTest {

    @Test(expected = OrderExpiredException.class)
    public void shouldThrowOrderExpiredExceptionIfTimeForSubmitExpired() {
        FakeDateTime fakeDateTime = new FakeDateTime();
        fakeDateTime.addDateToReturn(2019, 2, 3, 6, 6);
        fakeDateTime.addDateToReturn(2019, 6, 8, 6, 6);

        Order order = new Order(fakeDateTime);
        order.submit();
        order.confirm();
    }

    @Test
    public void shouldNotMarkOrderAsCancelled24hoursAfterSubmission() {
        FakeDateTime fakeDateTime = new FakeDateTime();
        fakeDateTime.addDateToReturn(2019, 10, 1, 0, 0);
        fakeDateTime.addDateToReturn(2019, 10, 2, 0, 0);

        Order order = new Order(fakeDateTime);
        order.submit();
        order.confirm();
        assertThat(order.getOrderState(), not(equalTo(Order.State.CANCELLED)));
    }
}
