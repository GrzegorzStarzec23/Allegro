package com.starzec.allegro.repository;

import com.starzec.allegro.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
