package com.obit.ganalyzer.service;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortMessageListener;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SerialPortListener implements SerialPortMessageListener {

    private static final byte MESSAGE_DELIMITER = (byte) 10;

    private final RecordCollector collector;
    private final MessageParser parser;

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        final List<String> record = parser.parse(event);
        if (collector.process(record)) {
            System.exit(0);
        }
    }

    @Override
    public byte[] getMessageDelimiter() {
        return new byte[]{MESSAGE_DELIMITER};
    }


    @Override
    public boolean delimiterIndicatesEndOfMessage() {
        return false;
    }


}
