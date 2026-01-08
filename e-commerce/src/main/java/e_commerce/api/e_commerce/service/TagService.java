package e_commerce.api.e_commerce.service;

import e_commerce.api.e_commerce.model.Tag;
import e_commerce.api.e_commerce.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

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
}
