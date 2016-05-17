package zhb.server;

import java.io.OutputStream;
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
		 
	 }
}

