package pk.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pk.modelDto.OrderDto;
import pk.modelDto.ProductDto;
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
        OrderDto newOrderDto=orderService.addOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrderDto);

    }

    @GetMapping("/orders/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        OrderDto orderDto = orderService.getOrderById(id);
        if (orderDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "HTTP Status  (CODE 404)\n");
        }
        return orderDto;
    }

    @DeleteMapping("/orders/{id}")
    public void removeOrderById(@PathVariable Long id) {
        try {
            orderService.removeOrderById(id);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "HTTP Status  (CODE 404)\n");
        }
    }


}
