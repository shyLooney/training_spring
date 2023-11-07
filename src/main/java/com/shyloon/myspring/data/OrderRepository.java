package com.shyloon.myspring.data;

import com.shyloon.myspring.PelmeniOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public interface OrderRepository extends CrudRepository<PelmeniOrder, Long> {

}
