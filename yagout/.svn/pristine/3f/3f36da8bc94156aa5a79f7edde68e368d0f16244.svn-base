package com.skeye.yagout.util;

public class EncodeUtil {
	public static String doCharsEncode(String password)
	{   
		char[] chars=password.toCharArray();
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=0;i<chars.length;i++)
        {
        	stringBuilder.append(doCharEncode(chars,i));
        }
		return stringBuilder.toString();
	}
	
	public static char[] doCharEncode(char[] chars,int i)
	{
		int k=0;
		int sum=0;
		int bit=0;
		int[] bits=new int[8];
		int m=chars[i];
    	for(int j=0;j<8;j++)
    	{
    		bits[j]=(m%2);
    		m=m/2;
    	}
    	for(int j=0;j<3;j++)
    	{
    		k=6-j;
    		bit=bits[j];
    		bits[j]=bits[k];
    		bits[k]=bit;
    	}
    	for(int j=0;j<8;j++)
    	{
    		sum=(int) (sum+bits[j]*Math.pow(2, j));
    	}
    	return Character.toChars(sum);
	}
}
