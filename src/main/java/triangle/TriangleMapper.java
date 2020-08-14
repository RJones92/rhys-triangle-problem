package triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleMapper implements Mapper<ProductGroup, TriangleGroup> {

    private  TriangleGroup triangleGroup;

    public TriangleMapper() {
    }

    @Override
    public TriangleGroup map(ProductGroup productGroup) {
        this.triangleGroup = new TriangleGroup();

        for (Product product : productGroup.getGroup().values()) {
            List<String> triangleData = calculateTriangle(productGroup.getLowestOriginYear(), productGroup.getHighestDevelopmentYear(), product);
            triangleGroup.addObjectToGroup(product.getProductName(), new Triangle(product.getProductName(), triangleData));
        }

        return triangleGroup;
    }

    private List<String> calculateTriangle(int startingYear, int lastYear, Product product) {

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
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException found.");
            System.out.println(e.getMessage());
        }

        return outputTriangle;
    }

}
