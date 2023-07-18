package pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.entity.Order;
import pk.entity.Product;
import pk.model.OrderDto;
import pk.model.ProductDto;
import pk.repository.OrderJpaRepository;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    private final OrderJpaRepository orderJpaRepository;
    private final ProductService productService;

    @Autowired
    OrderServiceImpl(OrderJpaRepository orderJpaRepository, ProductService productService){
        this.orderJpaRepository=orderJpaRepository;
        this.productService=productService;
    }
    public void   addOrder(OrderDto orderDto){
        orderJpaRepository.save(getOrderEntity(orderDto));
    }
   public List<OrderDto> gerOrderList(){
        return getOrderListDto( orderJpaRepository.findAll());
    }



    @Override
    public Order getOrderEntity(OrderDto orderDto){
        Order order =new Order();
        order.setId(orderDto.getId());
        order.setFirstName(orderDto.getFirstName());
        order.setLastName(orderDto.getLastName());
        order.setProducts(productService.getProductList(orderDto.getProductsDto()));
        return order;
    }

    public OrderDto getOrderDto(Order order){
        OrderDto orderDto=null;
        if (order !=null) {
            orderDto = new OrderDto();
            orderDto.setId(order.getId());
            orderDto.setFirstName(order.getFirstName());
            orderDto.setLastName(order.getLastName());
            orderDto.setProductsDto(productService.getProductListDto(order.getProducts()));
        }
        return  orderDto;
    }
    @Override
    public List <OrderDto> getOrderListDto(List<Order> ordersList){
        return ordersList.stream().map(product ->getOrderDto(product)).toList();
    }

    @Override
    public List<Order> getOrderList(List<OrderDto> ordersDtoList) {
        return ordersDtoList.stream().map(orderDto->getOrderEntity(orderDto)).toList();
    }

}
