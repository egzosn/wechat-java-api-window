package Lin.Wechat.MainEntry;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;
import Lin.Wechat.MainEntry.Handler.WXMsgHandler;

public class StartPoint {

	public static void main(String[] arg) throws Exception {
		// ������������������eС�������
		HttpServer server = HttpServer.create(new InetSocketAddress(GlobalConfig.receivePort), 0);
		// ����WXMsgHandlerΪ������Ϣ�Ĵ�����
		server.createContext("/", new WXMsgHandler());
		// ����������
		server.start();
	}
}
