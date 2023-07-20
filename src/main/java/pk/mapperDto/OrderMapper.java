package pk.mapperDto;

import org.mapstruct.Mapper;
import pk.entity.Order;
import pk.modelDto.OrderDto;
@Mapper(uses = ProductMapper.class)
public interface OrderMapper {
    OrderDto OrderToOrderDto(Order Order);
    Order OrderDtoToOrder(OrderDto OrderDto);
}
