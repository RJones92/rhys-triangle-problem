package triangle;

import java.io.IOException;
import java.util.List;

public interface Reader {

    List<Row> readCsv(String inputFilename) throws IOException;

}
