package e_commerce.api.e_commerce.service;

import e_commerce.api.e_commerce.model.Product;
import e_commerce.api.e_commerce.model.Tag;
import e_commerce.api.e_commerce.repository.ProductRepository;
import e_commerce.api.e_commerce.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    @Autowired
    ProductRepository productRepository;
    public Page<Tag> getTags (Pageable pageable){
        return tagRepository.findAll(pageable);
    }

    public Tag addTag (Tag tag){
        return tagRepository.save(tag);
    }

    public void deleteTag (Long tagId){
        tagRepository.deleteById(tagId);
    }

    public Tag updateTag(Tag tag){
        if(tagRepository.existsById(tag.getId()))
            return tagRepository.save(tag);
        return null;
    }
    public List<Product> findProductsByTagId(Long tId){
        Tag tag = tagRepository.findTagById(tId);
        return tag.getProducts();
    }

    public List<Product> findProductsByTagName(String tName){
        Tag tag = tagRepository.findTagByName(tName);
        return tag.getProducts();
    }
}
