
import java.util.ArrayList;
import java.util.List;

public class ProductGroup {

    private int lowestOriginYear = 0;
    private int highestDevelopmentYear = 0;
    private List<Product> products;

    public ProductGroup(){
        this.lowestOriginYear = 0;
        this.highestDevelopmentYear = 0;
        this.products = new ArrayList<>();
    }

    public int getLowestOriginYear() {
        return lowestOriginYear;
    }

    public int getHighestDevelopmentYear() {
        return highestDevelopmentYear;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setLowestOriginYear(int lowestOriginYear) {
        this.lowestOriginYear = lowestOriginYear;
    }

    public void setHighestDevelopmentYear(int highestDevelopmentYear) {
        this.highestDevelopmentYear = highestDevelopmentYear;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }
}
