package triangle;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ControllerTest {

	private Controller controller;
	private Reader reader;
	private Writer writer;
	private ProductMapper productMapper;
	private TriangleMapper triangleMapper;

	@Before
	public void setup(){
		reader = mock(Reader.class);
		writer = mock(Writer.class);
		productMapper = mock(ProductMapper.class);
		triangleMapper = mock(TriangleMapper.class);

		controller = new Controller(reader, writer, productMapper, triangleMapper);
	}

	@Test
	public void testSumTriangles() throws IOException {
		String inputFile = "inputfile";
		String outputFile = "outputfile";
		ArrayList<Row> lines = new ArrayList<>();
		ProductGroup productGroup = mock(ProductGroup.class);
		TriangleGroup triangleGroup = mock(TriangleGroup.class);

		when(reader.readCsv(eq(inputFile))).thenReturn(lines);
		when(productMapper.mapProducts(eq(lines))).thenReturn(productGroup);
		when(triangleMapper.mapTriangles(eq(productGroup))).thenReturn(triangleGroup);

		controller.sumTriangles(inputFile, outputFile);

		verify(reader).readCsv(inputFile);
		verify(productMapper).mapProducts(eq(lines));
		verify(triangleMapper).mapTriangles(eq(productGroup));
		verify(writer).writeCsv(eq(triangleGroup), eq(productGroup), eq(outputFile));
	}

}
