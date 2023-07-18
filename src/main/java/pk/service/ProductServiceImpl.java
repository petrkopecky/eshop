package pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.entity.Product;
import pk.modelDto.ProductDto;
import pk.repository.EntityNotFoundException;
import pk.repository.ProductJpaRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductJpaRepository productJapRepository;

    @Autowired
    public ProductServiceImpl(ProductJpaRepository productJpaRepository) {
        this.productJapRepository = productJpaRepository;
    }

    public void addProduct(ProductDto productDto) {

        productJapRepository.save(getProductEntity(productDto));

    }

    @Override
    public List<ProductDto> getProductsList() {
        return getProductListDto(productJapRepository.findAll());
    }

    @Override
    public ProductDto getProductById(Long productId) {
        try {
            return getProductDto(productJapRepository.getById(productId));
        } catch (jakarta.persistence.EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void removeProductById(Long productId) {
        try {
            productJapRepository.deleteById(productId);
        } catch (jakarta.persistence.EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }

    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return getProductDto(productJapRepository.save(getProductEntity(productDto)));

    }

    @Override
    public Product getProductEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return product;
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = null;
        if (product != null) {
            productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setPrice(product.getPrice());
        }
        return productDto;
    }

    public List<ProductDto> getProductListDto(List<Product> productList) {
        return productList == null ? null : productList.stream().map(product -> getProductDto(product)).toList();
    }

    @Override
    public List<Product> getProductList(List<ProductDto> productsDtoList) {
        return productsDtoList == null ? null : productsDtoList.stream().map(productDto -> getProductEntity(productDto)).toList();
    }

}
