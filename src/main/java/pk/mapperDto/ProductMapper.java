package pk.mapperDto;

import org.mapstruct.Mapper;
import pk.entity.Product;
import pk.modelDto.ProductDto;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto productDto);

    List<ProductDto> productsToProductsDto(List<Product> product);
    List<Product> productsDtoToProducts(List<ProductDto> productDto);


}
