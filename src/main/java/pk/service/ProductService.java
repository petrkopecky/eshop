package pk.service;

import pk.modelDto.ProductDto;

import java.util.List;

public interface ProductService {
    public ProductDto addProduct(ProductDto productDto);

    public List<ProductDto> getProductsList();

    public ProductDto getProductById(Long productId);

    public void removeProductById(Long productId);

    public ProductDto updateProduct(ProductDto productDto);


}
