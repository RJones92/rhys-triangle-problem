package triangle;

import java.util.List;

public class Triangle {

    String triangleName;
    Product product;
    List<String> triangleData;

    public Triangle(String triangleName, List<String> triangleData){
        this.triangleName = triangleName;
        this.triangleData = triangleData;
    }

    public List<String> getTriangleData(){
        return triangleData;
    }



}
