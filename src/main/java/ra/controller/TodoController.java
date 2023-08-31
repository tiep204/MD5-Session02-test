package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.model.entity.Todo;
import ra.model.service.ITodoService;
import ra.model.serviceImpl.TodoServiceImpl;

import java.util.List;

@Controller
public class TodoController {
    @Autowired
    public TodoServiceImpl todoService;

    @GetMapping
    public String list(Model model) {
        List<Todo> todoList = todoService.findAll();
        model.addAttribute("list", todoList);
        return "list";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        Todo todo = new Todo();
        model.addAttribute("todo", todo);
        return "add";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute Todo todo) {
        todoService.save(todo);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Todo todo) {
        todoService.save(todo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        todoService.delete(id);
        return "redirect:/";
    }
}