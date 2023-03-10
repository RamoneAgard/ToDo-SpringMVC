package agard.spring.service;

import agard.spring.model.TodoData;
import agard.spring.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem toAdd);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem toUpdate);

    TodoData getData();
}
