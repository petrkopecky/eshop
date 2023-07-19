package pk.service;

import pk.entity.Order;
import pk.modelDto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto  addOrder(OrderDto orderDto);
    List<OrderDto> gerOrdersList();
    public Order getOrderEntity(OrderDto orderDto);
    public OrderDto getOrderDto(Order order);
    public List<Order> getOrdersList(List<OrderDto> ordersDtoList);
    public OrderDto updateOrder(OrderDto orderDto);
    public List <OrderDto> getOrdersListDto(List<Order> ordersList);

    public OrderDto getOrderById(Long id);

    public void removeOrderById(Long id);
}
