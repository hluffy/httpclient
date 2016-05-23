package httpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpClient {
	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet("https://www.baidu.com/index.php?tn=98012088_4_dg&ch=10");
		HttpResponse response = httpClient.execute(httpGet);
		System.out.println(response.getProtocolVersion());
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());
		System.out.println(response.getStatusLine().toString());
		HttpEntity entity = response.getEntity();
		System.out.println(entity.getContentLength());
		System.out.println(entity.getContentType());
		if(entity!=null){
			InputStream stream = entity.getContent();
			int i ;
			byte[] tmp = new byte[2048];
			while((i=stream.read(tmp))!=-1){
				System.out.println(stream);
			}
		}
		
		
//		URI uri = URIUtils.createURI("http", "www.google.com", -1, "/index.php", "tn=98012088_4_dg&ch=10", null);
//		HttpGet httpget = new HttpGet(uri);
//		System.out.println(httpget.getURI());
//		
//		List<NameValuePair> list = new ArrayList<NameValuePair>();
//		list.add(new BasicNameValuePair("q","httpclient"));
//		list.add(new BasicNameValuePair("", ""));
	}

}
