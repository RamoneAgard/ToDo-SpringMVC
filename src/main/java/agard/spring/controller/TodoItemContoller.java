package agard.spring.controller;

import agard.spring.model.TodoData;
import agard.spring.service.TodoItemService;
import agard.spring.util.Mappings;
import agard.spring.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class TodoItemContoller {

    // Fields //
    private final TodoItemService todoItemService;

    // Constructors //
    @Autowired
    public TodoItemContoller(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // Model Attributes //
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    // Handler Methods //

    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }
}
