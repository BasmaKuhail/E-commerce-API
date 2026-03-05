package e_commerce.api.e_commerce.application.service.impl;

import e_commerce.api.e_commerce.application.service.BrandService;
import e_commerce.api.e_commerce.domain.model.Brand;
import e_commerce.api.e_commerce.domain.repository.BrandRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Optional<Brand> getBrandById(Long id) {
        return brandRepository.findBrandById(id);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.getAllBrands();
    }

    @Override
    public Brand updateBrand(Brand brand) {
        return brandRepository.save(brand); // in simple cases, save() handles update
    }

    @Override
    public void deleteBrand(Long id) {
        // You can add a delete method in the repository if needed
        throw new UnsupportedOperationException("Not implemented yet");
    }
}