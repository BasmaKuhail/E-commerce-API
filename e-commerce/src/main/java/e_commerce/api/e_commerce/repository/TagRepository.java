package e_commerce.api.e_commerce.repository;

import e_commerce.api.e_commerce.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    public Tag findTagById(Long tId);

    public Tag findTagByName(String tName);
}
