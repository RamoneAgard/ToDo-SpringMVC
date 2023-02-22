package agard.spring.controller;

import agard.spring.model.TodoData;
import agard.spring.model.TodoItem;
import agard.spring.service.TodoItemService;
import agard.spring.util.AttributeNames;
import agard.spring.util.Mappings;
import agard.spring.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

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

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                              Model model){
        log.info("Editing id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        if(todoItem == null){
            todoItem = new TodoItem("","", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todoItem from form= {}", todoItem);
        if(todoItem.getId() == 0){
            todoItemService.addItem(todoItem);
        }
        else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        log.info("Viewing todo item id = {}", id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItemService.getItem(id));
        return ViewNames.VIEW_ITEM;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        log.info("Deleting item with id= {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

}
