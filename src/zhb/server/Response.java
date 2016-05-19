package zhb.server;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
/**
 * 处理反馈数据
 * @author Administrator
 *
 */
public class Response {
	 private final int BUFFER_SIZE=1024;
	 private OutputStream outputStream;
	 private Request request;
	 private Response(){}
	 public Response(OutputStream outputStream,Request request){
		 this.outputStream=outputStream;
		 this.request=request;
	 }
	 /**
	  * 根据请求发送静态页面
	  */
	 public void sendStaticResource(){
		File file=FileUtils.getFile(HttpServer.WEB_ROOT, request.getUri());
		try {
			if(file.exists()){
				byte[] bytes=FileUtils.readFileToByteArray(file);
				IOUtils.write(bytes, outputStream);
			}else{
				StringBuffer wrongBuffer=new StringBuffer();
				wrongBuffer.append("HTTP/1.1 404 File Not Found\r\n")
				.append("Content-Type: text/html\r\n")
				.append("Content-Length: 23\r\n")
				.append("\r\n")
				.append("<h1>File Not Found</h1>");
				//IOUtils.write(wrongBuffer.toString(), outputStream);
				//IOUtils.write(wrongBuffer, outputStream, "utf-8");
				IOUtils.write(wrongBuffer.toString(), outputStream, "utf-8");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}

