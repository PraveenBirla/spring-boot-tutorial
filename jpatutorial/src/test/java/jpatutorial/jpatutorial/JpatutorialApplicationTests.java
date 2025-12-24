package jpatutorial.jpatutorial;

import jpatutorial.jpatutorial.Entities.ProductEntity;
import jpatutorial.jpatutorial.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpatutorialApplicationTests {

    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testRepository(){

        ProductEntity productEntity = ProductEntity.builder()
                .sku("nestle123")
                .title("Nestle chocolate")
                .price(BigDecimal.valueOf(123.34))
                .quantity(4)
                .build();

        ProductEntity savedEntity = productRepository.save(productEntity);

        System.out.println(savedEntity);
    }

    @Test
    void getRepository(){
        List<ProductEntity> productEntityList = productRepository.findByTitle("pepsi");

        System.out.println(productEntityList);
    }

    @Test
    void getSingleFromRepository(){
        Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice("pepsi" , BigDecimal.valueOf(14.4));

        productEntity.ifPresent(System.out::println);
    }
}
