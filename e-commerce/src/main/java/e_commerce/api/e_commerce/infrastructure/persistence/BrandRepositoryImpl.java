package e_commerce.api.e_commerce.infrastructure.persistence;

import e_commerce.api.e_commerce.domain.model.Brand;
import e_commerce.api.e_commerce.domain.repository.BrandRepository;
import e_commerce.api.e_commerce.infrastructure.persistence.entity.BrandEntity;
import e_commerce.api.e_commerce.infrastructure.persistence.mapper.BrandMapper;
import e_commerce.api.e_commerce.infrastructure.persistence.repository.JpaBrandRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public class BrandRepositoryImpl implements BrandRepository {
    private final JpaBrandRepository jpaRepository;

    public BrandRepositoryImpl(JpaBrandRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Brand save(Brand brand) {
        BrandEntity entity = BrandMapper.toEntity(brand);
        entity = jpaRepository.save(entity);
        return BrandMapper.toDomain(entity);
    }

    @Override
    public List<Brand> getAllBrands() {
        List<BrandEntity> entities = jpaRepository.findAll();       // returns BrandEntity
        return entities.stream()
                .map(BrandMapper::toDomain)               // map each entity to domain
                .toList();                                // Java 16+ (or collect(Collectors.toList()))
    }

    @Override
    public Optional<Brand> findBrandById(Long id) {
        return jpaRepository.findById(id)
                .map(BrandMapper::toDomain);
    }
}
