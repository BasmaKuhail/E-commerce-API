package e_commerce.api.e_commerce.domain.model;

import e_commerce.api.e_commerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Brand {
    private Long id;
    private String name;
    private String description;
    private String logoURL;
    private List<Product> products = new ArrayList<>();

    public Brand(Long id, String name, String description, String logoURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.logoURL = logoURL;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
