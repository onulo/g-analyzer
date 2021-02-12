package com.obit.ganalyzer.service;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Component
@RequiredArgsConstructor
public class RecordCollector {

    private final CsvFileWriter csvFileWriter;

    @Value("${file.size}")
    private Integer fileSize;

    private final List<List<String>> collection = new ArrayList<>();

    public boolean process(List<String> record) {
        if (collection.size() < fileSize) {
            collection.add(record);
            return false;
        } else {
            csvFileWriter.writeToFile(collection);
            log.info("Successfully written {} records to file", collection.size());
            return true;
        }
    }
}
