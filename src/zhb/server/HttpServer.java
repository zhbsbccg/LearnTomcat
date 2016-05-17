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
	//webroot目录
	public static final String WEB_ROOT=System.getProperty("user.dir")+File.separator+"webroot";
	//关闭字符串
	private static final String SHUTDOWN_COMMAND="/SHUTDOWN";
	//是否关闭标识
	private boolean shutdown=false;
	public static void main(String[] args){
		HttpServer server=new HttpServer();
		server.await();
	}
	/**
	 * 等待链接主程序
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
				//处理inputStream
				Request request=new Request(inputStream);
				request.parse();
				//处理outStream
				Response response=new Response(outputStream, request);
				response.sendStaticResource();
				//是否关闭请求
				shutdown=request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}finally{
				try {
					//关闭当前请求
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
