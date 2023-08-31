package ra.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Todo;
import ra.model.repository.TodoRepository;
import ra.model.service.ITodoService;

import java.util.List;
@Service
public class TodoServiceImpl implements ITodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public void save(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void delete(Long id) {
        todoRepository.delete(findById(id));
    }
}
