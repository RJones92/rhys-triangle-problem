public class TriangleMapper extends TriangleGroup {
    
    public TriangleMapper(ProductGroup productGroup){
        super();
        mapTriangles(productGroup);
    }

    private void mapTriangles(ProductGroup productGroup){
        for (Product product : productGroup.getProducts().values()) {
            addTriangle(product, productGroup);
        }
    }


}
