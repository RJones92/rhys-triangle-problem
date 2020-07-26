import java.util.*;

public class Product {

    private String productName;
    private List<Row> productRows;

    public Product(String productName) {
        this.productName = productName;
        productRows = new ArrayList<>();
    }

    public String getProductName() {
        return this.productName;
    }

    public List<Row> getProductRows(){
        return productRows;
    }

    public void addProductRow(Row productRow) {
        productRows.add(productRow);
    }

}
