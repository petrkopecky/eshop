package pk.repository;

import pk.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {



    public void addProduct(ProductEntity productEntity);
    public List<ProductEntity> getProductsList();
    public ProductEntity getProductById(Long productId);
    public void removeProductById(Long productId) throws EntityNotFoundException;
    public ProductEntity updateProduct(ProductEntity productEntity);
}
