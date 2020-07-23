import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

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

//    private List<Map<String, String>> mapValuesForEachRow(List<List<String>> listToMap){
//
//        List<Map<String, String>> data = new ArrayList<>();
//
//        for (List<String> rowFromList : listToMap) {
//            Map<String, String> mappedRow = new HashMap<>();
//
//            String product = rowFromList.get(0);
//            String originYear = rowFromList.get(1);
//            String developmentYear = rowFromList.get(2);
//            String incrementalValue = rowFromList.get(3);
//
//            mappedRow.put("product", product);
//            mappedRow.put("originYear", originYear);
//            mappedRow.put("developmentYear", developmentYear);
//            mappedRow.put("incrementalValue", incrementalValue);
//            data.add(mappedRow);
//        }
//        return data;
//    }

}
