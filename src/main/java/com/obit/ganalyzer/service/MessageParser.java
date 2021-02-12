package com.obit.ganalyzer.service;

import com.fazecast.jSerialComm.SerialPortEvent;
import com.obit.ganalyzer.exception.NoReadableDataException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageParser {

    @Value("${messages.strictMode}")
    private boolean strictMode;

    public List<String> parse(SerialPortEvent event) {
        final String message = readMessage(event);
        final List<String> strings = splitMessage(message);
        log.debug(strings.toString());
        validateMessage(strings);
        return strings;
    }

    private void validateMessage(List<String> strings) {
        if(strictMode) {
            if (strings.stream().anyMatch(str -> !NumberUtils.isCreatable(str))) {
                throw new NoReadableDataException(
                        String.format("Message %s can not be represent as a numeric value. You can skip this by disable strictMode", strings));
            }
        }
    }

    private static String readMessage(SerialPortEvent event) {
        byte[] newData = event.getReceivedData();
        if ((newData == null) || (newData.length < 2)) {
            throw new NoReadableDataException("Received data byte[] is null or empty!");
        }
        final byte[] removedDelimiter = removeDelimiter(newData);
        return new String(removedDelimiter, StandardCharsets.UTF_8);
    }

    private static byte[] removeDelimiter(byte[] newData) {
        return ArrayUtils.remove(newData, 0);
    }

    private static List<String> splitMessage(String message) {
        final String[] split = message.split(":");
        final List<String> objects = Arrays.asList(split);
        return objects;
    }
}
