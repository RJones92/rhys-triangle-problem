package triangle;

import java.util.List;

public class ProductMapper {

    private final ProductGroup productGroup;

    public ProductMapper() {
        super();
        productGroup = new ProductGroup();
    }

    public ProductGroup mapProducts(List<Row> rowsOfData) {
        for (Row row : rowsOfData) {

            if (isLowestOriginYear(row)) {
                productGroup.setLowestOriginYear(row.getOriginYear());
            }

            if (isHighestDevelopmentYear(row)) {
                productGroup.setHighestDevelopmentYear(row.getDevelopmentYear());
            }

            String productName = row.getProductName();
            if (isNewProduct(productName)) {
                productGroup.addProduct(productName, new Product(productName));
            }

            addRowToProduct(row);
        }
        return productGroup;
    }

    private boolean isLowestOriginYear(Row row) {
        int originYear = row.getOriginYear();
        if (originYear < productGroup.getLowestOriginYear() || productGroup.getLowestOriginYear() == 0) {
            return true;
        }
        return false;

    }

    private boolean isHighestDevelopmentYear(Row row) {
        int developmentYear = row.getDevelopmentYear();
        if (developmentYear > productGroup.getHighestDevelopmentYear() || productGroup.getHighestDevelopmentYear() == 0) {
            return true;
        }
        return false;
    }

    private boolean isNewProduct(String productName) {
        if (productGroup.getProducts().isEmpty()) {
            return true;
        } else {
            return !productExists(productName);
        }
    }

    private boolean productExists(String productName) {
        return productGroup.getProducts().get(productName) != null;
    }

    private void addRowToProduct(Row row) {
        Product product = productGroup.getProducts().get(row.getProductName());
        product.addProductRow(row);
    }

}
