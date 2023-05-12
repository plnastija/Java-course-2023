package lt.anastasija.BaigiamasisProjektas.repo;

import lt.anastasija.BaigiamasisProjektas.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
