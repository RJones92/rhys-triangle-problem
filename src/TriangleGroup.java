import java.util.HashMap;
import java.util.Map;

public class TriangleGroup {
    //stores commonalities across the group of triangles

    private Map<String, Triangle> triangles;

    public TriangleGroup(){
        this.triangles = new HashMap();
    }

    public Map<String, Triangle> getTriangles(){
        return triangles;
    }

    public void addTriangle(Product product, ProductGroup productGroup){
        triangles.put(product.getProductName(), new Triangle(productGroup, product));
    }


}
