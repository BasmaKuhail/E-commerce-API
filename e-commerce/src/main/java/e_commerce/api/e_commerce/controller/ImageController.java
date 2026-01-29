package e_commerce.api.e_commerce.controller;

import e_commerce.api.e_commerce.model.Image;
import e_commerce.api.e_commerce.model.Product;
import e_commerce.api.e_commerce.model.Review;
import e_commerce.api.e_commerce.service.ImageService;
import e_commerce.api.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@RestController
public class ImageController {
    @Autowired
    ImageService imageService;

    @Autowired
    ProductService productService;

    public Image makeImageObj(Map<String, Object> payload){
        String url = (String) payload.get("imageURL");
        String altText = (String) payload.get("altText");
        Boolean isPrimary = (Boolean) payload.get("isPrimary");
        Integer sortOrder = (Integer) payload.get("sortOrder");

        Long pId = Long.valueOf(payload.get("productId").toString());

        Product product = productService.findProductById(pId)
                .orElseThrow(()-> new RuntimeException("Can't find product"));
        Image image = new Image();
        image.setImageURL(url);
        image.setAltText(altText);
        image.setPrimary(isPrimary);
        image.setSortOrder(sortOrder);
        image.setProduct(product);
        return image;
    }
    @PostMapping("/addImage")
    public Image addImage(@RequestBody Map<String, Object> payload){
        Image image = makeImageObj(payload);
        return imageService.addImage(image);
    }

    @GetMapping("/image/{iId}")
    public Image getImageById(@PathVariable Long iId){
        return imageService.getImage(iId);
    }

    @GetMapping("/image/file/{iId}")
    public ResponseEntity<byte[]> getImageFile(@PathVariable Long iId) throws IOException {
        Image img = imageService.getImage(iId);
        Path path = Paths.get("src/main/resources/static/images/" + img.getImageURL());
        byte[] data = Files.readAllBytes(path);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(data);
    }

//    @GetMapping("/image/{iURL}")
//    public Image getImageByImageURL(@PathVariable String iURL){
//        return imageService.getImageByImageURL(iURL);
//    }
}
