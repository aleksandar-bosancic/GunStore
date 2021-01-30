import java.util.List;

public class MySQLItemDataAccess implements ItemDataAccess{

    @Override
    public boolean addItem(Item item) {
        return false;
    }

    @Override
    public Item getItem(int id) {
        return null;
    }

    @Override
    public List<Item> getItems(String manufacturer, String model) {
        return null;
    }

    @Override
    public boolean update(Item item) {
        return false;
    }

    @Override
    public boolean delete(Item item) {
        return false;
    }
}
