package triangle;

import com.sun.org.apache.xpath.internal.Arg;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ControllerTest {

	private Controller controller;

	private CsvReader csvReader;
	private CsvWriter csvWriter;
	private ProductMapper productMapper;
	private TriangleMapper triangleMapper;

	@Before
	public void setup(){
		csvReader = mock(CsvReader.class);
		csvWriter = mock(CsvWriter.class);
		productMapper = mock(ProductMapper.class);
		triangleMapper = mock(TriangleMapper.class);

		controller = new Controller(csvReader, csvWriter, productMapper, triangleMapper);
	}

	@Test
	public void testSumTriangles() throws IOException {
		String inputFile = "inputfile";
		String outputFile = "outputfile";

		ArrayList<Row> lines = new ArrayList<>();
		when(csvReader.readCsv(eq(inputFile))).thenReturn(lines);
		controller.sumTriangles(inputFile, outputFile);

		ArgumentCaptor<ProductGroup> productGroupArgumentCaptor = ArgumentCaptor.forClass(ProductGroup.class);
		verify(productMapper).mapProducts(eq(lines));
		verify(triangleMapper).mapTriangles(eq(productGroupArgumentCaptor.capture()));
		verify(csvWriter).writeCsv(eq(triangleMapper), eq(productMapper), eq(outputFile));

		ProductGroup productGroup = productGroupArgumentCaptor.getValue();
		assertEquals(productGroup.getLowestOriginYear(), 5);
	}

}
