package httpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientGetHtml {
	
	public static void download() throws ClientProtocolException, IOException{
		//通过httpget获得response对象
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://www.bilibili.com/");
		HttpResponse response = httpclient.execute(httpget);
		
		InputStream input = null;
		Scanner sc = null;
		Writer wo = null;
		
		if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
			try {
				//获取response的entity
				HttpEntity entity = response.getEntity();
				
				//获取inputsteam对象并对内容进行处理
				input = entity.getContent();
				sc = new Scanner(input);
				String fileName = "2.txt";
				wo = new PrintWriter(fileName);
				while(sc.hasNext()){
					wo.write(sc.nextLine());
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally{
				if(sc!=null){
					sc.close();
				}
				if(input!=null){
					input.close();
				}
				if(wo!=null){
					wo.close();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			download();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
