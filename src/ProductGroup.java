import java.util.HashMap;
import java.util.Map;

public class ProductGroup {

    private int lowestOriginYear;
    private int highestDevelopmentYear;
    private Map<String, Product> products;

    public ProductGroup(){
        this.lowestOriginYear = 0;
        this.highestDevelopmentYear = 0;
        this.products = new HashMap<>();
    }

    public int getLowestOriginYear() {
        return lowestOriginYear;
    }

    public int getHighestDevelopmentYear() {
        return highestDevelopmentYear;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public int getRangeOfYears(){
        return ((highestDevelopmentYear - lowestOriginYear) + 1);
    }

    public void setLowestOriginYear(int lowestOriginYear) {
        this.lowestOriginYear = lowestOriginYear;
    }

    public void setHighestDevelopmentYear(int highestDevelopmentYear) {
        this.highestDevelopmentYear = highestDevelopmentYear;
    }

    public void addProduct(String productName, Product product){
        this.products.put(productName, product);
    }
}
