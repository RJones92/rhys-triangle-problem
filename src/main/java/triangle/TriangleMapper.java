package triangle;

public class TriangleMapper implements Mapper<ProductGroup, TriangleGroup> {

    private final TriangleGroup triangleGroup;

    public TriangleMapper() {
        triangleGroup = new TriangleGroup();
    }

    @Override
    public TriangleGroup mapObjects(ProductGroup productGroup) {
        for (Product product : productGroup.getGroup().values()) {
            triangleGroup.addObjectToGroup(product.getProductName(), new Triangle(productGroup, product));
        }
        return triangleGroup;
    }

}
