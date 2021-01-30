import java.util.List;

public interface ReceiptDataAccess {
    boolean addReceipt(Receipt receipt);
    Receipt getReceipt(int id);
    List<Receipt> getAllReceipts();
    boolean deleteReceipt(int id);
}
