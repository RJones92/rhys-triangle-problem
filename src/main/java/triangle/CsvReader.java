package triangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader{

    public List<Row> readCsv(String filename) throws IOException{

        List<Row> rowsFromCsv = new ArrayList<>();

        try (BufferedReader incrementalClaimsData = (new BufferedReader(new FileReader(filename)))) {

            skipHeader(incrementalClaimsData);

            String dataRow;
            while ((dataRow = incrementalClaimsData.readLine()) != null) {
                String[] values = dataRow.split(", ");
                String product = values[0];
                int originYear = Integer.parseInt(values[1]);
                int developmentYear = Integer.parseInt(values[2]);
                double incrementalValue = Double.parseDouble(values[3]);
                rowsFromCsv.add(new Row(product, originYear, developmentYear, incrementalValue));
            }
        }
        return rowsFromCsv;
    }

    private void skipHeader(BufferedReader incrementalClaimsData) throws IOException {
        incrementalClaimsData.readLine();
    }

}
