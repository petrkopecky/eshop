package pk.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.exception.EntityNotFoundException;
import pk.mapperDto.OrderMapper;
import pk.mapperDto.ProductMapper;
import pk.modelDto.OrderDto;
import pk.repository.OrderJpaRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderJpaRepository orderJpaRepository;
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);
    private OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @Autowired
    OrderServiceImpl(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;

    }
    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        return orderMapper.OrderToOrderDto(orderJpaRepository.save(orderMapper.OrderDtoToOrder(orderDto)));
    }

    public List<OrderDto> gerOrdersList() {
        return orderMapper.OrdersToOrdersDto(orderJpaRepository.findAll());
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
              return orderMapper.OrderToOrderDto(orderJpaRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException()));
     }

    @Override
    public void removeOrderById(Long orderId) {
        try {
            orderJpaRepository.deleteById(orderId);
        } catch (jakarta.persistence.EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }

    }
    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        return orderMapper.OrderToOrderDto(orderJpaRepository.save(orderMapper.OrderDtoToOrder(orderDto)));
    }

}
