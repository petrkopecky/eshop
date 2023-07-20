package pk.modelDto;

import pk.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<ProductDto> productsDto;

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

    public List<ProductDto> getProductsDto() {
        return productsDto;
    }

    public void setProductsDto(List<ProductDto> productsDto) {
        this.productsDto = productsDto;
    }

    public void addProductDto(ProductDto productDto) {
        if (productsDto == null) {
            productsDto = new ArrayList<>();
        }
        productsDto.add(productDto);
    }
}
