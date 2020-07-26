public class TriangleMapper extends TriangleGroup {
    
    public TriangleMapper(){
        super();
    }

    public void mapTriangles(ProductGroup productGroup){
        for (Product product : productGroup.getProducts().values()) {
            addTriangle(product, productGroup);
        }
    }


}
