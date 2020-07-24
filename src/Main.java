
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        CsvReader csvReader = new CsvReader();
        List<Row> rowsOfData = csvReader.readCsv(args[0]);

        ProductMapper productMapper = new ProductMapper(rowsOfData);



        //Data store for csv output file
        List<List<String>> outputList = new LinkedList<>();

        //first line of the output file
        int rangeOfYears = (productMapper.getHighestDevelopmentYear() - productMapper.getLowestOriginYear()) + 1;
        outputList.add(new ArrayList<>(
                Arrays.asList(
                        Integer.toString(productMapper.getLowestOriginYear()),
                        Integer.toString(rangeOfYears))
        ));

        //for each product, calculate the 'triangle' then add as a line in the output file
        for (Product product : productMapper.getProducts().values()) {
            outputList.add(product.calculateOutput(productMapper.getLowestOriginYear(), productMapper.getHighestDevelopmentYear()));
        }

        //send each product triangle calculation to be written to a csv file
        CsvWriter.writeCsv(outputList, args[1]);

    }


    private static boolean productExists(String productName, List<Product> products) {
        boolean productAlreadyExits = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equals(productName)) {
                productAlreadyExits = true;
                break;
            }
        }
        return productAlreadyExits;
    }

}
