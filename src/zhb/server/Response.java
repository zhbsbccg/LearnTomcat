package zhb.server;

import java.io.OutputStream;
/**
 * ����������
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
	  * ���������;�̬ҳ��
	  */
	 public void sendStaticResource(){
		 
	 }
}

