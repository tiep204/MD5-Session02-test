package ra.model.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.model.entity.Todo;
import ra.model.repository.ITodoRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class TodoRepository implements ITodoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Todo> findAll() {
        return entityManager.createQuery("select T from Todo as T", Todo.class)
                .getResultList();
    }

    @Override
    public Todo findById(Long id) {
        return entityManager.createQuery("select T from Todo as T where T.id = :id",Todo.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void save(Todo todo) {
        if (todo.getId()==null){
            //Thêm mới
            entityManager.persist(todo);
        }else {
            entityManager.merge(todo);
        }
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }
}