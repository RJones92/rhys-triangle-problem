package triangle;

import java.io.IOException;
import java.util.List;

public class Controller {

	private final Reader reader;
	private final Writer writer;
	private final ProductMapper productMapper;
	private final TriangleMapper triangleMapper;

	public Controller(Reader reader, Writer writer, ProductMapper productMapper, TriangleMapper triangleMapper) {
		this.reader = reader;
		this.writer = writer;
		this.productMapper = productMapper;
		this.triangleMapper = triangleMapper;
	}

	public void sumTriangles(String inputFile, String outputFile) throws IOException {
		List<Row> rowsOfData = reader.read(inputFile);
		ProductGroup productGroup = productMapper.map(rowsOfData);
		TriangleGroup triangleGroup = triangleMapper.map(productGroup);
		writer.write(triangleGroup, productGroup, outputFile);
	}
}
