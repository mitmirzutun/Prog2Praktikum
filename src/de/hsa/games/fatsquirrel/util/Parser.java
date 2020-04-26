package de.hsa.games.fatsquirrel.util;

import java.io.OutputStream;

public class Parser {
	public static void main(String[] args) throws Exception {
		System.out.println(ParseFloat("-150.01"));
	}
	public static long ParseInt(String s) throws Exception{
		int sign = s.charAt(0)=='+'?1:(s.charAt(0)=='-'?-1:1);
		long value = 0;
		for (int i=(s.charAt(0)=='-'||s.charAt(0)=='+')?1:0;i<s.length();i++) {
			if (s.charAt(i)<'0'||s.charAt(i)>'9')
				throw new Exception("Invalid value: "+s.charAt(i));
			long auxValue=s.charAt(i)-'0';
			if ((Long.MAX_VALUE-auxValue)/10<value)
				throw new Exception("Input too big");
			if ((Long.MIN_VALUE+auxValue)/10>value)
				throw new Exception("Input too small");
			value=value*10+sign*(long)(s.charAt(i)-'0');
		}
		return value;
	}
	public static double ParseFloat(String s) throws Exception {
		int sign = s.charAt(0)=='+'?1:(s.charAt(0)=='-'?-1:1);
		double value = 0;
		int i;
		for (i=(s.charAt(0)=='-'||s.charAt(0)=='+')?1:0;i<s.length();i++) {
			if (s.charAt(i)=='.'||s.charAt(i)==',')
				break;
			if (s.charAt(i)<'0'||s.charAt(i)>'9')
				throw new Exception("Invalid value: "+s.charAt(i));
			long auxValue=s.charAt(i)-'0';
			if ((Double.MAX_VALUE-auxValue)/10<value)
				throw new Exception("Input too big");
			if ((-Double.MAX_VALUE+auxValue)/10>value)
				throw new Exception("Input too small");
			value=value*10+sign*(long)(s.charAt(i)-'0');
		}
		int digitsAfterDecimalPoint;
		for (digitsAfterDecimalPoint=1;i+digitsAfterDecimalPoint<s.length();digitsAfterDecimalPoint++)
		{
			if (s.charAt(i+digitsAfterDecimalPoint)<'0'||s.charAt(i+digitsAfterDecimalPoint)>'9')
				throw new Exception("Invalid value: "+s.charAt(i+digitsAfterDecimalPoint));
			long auxValue=s.charAt(i+digitsAfterDecimalPoint)-'0';
			if ((Double.MAX_VALUE-auxValue)/10<value)
				throw new Exception("Input too big");
			if ((Double.MIN_VALUE+auxValue)/10>value)
				throw new Exception("Input too small");
			value=value*10+sign*(long)(s.charAt(i+digitsAfterDecimalPoint)-'0');
		}
		return value/Math.pow(10, digitsAfterDecimalPoint-1);
	}
}