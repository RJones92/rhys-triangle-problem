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

            String productName = row.getProductName();
            if (isNewProduct(productName)) {
                addProduct(productName, new Product(productName));
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

    private boolean isNewProduct(String productName) {
        if (getProducts().isEmpty()) {
            return true;
        } else {
            if (!productExists(productName)) {
                return true;
            }
        }
        return false;
    }

    private boolean productExists(String productName) {
        if (getProducts().get(productName) != null) {
            return true;
        }
        return false;
    }

    private void addRowToProduct(Row row) {
        Product product = getProducts().get(row.getProductName());
        product.addProductRow(row);
    }
}