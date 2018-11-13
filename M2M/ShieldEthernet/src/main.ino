#include <SPI.h>
#include <Ethernet.h>

// Enter a MAC address and IP address for your controller below.
// The IP address will be dependent on your local network.
byte mac[] = {0x90, 0xA2, 0xDA, 0x0F, 0xFB, 0xBE};
IPAddress ip(192, 168, 1, 2);

// Initialize the Ethernet server library.
// With the IP address and port you want to use (port 80 is default for HTTP).
EthernetServer server(80);


void setup() {
	// You can use Ethernet.init(pin) to configure the CS pin.
	//Ethernet.init(10);  // Most Arduino shields.
	//Ethernet.init(5);   // MKR ETH shield.
	//Ethernet.init(0);   // Teensy 2.0.
	//Ethernet.init(20);  // Teensy++ 2.0.
	//Ethernet.init(15);  // ESP8266 with Adafruit Featherwing Ethernet.
	//Ethernet.init(33);  // ESP32 with Adafruit Featherwing Ethernet.

	// Open serial communications and wait for port to open.
	Serial.begin(9600);

	while (!Serial); // Wait for serial port to connect. Needed for native USB port only.
	Serial.println("Ethernet WebServer Example.");

	// Start the Ethernet connection and the server.
	Ethernet.begin(mac, ip);

	// Check for Ethernet hardware present.
	if(Ethernet.hardwareStatus() == EthernetNoHardware) {
		Serial.println("Ethernet shield was not found. Sorry, can't run without hardware. :(");

		while (true)
			delay(1); // Do nothing, no point running without Ethernet hardware.
	}

	if (Ethernet.linkStatus() == LinkOFF)
		Serial.println("Ethernet cable is not connected.");

	// Start the server.
	server.begin();
	Serial.print("server is at ");
	Serial.println(Ethernet.localIP());
}

void loop() {
	// Listen for incoming clients.
	EthernetClient client = server.available();
	if (client) {
		Serial.println("new client");
		// An http request ends with a blank line.
		bool currentLineIsBlank = true;

		while (client.connected()) {
			if (client.available()) {
				char c = client.read();
				Serial.write(c);
				// If you've gotten to the end of the line (received a newline character) and the line is blank, the http request has ended, so you can send a reply.

				if (c == '\n' && currentLineIsBlank) {
					// Send a standard http response header.
					client.println("HTTP/1.1 200 OK");
					client.println("Content-Type: text/html");
					client.println("Connection: close");  // The connection will be closed after completion of the response.
					client.println("Refresh: 5");  // Refresh the page automatically every 5 sec.
					client.println();
					client.println("<!DOCTYPE HTML>");
					client.println("<html>");
					
					// Output the value of each analog input pin.
					for (int analogChannel = 0; analogChannel < 6; analogChannel++) {
						int sensorReading = analogRead(analogChannel);
						client.print("analog input ");
						client.print(analogChannel);
						client.print(" is ");
						client.print(sensorReading);
						client.println("<br />");
					}

					client.println("</html>");
				
					break;
				}

				if (c == '\n') // You're starting a new line.
					currentLineIsBlank = true;
				else if (c != '\r') // You've gotten a character on the current line.
					currentLineIsBlank = false;
			}
		}

		// Give the web browser time to receive the data.
		delay(1);

		// Close the connection.
		client.stop();
		Serial.println("client disconnected");
	}
}
