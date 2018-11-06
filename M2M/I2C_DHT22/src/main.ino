//#include "DHT.h"
//#include <Wire.h>
//#include <LiquidCrystal_I2C.h>
//
//#define DHT_PIN 3
//#define DHTTYPE DHT22
//#define I2C_ADDR 0x27
//
//DHT dht(DHT_PIN, DHTTYPE);
//LiquidCrystal_I2C lcd(I2C_ADDR, 16, 2);
//
//
//void setup() {
//    lcd.init();
//    lcd.backlight();
//    lcd.home();
//
//    Serial.begin(9600);
//    Serial.println("DHT22 test!");
//
//    dht.begin();
//}
//
//void loop() {
//    lcd.setCursor((uint8_t)0, 0);
//    lcd.print("Hello World !");
//
//    float h = dht.readHumidity();
//    float t = dht.readTemperature();
//    float f = dht.readTemperature(true);
//
//    if (isnan(h) || isnan(t) || isnan(f)) {
//        Serial.println("Failed to read from DHT sensor!");
//        return;
//    }
//
//    float hif = dht.computeHeatIndex(f, h);
//    float hic = dht.computeHeatIndex(t, h, false);
//
//    Serial.print("Humidity: ");
//    Serial.print(h);
//    Serial.print(" %\t");
//    Serial.print("Temperature: ");
//    Serial.print(t);
//    Serial.print(" *C ");
//    Serial.print(f);
//    Serial.print(" *F\t");
//    Serial.print("Heat index: ");
//    Serial.print(hic);
//    Serial.print(" *C ");
//    Serial.print(hif);
//    Serial.println(" *F");
//
//    delay(2000);
//}


#include <Wire.h>
#include "rgb_lcd.h"

rgb_lcd lcd;


void setup() {
    lcd.begin(16, 2);
    lcd.setCursor(0, );
    lcd.print("Hello bro !");
}

void loop() {
    lcd.print("Hello bro !");
}
