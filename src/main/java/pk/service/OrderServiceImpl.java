package pk.service;

import pk.model.OrderDto;

public interface OrderService {
    void  addOrder(OrderDto orderDto);
    List<OrderDto> gerOrderList();
}
