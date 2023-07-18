package pk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.entity.ProductEntity;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
