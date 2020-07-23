import java.util.List;

public class ProductMapper extends ProductGroup {

    public ProductMapper(List<Row> rowsOfData) {
        super();
        setProductGroup(rowsOfData);
    }

    public void setProductGroup(List<Row> rowsOfData) {

        for (Row row : rowsOfData) {

            if (isLowestOriginYear(row)) {
                setLowestOriginYear(row.getOriginYear());
            }

            if (isHighestDevelopmentYear(row)) {
                setHighestDevelopmentYear(row.getDevelopmentYear());
            }

            if (isNewProduct(row)) {
                addProduct(new Product(row.getProductName()));
            }

            addRowToProduct(row);
        }
    }

    private boolean isLowestOriginYear(Row row) {
        int originYear = row.getOriginYear();
        if (originYear < getLowestOriginYear() || getLowestOriginYear() == 0) {
            return true;
        }
        return false;
    }

    private boolean isHighestDevelopmentYear(Row row) {
        int developmentYear = row.getDevelopmentYear();
        if (developmentYear > getHighestDevelopmentYear() || getHighestDevelopmentYear() == 0) {
            return true;
        }
        return false;
    }

    private boolean isNewProduct(Row row) {
        String productName = row.getProductName();
        if (getProducts().isEmpty()) {
            return true;
        } else {
            if (!productExists(productName, getProducts())) {
                return true;
            }
        }
        return false;
    }

    private boolean productExists(String productName, List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    private void addRowToProduct(Row row) {
        for (Product product : getProducts()) {
            if (product.getProductName().equals(row.getProductName())) {
                product.addProductRow(row);
                break;
            }
        }
    }
}