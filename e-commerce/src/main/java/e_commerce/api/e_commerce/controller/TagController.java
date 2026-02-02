package e_commerce.api.e_commerce.controller;

import e_commerce.api.e_commerce.model.Product;
import e_commerce.api.e_commerce.model.Tag;
import e_commerce.api.e_commerce.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public Page<Tag> getTags(@PageableDefault(page = 0, size = 10) Pageable pageable){
        return tagService.getTags(pageable);
    }

    @DeleteMapping("delete/{tagId}")
    public ResponseEntity removeTag(@PathVariable Long tagId){
        tagService.deleteTag(tagId);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/updateTag")
    public Tag updateTag(@RequestBody Tag tag){
        return tagService.updateTag(tag);
    }
    @PostMapping("/updateTag")
    public Tag addTag(@RequestBody Tag tag){
        return tagService.addTag(tag);
    }

    @GetMapping("/productsByTags/{tId}")
    public List<Product> getProductsByTagId(@PathVariable Long tId){
        return tagService.findProductsByTagId(tId);
    }

    @GetMapping("/productsByTagName/{tName}")
    public List<Product> getProductsByTagId(@PathVariable String tName){
        return tagService.findProductsByTagName(tName);
    }
}
