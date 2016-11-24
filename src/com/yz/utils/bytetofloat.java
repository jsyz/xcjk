package com.yz.utils;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class bytetofloat {

	public static float bytes2float(byte[] data) throws IOException {
		DataInputStream dis = new DataInputStream(
				new ByteArrayInputStream(data));
		float f = dis.readFloat();
		dis.close();
		return f;
	}

	public static float bytes2float(byte[] data, int offset, int length)
			throws IOException {

		byte[] tmp = new byte[length];

		for (int i = 0; i < length; i++)
			tmp[i] =  data[i + offset];

		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(tmp));
		float f = dis.readFloat();
		dis.close();
		return f;
	}

	public static void main(String[] args) throws IOException {

		byte[] a = new byte[] { (byte)0xe2, 0x30, 0x2E, 0x37 };

		char[] b = new char[4];

		String nRcvString;

		StringBuffer tStringBuf = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			b[i] = (char) a[i];
		}
		tStringBuf.append(b);
		nRcvString = tStringBuf.toString();

		System.out.print("the resultis +" + nRcvString + "$$"+a.length);
		// byte[] b = { 0x41, (byte) 0xc8, 0, 0 };
		 byte[] c = { (byte)0xe2 ,(byte) 0x5e, (byte)0x40, (byte)0x19 };
		 System.out.println("test is "+bytes2float(c,0,4));
		 
	}
}