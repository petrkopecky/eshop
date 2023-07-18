package pk.service;

import pk.entity.Order;
import pk.model.OrderDto;

import java.util.List;

public interface OrderService {
    void  addOrder(OrderDto orderDto);
    List<OrderDto> gerOrdersList();
    public Order getOrderEntity(OrderDto orderDto);
    public OrderDto getOrderDto(Order order);
    public List<Order> getOrdersList(List<OrderDto> ordersDtoList);

    public List <OrderDto> getOrdersListDto(List<Order> ordersList);

}
