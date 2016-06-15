package com.yz.utils;

public class AsciiByte2String {

	private static byte[] a = new byte[] { 0x37, 0x30, 0x2E, 0x37 };

	private static char[] b = new char[4];

	private static String nRcvString;

	public static void main() {
		StringBuffer tStringBuf = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			b[i] = (char) a[i];
		}
		tStringBuf.append(b);
		nRcvString = tStringBuf.toString();
		
		System.out.print("the resultis +"+nRcvString);
	}

}
