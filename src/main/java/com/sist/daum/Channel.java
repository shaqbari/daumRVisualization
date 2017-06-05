package com.sist.daum;
// item => 20 => List
import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/*
 *   변수  ==> 배열  ==> 클래스  ===> 파일  ==> 오라클  ==> XML,JSON
 *                                    =====
 *   몽고디비 (JSON)
 *   
 *   XML => <a>aaaa</a>  <a href="aaa">
 *   
 *   <item>
		<title>일본 매체 “마에다, 한국의 ‘신’ 테임즈에게 일격”</title>
		<link>
		http://sports.hankooki.com/lpage/mlb/201706/sp2017060514250095810.htm
		</link>
		<description>
		<![CDATA[
		일본 야구전문 매체 풀카운트는 “마에다가 1회 선두타자 에릭 소가드를 삼진으로 잡아내며 좋은 출발을 알렸지만 테임즈에게 던진 커브가 중앙 담장으로 넘어가 선취점을 내줬다”며 이후 추가 실점 과정 및 이날...
		]]>
		</description>
		<pubDate>Mon, 05 Jun 2017 14:31:00 +0900</pubDate>
		<author>스포츠한국</author>
		<category>스포츠</category>
		<media:thumbnail url="http://imgnews.naver.net/image/thumb140/5359/2017/06/05/188725.jpg"/>
</item>
        @XmlElement(name="media:thumbnail")
        String media_thumbnail
 */
@XmlRootElement
public class Channel {
    private List<Item> item=new ArrayList<Item>();
    
	public List<Item> getItem() {
		return item;
	}
	@XmlElement
	public void setItem(List<Item> item) {
		this.item = item;
	}
   
}
