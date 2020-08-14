package triangle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter implements Writer{

    @Override
    public void write(TriangleGroup triangleGroup, ProductGroup productGroup, String filename) throws IOException {

        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(filename))) {
            writeFirstLine(csvWriter, productGroup);
            writeTriangles(csvWriter, triangleGroup);
        }

    }

    private void writeFirstLine(BufferedWriter csvWriter, ProductGroup productGroup) throws IOException{
        csvWriter.append(Integer.toString(productGroup.getLowestOriginYear()));
        csvWriter.append(",");
        csvWriter.append(Integer.toString(productGroup.getRangeOfYears()));
        csvWriter.append("\n");
    }

    private void writeTriangles(BufferedWriter csvWriter, TriangleGroup triangleGroup) throws IOException{
        for (Triangle triangle : triangleGroup.getGroup().values()){
            csvWriter.append(String.join(",", triangle.getTriangleData()));
            csvWriter.append("\n");
        }
    }

}
