package e_commerce.api.e_commerce.repository;

import e_commerce.api.e_commerce.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    public Brand findBrandById(Long brandId);
}
