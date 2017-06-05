package com.sist.feel;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.propertyeditors.PatternEditor;
public class MovieFeelClass {//mapreduce�� spark�� �� ������ �Ѵ�.
	
	//���ִ�, ���ְ� , ���ְ�......  ����[��-�R]+ (���Խ�) +�� �ѱ��� �̻�      ? :0 or 1      *:0~1~
	//������ ������ �����̴�.
	String[] feel = {"���","�θǽ�","�ŷ�","��ſ�","����",
			"�Ҹ�","����","����","����","����","����",
			"�ູ","����","����","���","����","�ź�",
			"����","���","���","����","����","�޸Ӵ���",
			"�ڱ�","���","�׼�","����","���","�̽��׸�",
			"��Ÿ��","��","������","���","ǳ��","�ϻ�",
			"����","����","����","�׸���","ȣ��","���","��Ȥ",	
			"���", "���","����",
			"����","���͸�","��ť���͸�",
			"�ڹ̵�","����","SF", "�ִϸ��̼�"	
	};
	
	public void movieFeelData(String type) {//daum�� naver���� �� �����̴�.
		Pattern[] p=new Pattern[feel.length];
		for (int i = 0; i < p.length; i++) {
			p[i]=Pattern.compile(feel[i]);
		}
		
		int[] count=new int[feel.length];//�ʱ�ȭ
		
		try {
			//���� ���� ���������� �˻�
			FileReader fr=new FileReader("c:\\review_data\\"+type+".txt");//�ѹ� ���� �������̹Ƿ� ������ �̿��Ѵ�.
			int i=0;
			String data="";
			while ((i=fr.read())!=-1) {
				data+=String.valueOf((char)i);
			}
			fr.close();
			String[] feelArray=data.split("\n");
			Matcher[] m=new Matcher[feel.length]; //���ԵǾ��� Ȯ�����ִ� Ŭ����
			for (String s : feelArray) {//s�� ���پ� ���� ��
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
