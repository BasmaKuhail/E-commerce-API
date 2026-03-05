package e_commerce.api.e_commerce.infrastructure.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import e_commerce.api.e_commerce.infrastructure.persistence.entity.BrandEntity;

public interface JpaBrandRepository extends JpaRepository<BrandEntity, Long> {
}
