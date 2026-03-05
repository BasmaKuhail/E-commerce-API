package e_commerce.api.e_commerce.infrastructure.persistence.controller;

import e_commerce.api.e_commerce.application.service.BrandService;
import e_commerce.api.e_commerce.domain.model.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        Brand savedBrand = brandService.createBrand(brand);
        return new ResponseEntity<>(savedBrand, HttpStatus.CREATED);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        Optional<Brand> brand = brandService.getBrandById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        brand.setId(id); // ensure the id matches the path
        Brand updatedBrand = brandService.updateBrand(brand);
        return ResponseEntity.ok(updatedBrand);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }

    // LIST ALL (optional, implement findAll in service/repository)
    @GetMapping
    public ResponseEntity<?> getAllBrands() {
         return ResponseEntity.ok(brandService.getAllBrands());
//        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
//                .body("Not implemented yet");
    }
}
