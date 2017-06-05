package com.sist.feel;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.propertyeditors.PatternEditor;
public class MovieFeelClass {//mapreduce¿Í spark°¡ ÀÌ ¿ªÇÒÀ» ÇÑ´Ù.
	
	//¸ÀÀÖ´Â, ¸ÀÀÖ°Ô , ¸ÀÀÖ°í......  ¸ÀÀÖ[°¡-ÆR]+ (Á¤±Ô½Ä) +´Â ÇÑ±ÛÀÚ ÀÌ»ó      ? :0 or 1      *:0~1~
	//´ÙÀ½Àº µ¥ÀÌÅÍ »çÀüÀÌ´Ù.
	String[] feel = {"»ç¶û","·Î¸Ç½º","¸Å·Â","Áñ°Å¿ò","½º¸±",
			"¼Ò¸§","±äÀå","°øÆ÷","À¯¸Ó","¿ôÀ½","°³±×",
			"Çàº¹","ÀüÀ²","°æÀÌ","¿ì¿ï","Àı¸Á","½Åºñ",
			"¿©¿î","Èñ¸Á","±ä¹Ú","°¨µ¿","°¨¼º","ÈŞ¸Ó´ÏÁò",
			"ÀÚ±Ø","Àç¹Ì","¾×¼Ç","¹İÀü","ºñ±Ø","¹Ì½ºÅ×¸®",
			"ÆÇÅ¸Áö","²Ş","¼³·¹ÀÓ","Èï¹Ì","Ç³°æ","ÀÏ»ó",
			"¼ø¼ö","Èú¸µ","´«¹°","±×¸®¿ò","È£·¯","Ãæ°İ","ÀÜÈ¤",	
			"µå¶ó¸¶", "¸á·Î","¾ÖÁ¤",
			"¸ğÇè","´À¿Í¸£","´ÙÅ¥¸àÅÍ¸®",
			"ÄÚ¹Ìµğ","¹üÁË","SF", "¾Ö´Ï¸ŞÀÌ¼Ç"	
	};
	
	public void movieFeelData(String type) {//daum°ú naver¿¡¼­ ´Ù ¾µ°ÍÀÌ´Ù.
		Pattern[] p=new Pattern[feel.length];
		for (int i = 0; i < p.length; i++) {
			p[i]=Pattern.compile(feel[i]);
		}
		
		int[] count=new int[feel.length];//ÃÊ±âÈ­
		
		try {
			//ÆÄÀÏ ÇÑÁÙ ÀĞÀ»¶§¸¶´Ù °Ë»ç
			FileReader fr=new FileReader("c:\\review_data\\"+type+".txt");//ÇÑ¹ø ¾²°í ¹ö¸±°ÍÀÌ¹Ç·Î ÆÄÀÏÀ» ÀÌ¿ëÇÑ´Ù.
			int i=0;
			String data="";
			while ((i=fr.read())!=-1) {
				data+=String.valueOf((char)i);
			}
			fr.close();
			String[] feelArray=data.split("\n");
			Matcher[] m=new Matcher[feel.length]; //Æ÷ÇÔµÇ¾ú´Â È®ÀÎÇØÁÖ´Â Å¬·¡½º
			for (String s : feelArray) {//s´Â ÇÑÁÙ¾¿ ÀĞÀº °ª
				for (i = 0; i < m.length; i++) {
					m[i]=p[i].matcher(s);
					if (m[i].find()) {
						count[i]++;
					}
				}
			}
			
			String feel_data="";
			for (i = 0;  i< feel.length; i++) {
				if(count[i]>0){
				//System.out.println(feel[i]+":"+count[i]);
					feel_data+=feel[i]+" "+count[i]+"\n";				
				}
			}
			
			FileWriter fw=new FileWriter("c:\\review_data\\"+type+"_feel.txt");
			fw.write(feel_data);
			fw.close();
		} catch (Exception e) {
			System.out.println("movieFeelData()"+e.getMessage());
		}
	}
	
	/*public static void main(String[] args) {
		MovieFeelClass mf=new MovieFeelClass();
		mf.movieFeelData();
	}*/
}
