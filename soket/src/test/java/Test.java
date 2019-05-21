import com.bych.soket.SerialPortWinChannel;

/**
 * @Description: TODO
 * @Author: lxl
 * @CreateDate: 2019/05/11
 * @Version:
 */
public class Test {
    public static void main(String[] args) {

        int portNo = 1;
        int baud = 115200;
        char parity = 'N';
        int databits = 8;
        int stopsbits = 1;
        short dwCommEvents = 1;

        SerialPortWinChannel serial = new SerialPortWinChannel();
        serial.setConfig(portNo, baud, parity, databits, stopsbits, dwCommEvents);




    }
}
