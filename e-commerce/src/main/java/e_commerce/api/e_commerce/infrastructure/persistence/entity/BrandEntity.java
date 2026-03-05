package e_commerce.api.e_commerce.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "brand")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;

    private String name;
    private String description;

    @Column(name = "logo_url")
    private String logoURL;

//    @OneToMany
//    private List<ProductEntity> products;

    public BrandEntity() {
    }

    public BrandEntity(Long id, String name, String description, String logoURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.logoURL = logoURL;
//        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

//    public List<ProductEntity> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<ProductEntity> products) {
//        this.products = products;
//    }
}