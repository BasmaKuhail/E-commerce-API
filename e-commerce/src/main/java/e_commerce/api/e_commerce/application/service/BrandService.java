package e_commerce.api.e_commerce.application.service;


import e_commerce.api.e_commerce.domain.model.Brand;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface BrandService {
    Brand createBrand(Brand brand);

    Optional<Brand> getBrandById(Long id);

    List<Brand> getAllBrands();

    Brand updateBrand(Brand brand);

    void deleteBrand(Long id);

}
