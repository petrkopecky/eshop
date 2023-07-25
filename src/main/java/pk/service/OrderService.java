package pk.service;

import pk.modelDto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto addOrder(OrderDto orderDto);

    List<OrderDto> gerOrdersList();


    public OrderDto updateOrder(OrderDto orderDto);


    public OrderDto getOrderById(Long id);

    public void removeOrderById(Long id);
}
