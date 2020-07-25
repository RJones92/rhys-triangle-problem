import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {

    public void writeCsv(TriangleGroup triangleGroup, ProductGroup productGroup, String filename) throws IOException {

        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(filename))) {

            //first line of the output file is earliest origin year + range of years
            csvWriter.append(Integer.toString(productGroup.getLowestOriginYear()));
            csvWriter.append(",");
            csvWriter.append(Integer.toString(productGroup.getRangeOfYears()));
            csvWriter.append("\n");

            //every other line should be a Triangle
            for (Triangle triangle : triangleGroup.getTriangles().values()){
                csvWriter.append(String.join(",", triangle.getTriangleData()));
                csvWriter.append("\n");
            }

        }

    }

}
