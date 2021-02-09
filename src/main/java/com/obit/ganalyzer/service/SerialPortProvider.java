package com.obit.ganalyzer.service;

import com.fazecast.jSerialComm.SerialPort;
import com.obit.ganalyzer.exception.NoPortFoundException;
import java.util.Arrays;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SerialPortProvider {

    @Value("${port.baudRate}")
    private Integer baudRate;

    public SerialPort findSerialPort() throws NoPortFoundException {
        final SerialPort[] ports = SerialPort.getCommPorts();
        if (ports.length > 0) {
            log.info("Fond {} serial ports: {}", ports.length, Arrays.stream(ports).toArray());
            final SerialPort port = Arrays.stream(ports).filter(p -> p.getDescriptivePortName().contains("USB")).findAny()
                    .orElseThrow(() -> new NoPortFoundException("No USB port found"));
            log.info("Resolved port: {}", port.getSystemPortName());
            return configureSerialPort(port);

        } else {
            log.error("No Serial port found");
            throw new NoPortFoundException("No Serial port found!");
        }
    }

    private SerialPort configureSerialPort(SerialPort port) {
        port.setBaudRate(baudRate);
        return port;
    }
}
