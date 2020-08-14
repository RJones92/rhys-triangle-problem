package triangle;

import java.io.IOException;
import java.util.List;

public interface Reader {

    List<Row> read(String inputFilename) throws IOException;

}
