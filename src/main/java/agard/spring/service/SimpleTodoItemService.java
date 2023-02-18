package agard.spring.service;

import agard.spring.model.TodoData;
import agard.spring.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class SimpleTodoItemService implements TodoItemService {

    // Fields //
    @Getter
    private final TodoData data;

    // Constructors //
    public SimpleTodoItemService() {
        this.data = new TodoData();
    }

    // Public Methods //
    @Override
    public void addItem(TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }
}
