package pk.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pk.model.ProductDto;
import pk.service.ProductService;
import pk.repository.EntityNotFoundException;

import java.util.List;

@RestController
public class ProductControler {

    private final ProductService productService;

    @Autowired
    public ProductControler(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    String home() {
        System.out.println("home");
        return "product";
    }

    @GetMapping("/products")
    List<ProductDto> products() {
        return productService.getProductsList();
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);

    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        ProductDto productDto = productService.getProductById(id);
        if (productDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "HTTP Status  (CODE 404)\n");
        }
        return productDto;
    }

    @DeleteMapping("/products/{id}")
    public void removeProductById(@PathVariable Long id) {
        try {
            productService.removeProductById(id);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "HTTP Status  (CODE 404)\n");
        }
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto) {
        productDto.setId(id);
        ProductDto updatedProductDto;
        try {
            updatedProductDto = productService.updateProduct(productDto);
        }catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "HTTP Status  (CODE 404)\n");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedProductDto);

    }


}
