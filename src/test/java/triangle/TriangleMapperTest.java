package triangle;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TriangleMapperTest {

    private TriangleGroup triangleGroup;
    private TriangleMapper triangleMapper;

    @Before
    public void setUp() {
        triangleMapper = new TriangleMapper();
    }

    @Test
    public void testMapTriangles() {
        ProductGroup mockProductGroup = mock(ProductGroup.class);
        Product product1 = new Product("Product1"); //POJO
        Product product2 = new Product("Product2"); //POJO
        Collection<Product> ProductValues = new ArrayList<>(
                Arrays.asList(product1, product2));

        when(mockProductGroup.getGroup()).thenReturn(mock(Map.class));
        when(mockProductGroup.getGroup().values()).thenReturn(ProductValues);

        triangleGroup = triangleMapper.map(mockProductGroup);
        assertNotNull(triangleGroup);
        assertTrue(triangleGroup instanceof TriangleGroup);

        Map<String, Triangle> triangleMap = triangleGroup.getGroup(); //POJO
        assertTrue(triangleMap.containsKey("Product1"));
        assertTrue(triangleMap.containsKey("Product2"));
        assertEquals(2, triangleMap.size());


    }
}