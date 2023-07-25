package pk.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.exception.EntityNotFoundException;
import pk.mapperDto.ProductMapper;
import pk.modelDto.ProductDto;
import pk.repository.ProductJpaRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductJpaRepository productJapRepository;
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);


    @Autowired
    public ProductServiceImpl(ProductJpaRepository productJpaRepository) {
        this.productJapRepository = productJpaRepository;
    }

    public ProductDto addProduct(ProductDto productDto) {

        return productMapper.productToProductDto(productJapRepository.save(productMapper.productDtoToProduct(productDto)));

    }

    @Override
    public List<ProductDto> getProductsList() {
        return productMapper.productsToProductsDto(productJapRepository.findAll());
    }

    @Override
    public ProductDto getProductById(Long productId) {
        return productMapper.productToProductDto(productJapRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException()));
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
        return productMapper.productToProductDto(productJapRepository.save(productMapper.productDtoToProduct(productDto)));

    }

}
