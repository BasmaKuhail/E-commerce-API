package e_commerce.api.e_commerce.domain.repository;

import e_commerce.api.e_commerce.domain.model.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Long> {
}
