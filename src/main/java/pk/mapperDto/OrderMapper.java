package pk.mapperDto;

import org.mapstruct.Mapper;
import pk.entity.Order;
import pk.modelDto.OrderDto;

import java.util.List;

@Mapper(uses = ProductMapper.class)
public interface OrderMapper {
    OrderDto OrderToOrderDto(Order Order);
    Order OrderDtoToOrder(OrderDto OrderDto);

    List<OrderDto> OrdersToOrdersDto( List<Order> Order);
    List<Order> OrdersDtoToOrders( List<OrderDto> OrderDto);
}
