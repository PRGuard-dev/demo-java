package demo;

import java.sql.SQLException;
import java.util.List;

/**
 * Order lookup service — PRGuard demo (Java).
 *
 * <p>A minimal slice of a shop backend. All data access goes through the
 * shared helpers in {@link Db}: {@code query()} for parameter-bound SQL and
 * {@code money()} for currency formatting — business code never rolls its own.
 */
public class OrderService {

    /** Fetch a single order by primary key. */
    public Order getOrder(long orderId) throws SQLException {
        List<Order> rows = Db.query(
                "SELECT id, total_cents, status FROM orders WHERE id = ?", orderId);
        return rows.isEmpty() ? null : rows.get(0);
    }

    /** Return the formatted total for an order, or {@code null} if it is missing. */
    public String orderTotal(long orderId) throws SQLException {
        Order order = getOrder(orderId);
        return order == null ? null : Db.money(order.totalCents());
    }
}
