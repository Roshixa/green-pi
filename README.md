# Green Pi

Green Pi is a project that uses a Raspberry Pi to collect information about plants, and visualize the results.

# Modules

This project is divided into 3 seperate modules:
  - **scripts**: contains the java/python scripts to read values inside the raspberry (for hardware debugging only).
  - **raspberry-backend**: contains the maven project of the service that'll read the sensors values periodically and store them in a local MySQL database.
  - **server**: contains the Java EE app that'll connect remotely to the raspberry elements and visualize the data it stores

### Prerequisites

For the whole project to run successfully you need to have:

* Rasspberry PI:
  - MySQL >= 5.4.0
  - PI4J java
  - Maven
* Sensors:
  - Soil Moisture Sensor
  - MCP3008
  - DHT11
  - LDR
* Server with JDK >= 8 installed

### Running the projects

To run the project we need to run the **raspberry-backend** first, and then the **server** module.

- **raspberry-backend**: Unfortunately because of the time limit and deadlines of this project, we couldn't debug how to automate the launch of the maven app inside the raspberry PI. To run this module, you need to login the remote UI of raspberry and lunch the project with Eclipse.
- **server**: Same as the previous module, it should be launched in your own preferable IDE locally (or on a server)


### Plugins

The project uses many third party libraries and framework, such as:

| Library/Framework | Link |
| ------ | ------ |
| JUnit | <https://junit.org/junit4/> |
| Mockito | <https://site.mockito.org/> |
| Pi4j | <http://pi4j.com/> |
| Adafruit | <https://github.com/adafruit/DHT-sensor-library> |
| Highcharts | <https://www.highcharts.com/> |

### Todos

 - Automate the build/deployment process for all modules
 - Refactor the **raspberry-backend** even more!!
 - Need to use Logging

License
----

MIT
