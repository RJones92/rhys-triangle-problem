package triangle;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class ProductMapperTest {

    private ProductMapper productMapper;
    private ProductGroup productGroup;

    @Before
    public void setup(){
        productGroup = new ProductGroup(); //POJO
        productMapper = new ProductMapper(productGroup);
    }

    @Test
    public void testMapProducts() {
        List<Row> lines = new ArrayList<>();
        lines.add(new Row("Product1", 1991, 1991, 20.1));
        lines.add(new Row("Product1", 1991, 1992, 13.0));
        lines.add(new Row("Product1", 1991, 1993, 15.5));
        lines.add(new Row("Product1", 1991, 1991, 101.0));
        lines.add(new Row("Product2", 3000, 3000, 13.2));
        lines.add(new Row("Product2", 3002, 3002, 1.0));
        lines.add(new Row("Product2", 3010, 3010, 32.4));
        lines.add(new Row("Product2", 2099, 3000, 45.6));

        productGroup = productMapper.mapObjects(lines);
        assertNotNull(productGroup);
        assertTrue("Return type instance of ProductGroup", productGroup instanceof ProductGroup);
        assertEquals(1991, productGroup.getLowestOriginYear());
        assertEquals(3010, productGroup.getHighestDevelopmentYear());
        Map<String, Product> productMap = productGroup.getGroup();
        assertTrue("Contains Product1", productMap.containsKey("Product1"));
        assertTrue("Contains Product2", productMap.containsKey("Product2"));
        assertEquals(2, productMap.size());
    }
}