package com.yz.utils;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

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
			tmp[i] = data[i + offset];

		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(tmp));
		float f = dis.readFloat();
		dis.close();
		return f;
	}

	public static float bytes2float(byte[] data, int offset, int length,
			int ending) throws IOException {

		byte[] tmp = new byte[length];

		for (int i = 0; i < length; i++)
			tmp[i] = data[i + offset];

		ByteBuffer buf = ByteBuffer.allocateDirect(4); // 无额外内存的直接缓存
		if (ending == 1)
			buf = buf.order(ByteOrder.LITTLE_ENDIAN);// 默认大端，小端用这行
		buf.put(tmp);
		buf.rewind();
		float f2 = buf.getFloat();
		return f2;
	}

	public static void main(String[] args) throws IOException {

		byte[] a = new byte[] { (byte) 0xe2, (byte) 0x5e, 0x40, 0x19 }; // e2 5e
		// 40 19

		char[] b = new char[4];

		String nRcvString;

		StringBuffer tStringBuf = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			b[i] = (char) a[i];
		}
		tStringBuf.append(b);
		nRcvString = tStringBuf.toString();

		ByteBuffer buf = ByteBuffer.allocateDirect(4); // 无额外内存的直接缓存
		buf = buf.order(ByteOrder.LITTLE_ENDIAN);// 默认大端，小端用这行
		buf.put(a);
		buf.rewind();
		float f2 = buf.getFloat();
		System.out.println("java ee" + f2);

		System.out.print("the resultis +" + nRcvString + "$$" + a.length);
		// byte[] b = { 0x41, (byte) 0xc8, 0, 0 };
		// byte[] c = { 0x56 ,(byte) 0x41, (byte)0xfc, (byte)0x0f };
		System.out.println(bytes2float(a));

	}
}