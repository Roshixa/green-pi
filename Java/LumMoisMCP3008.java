/*
 * ************** Commands to excute the file ****************
 * javac -classpath .:classes:/opt/pi4j/lib/'*' -d . LumMoisMCP3008.java
 *sudo java -classpath .:classes:/opt/pi4j/lib/'*'  LumMoisMCP3008 -Dpi4j.linking=dynamic -jar 
 */
import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;
import java.nio.ByteBuffer;
import java.io.IOException;
 
public class LumMoisMCP3008 {
 
    public static SpiDevice spi = null;
    public static byte INIT_CMD = (byte) 0xD0;
 
    public static void main(String args[]) throws InterruptedException, IOException { 
        spi = SpiFactory.getInstance(SpiChannel.CS0,
                                     SpiDevice.DEFAULT_SPI_SPEED,
                                     SpiDevice.DEFAULT_SPI_MODE);
 
        while(true) {
            System.out.print("Luminosity : ");
            read(0);
            System.out.print("Moisiture : ");
            read(1);
            Thread.sleep(1000);
        }
    }
 
    public static void read(int channel) throws IOException {
        byte packet[] = new byte[3];
        packet[0] = 0x01;
        packet[1] = (byte) ((0x08 + channel) << 4);
        packet[2] = 0x00;
        byte[] result = spi.write(packet);
        System.out.println( ((result[1] & 0x03 ) << 8) | (result[2] & 0xff) );
    }
}
