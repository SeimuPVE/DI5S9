#include "MyBME280Lib.h"
#include <Wire.h>

BME280 bme280;
float pressure;


void setup() {
    Serial.begin(9600);

    if(!bme280.init())
        Serial.println("Device error!");
}

void loop() {
    // Get and print temperatures.
    Serial.print("Temp: ");
    Serial.print(bme280.getTemperature());
    Serial.println("*C");

    // Get and print atmospheric pressure data.
    Serial.print("Pressure: ");
    Serial.print(pressure = bme280.getPressure());
    Serial.println("Pa");

    // Get and print altitude data.
    Serial.print("Altitude: ");
    Serial.print(bme280.calcAltitude(pressure));
    Serial.println("m");

    // Get and print humidity data.
    Serial.print("Humidity: ");
    Serial.print(bme280.getHumidity());
    Serial.println("%");

    Serial.println();

    delay(1000);
}
