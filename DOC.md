- Use DTOs 
Instance of an object (not an Entity). used to transfer data outside the context.
Since it is not in the context you can do anything to or with the data. However, if you are in the context Hibernate takes
control and validates the data.

If you are not changing the values of the data, do not put the data in the JPA context
 and you will realize performance since there is not data validation of JPA context and DB
data.

1. Dtos are immutable
2. Dtos improve performance compared to Entities
3. Dtos allow data manipulation

- It is recommended to make DTOs immutable especially if you are only fetching the data and sending it to an endpoint.
This is achieved using Java records.
- Fetching a 1000 records and placing them in the context results in Hibernate validating the data unlike using DTOs which
results in do not have the overhead of the validation.
- Use modelmapper for converting DTOs to entities and vice versa

use @Query to do a database call in the repository and anotate it to the function
make dtos immutable

- TODO
1. Simulate 1000 records fetching and sending to an endpoint using Entity vs DTOs
2. Read records, Serializable class

## How to use DTOs outside the Spring JPA Context
1. You first need to create a Repository class which looks like:
```java
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
 @Query("""
         SELECT new com.example.ecom.dto.ProductDTO(p.name, p.description) FROM Product p
         """)
 List<ProductDTO> findProductDto();
 // Objects retrieved in this manner do not go to the JPA context which improves
 // performance however any updates on the objects do not reflect in the DB since the ORM has no control of the objects
}
```
2. Define an object DTO(Data Transfer Object).

```java
package com.example.ecom.dto;

import javax.validation.constraints.NotNull;

public class ProductDTO {
    private @NotNull String name;;
    private @NotNull String description;

    public ProductDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
```

3. Add a service class which looks like:
```java
@Service
public class ProductService {
 @Autowired
 private ProductRepository productRepository;

 public List<ProductDTO> listProductDto() {
  return productRepository.findProductDto();
 }
}
```
4. Implement a GET operation by adding the controller to serve the product objects.

```java
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;
    

    @GetMapping("/dtos")
    public List<ProductDTO> listProductDto() {
        List<ProductDTO> products = productService.listProductDto();
        return products;
    }
}
```

5. TODO: Add testing