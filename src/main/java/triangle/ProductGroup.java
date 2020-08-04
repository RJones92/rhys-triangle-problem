package triangle;

import java.util.HashMap;
import java.util.Map;

public class ProductGroup implements Group<Product> {

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

    @Override
    public Map<String, Product> getGroup() {
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

    @Override
    public void addObjectToGroup(String objectName, Product product) {
        this.products.put(objectName, product);
    }
}
