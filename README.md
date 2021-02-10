# G-Analyzer


G-Analyzer is a project intended to reading g-force data using ARDUINO and accelerometer and record those data to csv file for further analysis.

## Basic setup

For basic setup you will need ARDUINO with accelerometer connected to PC via USB cable.

**accelerometer** --> **arduino**  --> **pc with g-analyzer**

## Installation

### Arduino 
* Upload [source code](arduino/accelerometer-v1/accelerometer-v1.ino) to ARDUINO using Arduino IDE

### PC
* Download the latest version of [jar file](https://github.com/onulo/g-analyzer/releases) of g-analyzer

## Usage
 Connect ARDUINO to pc and run g-analyzer with command:

```bash
  java -jar -Dfile.size=50 -Dport.baudRate=112500 -Dmessages.strictMode=true -Dfile.name=C:\ARDUINO\out.csv  g-analyzer-[latest].jar
```

![Maven Package](https://github.com/onulo/g-analyzer/workflows/Maven%20Package/badge.svg)

