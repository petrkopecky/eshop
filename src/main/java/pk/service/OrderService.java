package pk.service;

import pk.entity.Order;
import pk.entity.Product;
import pk.model.OrderDto;
import pk.model.ProductDto;

import java.util.List;

public interface OrderService {
    void  addOrder(OrderDto orderDto);
    List<OrderDto> gerOrderList();
    public Order getOrderEntity(OrderDto orderDto);
    public OrderDto getOrderDto(Order order);
    public List<Order> getOrderList(List<OrderDto> ordersDtoList);

    public List <OrderDto> getOrderListDto(List<Order> ordersList);
}
