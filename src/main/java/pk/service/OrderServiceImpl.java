package pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.entity.Order;
import pk.modelDto.OrderDto;
import pk.modelDto.ProductDto;
import pk.repository.EntityNotFoundException;
import pk.repository.OrderJpaRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderJpaRepository orderJpaRepository;
    private final ProductService productService;

    @Autowired
    OrderServiceImpl(OrderJpaRepository orderJpaRepository, ProductService productService) {
        this.orderJpaRepository = orderJpaRepository;
        this.productService = productService;
    }
    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        return getOrderDto(orderJpaRepository.save(getOrderEntity(orderDto)));
    }

    public List<OrderDto> gerOrdersList() {
        return getOrdersListDto(orderJpaRepository.findAll());
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        try {
            return getOrderDto(orderJpaRepository.getById(orderId));
        } catch (jakarta.persistence.EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
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
        return getOrderDto(orderJpaRepository.save(getOrderEntity(orderDto)));
    }

    @Override
    public Order getOrderEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setFirstName(orderDto.getFirstName());
        order.setLastName(orderDto.getLastName());
        order.setProducts(productService.getProductList(orderDto.getProductsDto()));
        return order;
    }

    public OrderDto getOrderDto(Order order) {
        OrderDto orderDto = null;
        if (order != null) {
            orderDto = new OrderDto();
            orderDto.setId(order.getId());
            orderDto.setFirstName(order.getFirstName());
            orderDto.setLastName(order.getLastName());
            orderDto.setProductsDto(productService.getProductListDto(order.getProducts()));
        }
        return orderDto;
    }

    @Override
    public List<OrderDto> getOrdersListDto(List<Order> ordersList) {
        return ordersList == null ? null : ordersList.stream().map(product -> getOrderDto(product)).toList();
    }

    @Override
    public List<Order> getOrdersList(List<OrderDto> ordersDtoList) {
        return ordersDtoList == null ? null : ordersDtoList.stream().map(orderDto -> getOrderEntity(orderDto)).toList();
    }

}
