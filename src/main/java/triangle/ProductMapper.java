package triangle;

import java.util.List;

public class ProductMapper implements Mapper<List<Row>, ProductGroup> {

    private ProductGroup productGroup;

    public ProductMapper() {
    }

    @Override
    public ProductGroup mapObjects(List<Row> rows) {
        this.productGroup = new ProductGroup();

        for (Row row : rows) {

            if (isLowestOriginYear(row)) {
                productGroup.setLowestOriginYear(row.getOriginYear());
            }

            if (isHighestDevelopmentYear(row)) {
                productGroup.setHighestDevelopmentYear(row.getDevelopmentYear());
            }

            String productName = row.getProductName();
            if (isNewProduct(productName)) {
                productGroup.addObjectToGroup(productName, new Product(productName));
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
        if (productGroup.getGroup().isEmpty()) {
            return true;
        } else {
            return !productExists(productName);
        }
    }

    private boolean productExists(String productName) {
        return productGroup.getGroup().get(productName) != null;
    }

    private void addRowToProduct(Row row) {
        Product product = productGroup.getGroup().get(row.getProductName());
        product.addProductRow(row);
    }

}
