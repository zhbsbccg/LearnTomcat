package zhb.server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpServer {
	//webrootĿ¼
	public static final String WEB_ROOT=System.getProperty("user.dir")+File.separator+"webroot";
	//�ر��ַ���
	private static final String SHUTDOWN_COMMAND="/SHUTDOWN";
	//�Ƿ�رձ�ʶ
	private boolean shutdown=false;
	public static void main(String[] args){
		HttpServer server=new HttpServer();
		server.await();
	}
	/**
	 * �ȴ�����������
	 */
	public void await(){
		ServerSocket serverSocket=null;
		int port=8080;
		try {
			serverSocket=new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!shutdown){
			Socket socket=null;
			OutputStream outputStream=null;
			InputStream inputStream=null;
			try {
				socket=serverSocket.accept();
				outputStream=socket.getOutputStream();
				inputStream=socket.getInputStream();
				//����inputStream
				Request request=new Request(inputStream);
				request.parse();
				//����outStream
				Response response=new Response(outputStream, request);
				response.sendStaticResource();
				//�Ƿ�ر�����
				shutdown=request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}finally{
				try {
					//�رյ�ǰ����
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
