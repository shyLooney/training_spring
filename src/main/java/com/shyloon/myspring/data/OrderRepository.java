package com.shyloon.myspring.data;

import com.shyloon.myspring.PelmeniOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<PelmeniOrder, UUID> {

}
