package pk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.entity.ProductEntity;
@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
