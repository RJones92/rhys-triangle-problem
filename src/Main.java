
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        CsvReader csvReader = new CsvReader();
        List<Row> rowsOfData = csvReader.readCsv(args[0]);

        ProductMapper productMapper = new ProductMapper();
        productMapper.mapProducts(rowsOfData);

        TriangleMapper triangleMapper = new TriangleMapper();
        triangleMapper.mapTriangles(productMapper);

        CsvWriter csvWriter = new CsvWriter();
        csvWriter.writeCsv(triangleMapper, productMapper, args[1]);

    }

}
