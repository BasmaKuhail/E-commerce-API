package e_commerce.api.e_commerce.model;

public class ProductFilter {
    private String category;
    private String brand;
    private String tag;

    public ProductFilter() {
    }

    public ProductFilter(String category, String brand, String tag) {
        this.category = category;
        this.brand = brand;
        this.tag = tag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
