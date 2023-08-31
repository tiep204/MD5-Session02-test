package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.entity.Todo;

public interface ITodoRepository extends IGenericRepository<Todo,Long> {

}
