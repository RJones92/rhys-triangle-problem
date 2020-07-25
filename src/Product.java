import java.util.*;

public class Product {

    private String productName;
    private List<Row> productRows;

    public Product(String productName) {
        this.productName = productName;
        productRows = new ArrayList<>();
    }

    public String getProductName() {
        return this.productName;
    }

    public List<Row> getProductRows(){
        return productRows;
    }

    public void addProductRow(Row productRow) {
        productRows.add(productRow);
    }

//    public List<String> calculateOutput(int startingYear, int lastYear) {
//
//        List<String> outputRow = new LinkedList<>();
//        outputRow.add(this.getProductName());
//
//        //set up for loop
//        int rowCounter = 0;
//        double accumulatedValue = 0;
//
//        //loop through possible originYear's
//        try {
//            for (int originYear = startingYear; originYear < (lastYear + 1); originYear++) {
//                Row productRow = productRows.get(rowCounter);
//                int originYearForRow = productRow.getOriginYear();
//                int developmentYearForRow = productRow.getDevelopmentYear();
//
//                //loop through possible developmentYears
//                for (int developmentYear = originYear; developmentYear < (lastYear + 1); developmentYear++) {
//
//                    //if originYear & developmentYear match, accumulate then move onto next row of data
//                    if ((originYearForRow == originYear) && (developmentYearForRow == developmentYear)) {
//                        accumulatedValue += productRow.getIncrementalValue();
//
//                        //match found so look at next row
//                        rowCounter++;
//                        if (rowCounter < productRows.size()) {
//                            productRow = productRows.get(rowCounter);
//                            originYearForRow = productRow.getOriginYear();
//                            developmentYearForRow = productRow.getDevelopmentYear();
//                        }
//
//                    }
//                    //for every developmentYear, even if there's no value, add the accValue
//                    outputRow.add(Double.toString(accumulatedValue));
//
//                }
//                //once we've finished with an originYear, reset the accumulated value
//                accumulatedValue = 0;
//
//            }
//        } catch (IndexOutOfBoundsException e){
//            System.out.println("IndexOutOfBoundsException found.");
//            System.out.println(e.getMessage());
//        }
////        System.out.println(outputRow);
//        return outputRow;
//    }

}
