package com.obit.ganalyzer.service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CsvFileWriter {

    public void writeToFile(List<List<String>> records) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        final FileWriter fileWriter = new FileWriter("C:\\ARDUINO\\out.csv");

        final CSVWriter csvWriter = new CSVWriter(fileWriter);
        for (List<String> record :  records) {
            csvWriter.writeNext(record.toArray(new String[0]));
        }
        csvWriter.close();
    }

}
