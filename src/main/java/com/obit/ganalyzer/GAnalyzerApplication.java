package com.obit.ganalyzer;

import com.fazecast.jSerialComm.SerialPort;
import com.obit.ganalyzer.service.SerialPortListener;
import com.obit.ganalyzer.service.SerialPortProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class GAnalyzerApplication implements CommandLineRunner {

    private final SerialPortProvider serialPortProvider;
    private final SerialPortListener serialPortListener;

    public static void main(String[] args) {
        SpringApplication.run(GAnalyzerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        //refactor port to bean because it should be accesible for closinf in service ???
        final SerialPort serialPort = serialPortProvider.findSerialPort();
        log.info("Opening port {}", serialPort);
        serialPort.openPort();
        log.info("Register serial port listener");
        serialPort.addDataListener(serialPortListener);
    }
}
