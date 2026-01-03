package e_commerce.api.e_commerce.domain.repository;

import e_commerce.api.e_commerce.domain.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
