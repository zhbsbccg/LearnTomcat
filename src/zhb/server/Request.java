package zhb.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
/**
 * ������������
 * @author Administrator
 *
 */
public class Request {
	private InputStream inputStream;
	private String uri;
	private Request(){	}
	public Request(InputStream inputStream){
		this.inputStream=inputStream;
	}
	
	public String getUri() {
		return uri;
	}
	/**
	 * ����inputStream����
	 */
	public void parse(){
		try {
			uri=parseUrl(IOUtils.toString(inputStream,"utf-8"));
			System.out.println(uri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ���������ַ���ת��uri
	 * @param requestString
	 * @return
	 */
	private String parseUrl(String requestString){
		String result="";
		
		return result;
	}
}
