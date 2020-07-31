package triangle;

import java.io.IOException;
import java.util.List;

public class Controller {

	private final CsvReader reader;
	private final CsvWriter csvWriter;
	private final ProductMapper productMapper;
	private final TriangleMapper triangleMapper;

	public Controller(CsvReader csvReader, CsvWriter csvWriter, ProductMapper productMapper, TriangleMapper triangleMapper) {
		this.reader = csvReader;
		this.csvWriter = csvWriter;
		this.productMapper = productMapper;
		this.triangleMapper = triangleMapper;
	}

	public void sumTriangles(String inputFile, String outputFile) throws IOException {
		List<Row> rowsOfData = reader.readCsv(inputFile);
		ProductGroup productGroup = productMapper.mapProducts(rowsOfData);
		TriangleGroup triangleGroup = triangleMapper.mapTriangles(productGroup);
		csvWriter.writeCsv(triangleGroup, productGroup, outputFile);
	}
}
