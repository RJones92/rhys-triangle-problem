package triangle;

import java.util.HashMap;
import java.util.Map;

public class TriangleGroup implements Group<Triangle> {

    private Map<String, Triangle> triangles;

    public TriangleGroup(){
        this.triangles = new HashMap();
    }

    @Override
    public Map<String, Triangle> getGroup(){
        return triangles;
    }

    @Override
    public void addObjectToGroup(String objectName, Triangle triangle) {
        triangles.put(objectName, triangle);
    }
}
