package pk.service;

import pk.entity.Order;
import pk.entity.Product;
import pk.model.OrderDto;
import pk.model.ProductDto;

import java.util.List;

public interface OrderServiceImpl {
    void  addOrder(OrderDto orderDto);
    List<OrderDto> gerOrderList();



    @Override
    public Order getOrderEntity(OrderDto orderDto){
        Order order =new Order();
        order.setId(orderDto.getId());
        order.setFirstName(orderDto.getFirstName());
        order.setLastName(orderDto.getLastName());
        return order;
    }

    public ProductDto getProductDto(Product product){
        ProductDto productDto=null;
        if (product !=null) {
            productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setPrice(product.getPrice());
        }
        return  productDto;
    }

}
