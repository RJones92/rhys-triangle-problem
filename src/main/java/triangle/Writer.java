package triangle;

import java.io.IOException;

public interface Writer {

    public void writeCsv(TriangleGroup triangleGroup, ProductGroup productGroup, String outputFilename) throws IOException;
    }
