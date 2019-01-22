import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BOARD)

pin = 11

def rc_time (pin):
    count = 0
    GPIO.setup(pin, GPIO.OUT)
    GPIO.output(pin, GPIO.LOW)
    time.sleep(0.1)
    GPIO.setup(pin, GPIO.IN)
    while (GPIO.input(pin) == GPIO.LOW):
        count += 1
    return count
try:
    while True:
        print rc_time(pin)
except KeyboardInterrupt:
    pass
finally:
    GPIO.cleanup()
