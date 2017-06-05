package com.sist.r;

import org.rosuda.REngine.Rserve.RConnection;

public class RManager {
	
	
	public void rGraph() {
		try {
			RConnection rc=new RConnection(); //Rserve를 연결할때 쓰는 객체
			rc.voidEval("data<-read.table(\"c:/review_data/daum_feel.txt\")");
			rc.voidEval("png(\"c:/review_data/daum_feel.png\")");
			rc.voidEval("pie(data$V2, labels=data$V1, col=rainbow(8))");
			rc.voidEval("dev.off()");
			rc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			
		}
	}
	
	/*public static void main(String[] args) {
		
		
		RManager rm=new RManager();
		rm.rGraph();
	}*/
}
