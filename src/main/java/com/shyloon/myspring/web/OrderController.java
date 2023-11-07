package com.shyloon.myspring.web;

import com.shyloon.myspring.PelmeniOrder;
import com.shyloon.myspring.data.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("pelmeniOrder")
public class OrderController {
    OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @ModelAttribute(name = "pelmeniOrder")
    public PelmeniOrder order() {
        return new PelmeniOrder();
    }

    @PostMapping
    public String processOrder(@Valid PelmeniOrder order, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors())
            return "orderForm";

        orderRepo.save(order);
        log.info("Order submitted: {}", order);

        sessionStatus.setComplete();

        return "redirect:/";
    }
}
