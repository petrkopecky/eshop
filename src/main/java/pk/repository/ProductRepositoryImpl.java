package pk.repository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pk.entity.ProductEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductRepositoryImpl implements InitializingBean,ProductRepository {
    Map<Long, ProductEntity> productMap;


    @Override
    public void afterPropertiesSet() throws Exception {
        productMap = new HashMap<Long, ProductEntity>();
    }

    @Override
    public void addProduct(ProductEntity productEntity) {
        productMap.put(productEntity.getId(), productEntity);
    }

    @Override
    public List<ProductEntity> getProductsList() {
        return productMap.values().stream().collect(
                Collectors.toCollection(ArrayList<ProductEntity>::new));
    }

    @Override
    public ProductEntity getProductById(Long productId) {
        return productMap.get(productId);
    }

    @Override
    public void removeProductById(Long productId) throws EntityNotFoundException {
        if(productMap.get(productId)==null){
            throw new EntityNotFoundException();
        }
        productMap.remove(productId);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        if(productMap.get(productEntity.getId())==null){
            throw new EntityNotFoundException();
        }
        productMap.put(productEntity.getId(),productEntity);
        return productEntity;
    }
}
