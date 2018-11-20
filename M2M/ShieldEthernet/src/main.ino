#include <SPI.h>
#include <Ethernet.h>
#include "Seeed_BME280.h"
#include <Wire.h>
#include <ChainableLED.h>

#define LED_PORT_A 7
#define LED_PORT_B 8

byte mac[] = {0x90, 0xA2, 0xDA, 0x0F, 0xFB, 0xBE};
IPAddress ip(192, 168, 0, 1);
EthernetServer server(80);

BME280 bme280;
ChainableLED led(LED_PORT_A, LED_PORT_B, 1);

String buffer;
char c;


void setup() {
    pinMode(4, OUTPUT);
    digitalWrite(4, HIGH);

    Serial.begin(9600);
    while (!Serial);

    Serial.println("Ethernet WebServer Example");

    Ethernet.begin(mac, ip);
    server.begin();

    Serial.print("Server is at ");
    Serial.println(Ethernet.localIP());

    led.init();
    if(!bme280.init())
        Serial.println("Error with BME280 !");
}

void loop() {
    EthernetClient client = server.available();

    if(client) {
        Serial.println("New client");

        // An http request ends with a blank line.
        bool currentLineIsBlank = true;

        buffer = "";
        while(client.connected()) {
            if(client.available()) {
                c = client.read();

                // If you've gotten to the end of the line (received a newline character) and the line is blank, the http request has ended, so you can send a reply.
                if(c == '\n' && currentLineIsBlank) {
                    // Print the data sent by the web browser.
                    if(buffer.indexOf("led_control=") != -1)
                        if(buffer.charAt(buffer.indexOf("led_control=") + 12) == 'r')
                            led.setColorRGB(0, 255, 0, 0);
                        else if(buffer.charAt(buffer.indexOf("led_control=") + 12) == 'g')
                            led.setColorRGB(0, 0, 255, 0);
                        else if(buffer.charAt(buffer.indexOf("led_control=") + 12) == 'b')
                            led.setColorRGB(0, 0, 0, 255);

                    client.println("HTTP/1.1 200 OK");
                    client.println("Content-Type: text/html");
                    client.println("Connection: close");
                    client.println();
                    client.println("<!DOCTYPE HTML>");
                    client.println("<meta charset=\"UTF-8\"> ");
                    client.println("<meta http-equiv=\"refresh\" content=\"5; URL=http://192.168.0.1/\">");
                    client.println("<html>");

                    // Output the value of each analog input pin.
                    // Get and print temperatures.
                    client.println("<section>");
                    client.print("<div>Temperature : ");
                    client.print(bme280.getTemperature());
                    client.println(" °C</div>");

                    // Get and print atmospheric pressure data.
                    client.print("<div>Pressure : ");
                    client.print(bme280.getPressure() / 100);
                    client.println(" hPa</div>");

                    // Get and print altitude data.
                    client.print("<div>Altitude: ");
                    client.print(bme280.calcAltitude(bme280.getPressure()));
                    client.println("m</div>");

                    // Get and print humidity data.
                    client.print("<div>Humidity: ");
                    client.print(bme280.getHumidity());
                    client.println("%</div>");
                    client.println("</section>");


                    // Add three buttons to control the output led.
                    client.println("<section>");
                    client.println("<form method=\"GET\">");
                    client.println("<input type=\"submit\" name=\"led_control\" value=\"red\">");
                    client.println("<input type=\"submit\" name=\"led_control\" value=\"green\">");
                    client.println("<input type=\"submit\" name=\"led_control\" value=\"blue\">");
                    client.println("</form>");
                    client.println("</section>");
                    client.println("</html>");

                    break;
                }

                if(c == '\n') // You're starting a new line.
                    currentLineIsBlank = true;
                else if (c != '\r') { // You've gotten a character on the current line.
                    buffer += c;
                    currentLineIsBlank = false;
                }
            }
        }

        // Give the web browser time to receive the data.
        delay(1);

        // Close the connection.
        client.stop();
        Serial.println("client disconnected");
    }
}
