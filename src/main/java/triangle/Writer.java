package triangle;

import java.io.IOException;

public interface Writer {

    void write(TriangleGroup triangleGroup, ProductGroup productGroup, String outputFilename) throws IOException;
    }
