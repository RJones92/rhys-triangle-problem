public class Row {
    private String productName;
    private int originYear;
    private int developmentYear;
    private double incrementalValue;


    public Row(String productName, int originYearString, int developmentYearString, double incrementalValueString){
        this.productName = productName;
        this.originYear = originYearString;
        this.developmentYear = developmentYearString;
        this.incrementalValue = incrementalValueString;
    }

    public String getProductName() {
        return productName;
    }

    public int getOriginYear() {
        return originYear;
    }

    public int getDevelopmentYear() {
        return developmentYear;
    }

    public double getIncrementalValue() {
        return incrementalValue;
    }
}
