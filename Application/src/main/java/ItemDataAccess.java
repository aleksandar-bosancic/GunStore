import java.util.List;

public interface ItemDataAccess {
    boolean addItem(Item item);
    Item getItem(int id);
    List<Item> getItems(String manufacturer, String model);
    boolean update(Item item);
    boolean delete(Item item);
}
