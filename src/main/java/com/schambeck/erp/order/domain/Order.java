package com.schambeck.erp.order.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class Order {

    private UUID id;

    private Customer customer;

    private LocalDate issueDate;

    private BigDecimal total;

}
