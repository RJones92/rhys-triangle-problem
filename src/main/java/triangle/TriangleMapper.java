package triangle;

public class TriangleMapper {

    private final TriangleGroup triangleGroup;

    public TriangleMapper(){
        super();
        triangleGroup = new TriangleGroup();
    }

    public TriangleGroup mapTriangles(ProductGroup productGroup){
        for (Product product : productGroup.getProducts().values()) {
            triangleGroup.addTriangle(product, productGroup);
        }
        return triangleGroup;
    }


}
