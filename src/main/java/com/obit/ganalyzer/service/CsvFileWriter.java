package com.obit.ganalyzer.service;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CsvFileWriter {

    @Value("${file.name}")
    private String fileName;

    public void writeToFile(List<List<String>> records) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        final FileWriter fileWriter = new FileWriter(fileName);

        final CSVWriter csvWriter = new CSVWriter(fileWriter);
        for (List<String> record : records) {
            csvWriter.writeNext(record.toArray(new String[0]));
        }
        csvWriter.close();
    }

}
