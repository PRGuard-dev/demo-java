package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Shared data helpers — the only sanctioned way to touch orders.
 *
 * <p>{@code query()} binds every value as a driver-level parameter, so SQL
 * injection is structurally impossible. {@code money()} formats an integer
 * number of cents as currency without floating-point rounding. Business
 * code uses these helpers rather than rolling its own.
 */
public final class Db {

    private static final String JDBC_URL = "jdbc:sqlite:orders.db";

    private Db() {}

    /** Run {@code sql} with {@code params} bound by the driver; return all rows. */
    public static List<Order> query(String sql, Object... params) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                List<Order> orders = new ArrayList<>();
                while (rs.next()) {
                    orders.add(new Order(
                            rs.getLong("id"),
                            rs.getLong("total_cents"),
                            rs.getString("status")));
                }
                return orders;
            }
        }
    }

    /** Format an integer number of {@code cents} as currency, e.g. 1299 → "$12.99". */
    public static String money(long cents) {
        return String.format("$%d.%02d", cents / 100, cents % 100);
    }
}
