package pk.service;

import pk.entity.ProductEntity;
import pk.model.ProductDto;

import java.util.List;

public interface ProductService {
    public void addProduct(ProductDto productDto);

    public List<ProductDto> getProductsList();

    public ProductDto getProductById(Long productId);

    public void removeProductById(Long productId);

    public ProductDto updateProduct(ProductDto productDto);


    public ProductEntity getProductEntity(ProductDto productDto);

    public ProductDto getProductDto(ProductEntity productEntity);

    public List <ProductDto> getProductListDto(List<ProductEntity> productDtoList);


}
