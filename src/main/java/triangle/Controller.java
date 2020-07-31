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
		productMapper.mapProducts(rowsOfData);
		triangleMapper.mapTriangles(productMapper);
		csvWriter.writeCsv(triangleMapper, productMapper, outputFile);
	}
}
