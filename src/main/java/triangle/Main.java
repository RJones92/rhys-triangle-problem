package triangle;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Controller controller = new Controller(
                new CsvReader(),
                new CsvWriter(),
                new ProductMapper(new ProductGroup()),
                new TriangleMapper(new TriangleGroup()));
        controller.sumTriangles(args[0], args[1]);
    }

}
