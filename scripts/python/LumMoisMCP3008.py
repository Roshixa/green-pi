import time

import Adafruit_GPIO.SPI as SPI
import Adafruit_MCP3008

# Hardware SPI configuration:
SPI_PORT = 0
SPI_DEVICE = 0
mcp = Adafruit_MCP3008.MCP3008(spi=SPI.SpiDev(SPI_PORT, SPI_DEVICE))

print('| Luminosity | Moisiture  |'.format(*range(2)))
while True:
    luminosity = mcp.read_adc(0)
    moisiture = mcp.read_adc(1)
    print('|    {0:>4}    |    {1:>4}    |'.format(luminosity, moisiture))
    time.sleep(0.5)
