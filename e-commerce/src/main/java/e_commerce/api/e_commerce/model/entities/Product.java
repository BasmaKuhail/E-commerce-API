package e_commerce.api.e_commerce.model.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
    private Long id;

    private String productName;
    private String description;
    private double basePrice;
    private double salePercentage;
    private boolean isOnSale;
    private boolean isAvailable;
    private int moq;
    private String materialComposition;
    private String badge;
    private double averageRating;
    private int reviewCount;
    private boolean isFreeDelivery;
    private int weight;

    @Column
    private LocalDate dateAdded;
    private String metaTitle;
    private String slug;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_tag",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    Set<ProductTag> productTag = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Variant> variants; = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brand brand;

    public Product(Long id, String description, String productName, double basePrice, double salePercentage, boolean isOnSale, int moq, boolean isAvailable, String materialComposition, String badge, int reviewCount, double averageRating, boolean isFreeDelivery, int weight, LocalDate dateAdded, String metaTitle, String slug, Set<ProductTag> productTag, List<Image> images, List<Variant> variants, Category category, Brand brand) {
        this.id = id;
        this.description = description;
        this.productName = productName;
        this.basePrice = basePrice;
        this.salePercentage = salePercentage;
        this.isOnSale = isOnSale;
        this.moq = moq;
        this.isAvailable = isAvailable;
        this.materialComposition = materialComposition;
        this.badge = badge;
        this.reviewCount = reviewCount;
        this.averageRating = averageRating;
        this.isFreeDelivery = isFreeDelivery;
        this.weight = weight;
        this.dateAdded = dateAdded;
        this.metaTitle = metaTitle;
        this.slug = slug;
        this.productTag = productTag;
        this.images = images;
        this.variants = variants;
        this.category = category;
        this.brand = brand;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getSalePercentage() {
        return salePercentage;
    }

    public void setSalePercentage(double salePercentage) {
        this.salePercentage = salePercentage;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getMaterialComposition() {
        return materialComposition;
    }

    public void setMaterialComposition(String materialComposition) {
        this.materialComposition = materialComposition;
    }

    public int getMoq() {
        return moq;
    }

    public void setMoq(int moq) {
        this.moq = moq;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public boolean isFreeDelivery() {
        return isFreeDelivery;
    }

    public void setFreeDelivery(boolean freeDelivery) {
        isFreeDelivery = freeDelivery;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Set<ProductTag> getProductTag() {
        return productTag;
    }

    public void setProductTag(Set<ProductTag> productTag) {
        this.productTag = productTag;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}