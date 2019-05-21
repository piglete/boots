package com.bych.soket;

import com.sun.jna.Library;
import com.sun.jna.Native;

import java.io.File;
import java.io.IOException;

public class SerialPortWinChannel {
	int portNo = 1;
	int baud = 115200;
	char parity = 'N';
	int databits = 8;
	int stopsbits = 1;
	short dwCommEvents = 1;
	byte[] buf = new byte[4096];
	static String env = "x64";
	static {
		String arch = System.getProperty("sun.arch.data.model");
		System.out.println(arch);

		if (arch.equals("64")) {

			env = "x64";
		} else {

			env = "x86";
		}

	}

	public interface SerialPortForWin extends Library {

		/**
		 * 
		 * 当前路径是在项目下，而不是bin输出目录下。
		 */
		public SerialPortForWin INSTANCE = (SerialPortForWin) Native
				.loadLibrary(env + File.separator + "serial_port_dll",
						SerialPortForWin.class);

		boolean InitPort(int portNo, int baud, char parity, int databits,
                         int stopsbits, short dwCommEvents);

		void ClosePort();

		boolean WriteData(byte[] pData, int length);

		int ReadChar(byte[] cRecved, int want_read);

		int GetBytesInCOM();

		int fnSerialPortDLL();

	}

	public void setConfig(int portNo, int baud, char parity, int databits,
			int stopsbits, short dwCommEvents) {

		this.portNo = portNo;
		this.baud = baud;
		this.parity = parity;
		this.databits = databits;
		this.stopsbits = stopsbits;
		this.dwCommEvents = dwCommEvents;

	}

	public int initChannel() {
		// TODO Auto-generated method stub
		if (SerialPortForWin.INSTANCE.InitPort(portNo, baud, parity, databits,
				stopsbits, dwCommEvents)) {

			return 0;
		} else {

			return -1;
		}
	}

	public int write(byte[] command, int length) {
		// TODO Auto-generated method stub
		
		if(SerialPortForWin.INSTANCE.WriteData(command, length)){
			
			return 0;
		}
		return -1;
	}

	public int available() throws IOException {
		// TODO Auto-generated method stub
		return SerialPortForWin.INSTANCE.GetBytesInCOM();
	}

	public int read(byte[] buffer, int offset, int length) {
		// TODO Auto-generated method stub
		  int revCount = SerialPortForWin.INSTANCE.ReadChar(buf,length);
	       System.arraycopy(buf,0,buffer,offset,length);
	       return revCount;
	}

	public int reset() {
		// TODO Auto-generated method stub
		SerialPortForWin.INSTANCE.ClosePort();
		initChannel();
		return 0;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		SerialPortForWin.INSTANCE.ClosePort();
	}

}
