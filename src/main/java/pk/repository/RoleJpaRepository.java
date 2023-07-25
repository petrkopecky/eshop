package pk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.entity.Role;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, Long> {
}
