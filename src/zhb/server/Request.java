package zhb.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
/**
 * 处理请求数据
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
	 * 解析inputStream请求
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
	 * 根据请求字符串转换uri
	 * @param requestString
	 * @return
	 */
	private String parseUrl(String requestString){
		String result="";
		
		return result;
	}
}
