package com.sist.container;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.daum.DaumManager;
import com.sist.feel.MovieFeelClass;
import com.sist.r.RManager;

public class MainClass {
    private DaumManager dm;
    private MovieFeelClass mfc;
    private RManager rm;
    
	public void setDm(DaumManager dm) {
		this.dm = dm;
	}
	
	public void setMfc(MovieFeelClass mfc) {
		this.mfc = mfc;
	}
	
	public void setRm(RManager rm) {
		this.rm = rm;
	}

	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=app.getBean("mc", MainClass.class);
		Scanner scan=new Scanner(System.in);
		System.out.println("MovieName:");
		String title=scan.next();
		mc.dm.daumReviewSave(title);//수집
		System.out.println("save end///");
		
		mc.mfc.movieFeelData("daum");//감성데이터
		System.out.println("Feel Save End...");
		
		mc.rm.rGraph();
		System.out.println("");
		
		
	}

}
