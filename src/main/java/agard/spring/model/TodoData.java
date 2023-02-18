package agard.spring.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    // Fields //
    private static int idValue = 1;
    private final List<TodoItem> items = new ArrayList<>();

    // Constructors //
    public TodoData(){
        // Dummy Data for now //
        addItem(new TodoItem("first", "1 details...", LocalDate.now()));
        addItem(new TodoItem("second", "2 details...", LocalDate.now()));
        addItem(new TodoItem("third", "3 details...", LocalDate.now()));
        addItem(new TodoItem("forth", "4 details...", LocalDate.now()));
    }

    // Public Methods //
    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd){
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    public void removeItem(int id){
        ListIterator<TodoItem> itemListIterator = items.listIterator();

        while(itemListIterator.hasNext()){
            TodoItem item = itemListIterator.next();

            if(item.getId() == id){
                itemListIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id){
        for(TodoItem td : items){
            if(td.getId() == id){
                return td;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate){
        ListIterator<TodoItem> itemListIterator = items.listIterator();

        while(itemListIterator.hasNext()){
            TodoItem item = itemListIterator.next();

            if(item.equals(toUpdate)){
                itemListIterator.set(toUpdate);
                break;
            }
        }
    }



}
