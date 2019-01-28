import sys
import Adafruit_DHT

sensor = Adafruit_DHT.DHT11
pin = 21
humidity, temperature = Adafruit_DHT.read_retry(sensor, pin)
if humidity is not None and temperature is not None:
    print('Temperature={0:0.1f} Deg \nHumidity={1:0.1f}%'.format(temperature, humidity))
else:
    sys.exit(1)