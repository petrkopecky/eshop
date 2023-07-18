package pk.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pk.model.OrderDto;
import pk.model.ProductDto;
import pk.repository.EntityNotFoundException;
import pk.service.OrderService;

import java.util.List;

@RestController
public class OrderControler {

    private final OrderService orderService;

    @Autowired
    public OrderControler(OrderService orderService) {
        this.orderService = orderService;
    }



    @GetMapping("/orders")
    List<OrderDto> orders() {
        return orderService.gerOrdersList();
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);

    }




}
