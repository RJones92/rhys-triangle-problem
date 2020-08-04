package triangle;

public interface Mapper<T, G> {

//    public ProductGroup mapProducts(List<Row> rowsOfData)
//    public TriangleGroup mapTriangles(ProductGroup productGroup) {

        G mapObjects(T objectsToMap);
    }
