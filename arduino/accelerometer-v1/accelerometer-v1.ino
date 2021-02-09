const int xInput = A0;
const int yInput = A1;
const int zInput = A2;
const String DELIMITER = ":";

void setup() {
  analogReference(EXTERNAL);
  Serial.begin(112500);
}

void loop() {
  int xRaw = analogRead(xInput);
  int yRaw = analogRead(yInput);
  int zRaw = analogRead(zInput);

  String xG = (String) (map(xRaw, 0, 1023, -2560, 2560) / float(100));
  String yG = (String) (map(yRaw, 0, 1023, -2560, 2560) / float(100));
  String zG = (String) (map(zRaw, 0, 1023, -2560, 2560) / float(100));

  if (Serial) {

    //message delimiter byte
    Serial.write(10);
    
    Serial.print((String)micros() + DELIMITER +  xG + DELIMITER + yG + DELIMITER + zG);

  }
//    delay(10);
}

