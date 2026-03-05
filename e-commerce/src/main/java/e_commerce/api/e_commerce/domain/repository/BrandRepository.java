package e_commerce.api.e_commerce.domain.repository;

import e_commerce.api.e_commerce.domain.model.Brand;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface BrandRepository {
    public Optional<Brand> findBrandById(Long brandId);
    Brand save (Brand brand);
    List<Brand> getAllBrands ();
}
