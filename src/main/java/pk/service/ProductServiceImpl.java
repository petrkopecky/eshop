package pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.entity.ProductEntity;
import pk.model.ProductDto;
import pk.repository.ProductJpaRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductJpaRepository productJapRepository;

    @Autowired
    public ProductServiceImpl(ProductJpaRepository productJpaRepository){
        this.productJapRepository=productJpaRepository;
    }
    public void addProduct(ProductDto productDto){

        //productRepository.addProduct(getProductEntity(productDto));
        productJapRepository.save(getProductEntity(productDto));

    }

    @Override
    public List<ProductDto> getProductsList() {
        return getProductListDto(productJapRepository.findAll());
    }

    @Override
    public ProductDto getProductById(Long productId) {
        //return getProductDto(productRepository.getProductById(productId));
        //Optional<ProductEntity> productEntity = productJapRepository.getById(productId);
        return getProductDto(productJapRepository.getById(productId));
    }

    @Override
    public void removeProductById(Long productId) {
        productJapRepository.deleteById(productId);
        //productRepository.removeProductById(productId);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return getProductDto(productJapRepository.save(getProductEntity(productDto)));
        //return getProductDto(productRepository.updateProduct(getProductEntity(productDto)));
    }
    @Override
    public ProductEntity getProductEntity(ProductDto productDto){
        ProductEntity productEntity=new ProductEntity();
        productEntity.setId(productDto.getId());
        productEntity.setName(productDto.getName());
        productEntity.setPrice(productDto.getPrice());
        return  productEntity;
    }

    public ProductDto getProductDto(ProductEntity productEntity){
        ProductDto productDto=null;
        if (productEntity!=null) {
            productDto = new ProductDto();
            productDto.setId(productEntity.getId());
            productDto.setName(productEntity.getName());
            productDto.setPrice(productEntity.getPrice());
        }
        return  productDto;
    }

    public List <ProductDto> getProductListDto(List<ProductEntity> productDtoList){
        return productDtoList.stream().map(productEntity->getProductDto(productEntity)).toList();
    }

}
