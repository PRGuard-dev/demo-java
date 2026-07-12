package demo;

/** One row of the orders table. */
public record Order(long id, long totalCents, String status) {}
