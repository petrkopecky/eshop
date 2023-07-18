package pk.service;

import pk.entity.Product;
import pk.model.ProductDto;

import java.util.List;

public interface ProductService {
    public void addProduct(ProductDto productDto);

    public List<ProductDto> getProductsList();

    public ProductDto getProductById(Long productId);

    public void removeProductById(Long productId);

    public ProductDto updateProduct(ProductDto productDto);


    public Product getProductEntity(ProductDto productDto);

    public ProductDto getProductDto(Product product);

    public List <ProductDto> getProductListDto(List<Product> productList);


    public List<Product> getProductList(List<ProductDto> productsDto);
}
