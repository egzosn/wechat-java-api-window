package Lin.Wechat.MainEntry.Handler;

import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.io.IOUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import Lin.Wechat.MainEntry.Sender.Sender;

public class WXMsgHandler implements HttpHandler {
	public void handle(HttpExchange exchange) throws IOException {
		// ��������eС�������
		String response = IOUtils.toString(new InputStreamReader(exchange.getRequestBody(), "UTF-8"));
		
		// ��ӡ���ջ�����json
		System.out.println(response);
		
		//������Ϣ�� ����hi��filehelper���WXID
		String send = new Sender().sendMsg("filehelper", "Hi", "");
		
		//�鿴�ش����
		System.out.println(send);
		
		/*
		 * ���´����������з���
		 */
	}
}