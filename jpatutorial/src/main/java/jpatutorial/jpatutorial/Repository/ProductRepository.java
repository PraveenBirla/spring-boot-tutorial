package jpatutorial.jpatutorial.Repository;

import jpatutorial.jpatutorial.Entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity , Long> {


    List<ProductEntity> findBy(Sort sort);

    List<ProductEntity> findByOrderByPrice();

    List<ProductEntity> findByTitle(String pepsi);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime localDateTime);

    List<ProductEntity> findByQuantityAndPrice(int quantity , BigDecimal bigDecimal);

    List<ProductEntity>   findByQuantityGreaterThanAndPriceLessThan(int quantity , BigDecimal bigDecimal);

    List<ProductEntity>   findByQuantityGreaterThanOrPriceLessThan(int quantity , BigDecimal bigDecimal);

    List<ProductEntity>  findByTitleContainingIgnoreCase(String title , Pageable pageable);
    List<ProductEntity>   findByTitleLike(String title);

    //Optional<ProductEntity> findByTitleAndPrice(String title , BigDecimal bigDecimal);

    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title , BigDecimal bigDecimal);


}
