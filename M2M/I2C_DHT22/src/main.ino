#include "DHT.h"
#include <Wire.h>
#include "rgb_lcd.h"
#include <ChainableLED.h>

#define DHT_PIN 3
#define DHTTYPE DHT22
#define LED_PORT_A 7
#define LED_PORT_B 8

DHT dht(DHT_PIN, DHTTYPE);
rgb_lcd lcd;
ChainableLED led(LED_PORT_A, LED_PORT_B, 1);
float h, t, f;


void setup() {
    lcd.begin(16, 2);
    lcd.setCursor(0, 0);
    lcd.print("Let me start");
    lcd.setCursor(0, 1);
    lcd.print("please !");

    led.init();

    dht.begin();
}

void loop() {
    h = dht.readHumidity();
    t = dht.readTemperature();
    f = dht.readTemperature(true);

    if (isnan(h) || isnan(t) || isnan(f)) {
        lcd.clear();

        lcd.setCursor(0, 0);
        lcd.print("Failed to read");

        lcd.setCursor(0, 1);
        lcd.print("from DHT sensor!");
    }
    else {
        lcd.clear();

        lcd.setCursor(0, 0);
        lcd.print("Humidity: ");
        lcd.print(h);
        lcd.print("%");

        lcd.setCursor(0, 1);
        lcd.print("Temp:    ");
        lcd.print(t);
        lcd.print("*C");

        if(t < 16)
            led.setColorRGB(0, 0, 0, 255);
        else if(t > 24)
            led.setColorRGB(0, 255, 0, 0);
        else
            led.setColorRGB(0, 0, 255, 0);
    }

    delay(2000);
}
