package com.schambeck.erp.order.repository;

import com.schambeck.erp.order.domain.Order;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import static com.schambeck.erp.order.repository.CustomerRepository.newRandomCustomer;
import static java.math.RoundingMode.HALF_UP;
import static java.util.stream.Collectors.toList;

@Repository
public class OrderRepository {

    public List<Order> findAll() {
        return ORDERS;
    }

    private final static List<Order> ORDERS = IntStream.rangeClosed(1, 10)
            .mapToObj(OrderRepository::newRandomOrder)
            .collect(toList());

    private static Order newRandomOrder(int i) {
        return Order.builder()
                .id(UUID.randomUUID())
                .customer(newRandomCustomer())
                .issueDate(LocalDate.now())
                .total(newRandomBigDecimal())
                .build();
    }

    private static BigDecimal newRandomBigDecimal() {
        BigDecimal min = BigDecimal.valueOf(1000).setScale(2, HALF_UP);
        BigDecimal max = BigDecimal.valueOf(10000).setScale(2, HALF_UP);
        BigDecimal randomBigDecimal = min.add(BigDecimal.valueOf(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, HALF_UP);
    }

}
