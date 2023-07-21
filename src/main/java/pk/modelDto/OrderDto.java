package pk.modelDto;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<ProductDto> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public void addProductDto(ProductDto productDto) {
        if (this.products == null) {
            this.products = new ArrayList<>();
        }
        this.products.add(productDto);
    }
}
