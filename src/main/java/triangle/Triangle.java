package triangle;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    ProductGroup productGroup;
    Product product;
    List<String> triangleData;

    public Triangle(ProductGroup productGroup, Product product){
        this.productGroup = productGroup;
        this.product = product;
        this.triangleData = calculateTriangle(productGroup.getLowestOriginYear(), productGroup.getHighestDevelopmentYear());
    }

    public List<String> getTriangleData(){
        return triangleData;
    }

    private List<String> calculateTriangle(int startingYear, int lastYear){

        List<String> outputTriangle = new ArrayList<>();
        outputTriangle.add(product.getProductName());

        //set up for loop
        int rowCounter = 0;
        double accumulatedValue = 0;

        //loop through possible originYear's
        try {
            for (int originYear = startingYear; originYear < (lastYear + 1); originYear++) {
                Row productRow = product.getProductRows().get(rowCounter);
                int originYearForRow = productRow.getOriginYear();
                int developmentYearForRow = productRow.getDevelopmentYear();

                //loop through possible developmentYears
                for (int developmentYear = originYear; developmentYear < (lastYear + 1); developmentYear++) {

                    //if originYear & developmentYear match, accumulate then move onto next row of data
                    if ((originYearForRow == originYear) && (developmentYearForRow == developmentYear)) {
                        accumulatedValue += productRow.getIncrementalValue();

                        //match found so look at next row
                        rowCounter++;
                        if (rowCounter < product.getProductRows().size()) {
                            productRow = product.getProductRows().get(rowCounter);
                            originYearForRow = productRow.getOriginYear();
                            developmentYearForRow = productRow.getDevelopmentYear();
                        }

                    }
                    //for every developmentYear, even if there's no value, add the accValue
                    outputTriangle.add(Double.toString(accumulatedValue));

                }
                //once we've finished with an originYear, reset the accumulated value
                accumulatedValue = 0;

            }
        } catch (IndexOutOfBoundsException e){
            System.out.println("IndexOutOfBoundsException found.");
            System.out.println(e.getMessage());
        }

        return outputTriangle;
    }

}
