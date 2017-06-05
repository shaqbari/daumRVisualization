package com.sist.daum;
/*
 *    영화 ==> 블러그 검색 (XML,JSON)
 *    ========================= JAXP(DOM,SAX)
 *                              JAXB(O)
 *                              XML => class (언마셜)
 *                              class => XML (마셜)
 *    <channel>
 *      <item>
 *        <description>영화댓글</description>
 *      </item>
 *      <item>
 *        <description>영화댓글...</description>
 *      </item>
 *    </channel>
 *    
 *    ==> 
 *    http://newssearch.naver.com/search.naver?where=rss&query=%EC%95%BC%EA%B5%AC
 */
/*
 *   String[] feel = {"사랑","로맨스","매력","즐거움","스릴",
				"소름","긴장","공포","유머","웃음","개그",
				"행복","전율","경이","우울","절망","신비",
				"여운","희망","긴박","감동","감성","휴머니즘",
				"자극","재미","액션","반전","비극","미스테리",
				"판타지","꿈","설레임","흥미","풍경","일상",
				"순수","힐링","눈물","그리움","호러","충격","잔혹"};
	String[] genre = {
				"드라마","판타지","공포","멜로","애정",
				"로맨스","모험","스릴러","느와르","다큐멘터리",
				"코미디","미스터리","범죄","SF","액션","애니메이션"	
	};
 */
import java.io.*;
import java.net.*;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
public class DaumManager {
    private String key;
   
    public void setKey(String key) {
	this.key = key;
	}
	public void daumReviewSave(String title)
    {
	   String total="";
	   for(int i=1;i<=3;i++)
	   {
		   String review=daumReviewData(i, title);
		   total+=review;
	   }
	   try
	   {
		   FileWriter fw=
				   new FileWriter("c:\\review_data\\daum.txt");
		   fw.write(total);
		   fw.close();
	   }catch(Exception ex){}
   }
   public String daumReviewData(int page,String title)
   {
	   String review="";
	   try
	   {
		   
		   URL url=new URL("https://apis.daum.net/search/blog?apikey="
				   +key+"&result=20&output=xml&pageno="+page+"&q="
				   +URLEncoder.encode(title, "UTF-8"));
		   JAXBContext jc=JAXBContext.newInstance(Channel.class);
		   // xml=>class  , class=>xml
		   Unmarshaller un=jc.createUnmarshaller();
		   Channel channel=(Channel)un.unmarshal(url);
		   List<Item> temp=channel.getItem();
		   for(Item i:temp)
		   {
			   review+=i.getDescription()+"\n";
		   }
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   return review;
   }
   
   /*public static void main(String[] args) {
		DaumManager dm=new DaumManager();
		dm.daumReviewSave("원더우먼");
	}*/
   
}







