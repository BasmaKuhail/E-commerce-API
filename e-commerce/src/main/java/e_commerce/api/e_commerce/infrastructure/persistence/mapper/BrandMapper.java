package e_commerce.api.e_commerce.infrastructure.persistence.mapper;

import e_commerce.api.e_commerce.domain.model.Brand;
import e_commerce.api.e_commerce.infrastructure.persistence.entity.BrandEntity;

public class BrandMapper {

    public static Brand toDomain(BrandEntity entity) {
        return new Brand(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getLogoURL()
        );
    }

    public static BrandEntity toEntity(Brand brand) {
        BrandEntity entity = new BrandEntity();
        entity.setId(brand.getId());
        entity.setName(brand.getName());
        entity.setDescription(brand.getDescription());
        entity.setLogoURL(brand.getLogoURL());
        return entity;
    }
}