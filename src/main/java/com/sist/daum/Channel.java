package com.sist.daum;
// item => 20 => List
import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/*
 *   ����  ==> �迭  ==> Ŭ����  ===> ����  ==> ����Ŭ  ==> XML,JSON
 *                                    =====
 *   ������ (JSON)
 *   
 *   XML => <a>aaaa</a>  <a href="aaa">
 *   
 *   <item>
		<title>�Ϻ� ��ü ��������, �ѱ��� ���š� ������� �ϰݡ�</title>
		<link>
		http://sports.hankooki.com/lpage/mlb/201706/sp2017060514250095810.htm
		</link>
		<description>
		<![CDATA[
		�Ϻ� �߱����� ��ü Ǯī��Ʈ�� �������ٰ� 1ȸ ����Ÿ�� ���� �Ұ��带 �������� ��Ƴ��� ���� ����� �˷����� ������� ���� Ŀ�갡 �߾� �������� �Ѿ �������� ����١��� ���� �߰� ���� ���� �� �̳�...
		]]>
		</description>
		<pubDate>Mon, 05 Jun 2017 14:31:00 +0900</pubDate>
		<author>�������ѱ�</author>
		<category>������</category>
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
