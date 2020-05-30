package Lin.Wechat.WXBot;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

import Lin.Wechat.Handler.WXMsgHandler;
import Lin.Wechat.Sender.Command.WechatLoginQR;
import Lin.Wechat.Sender.Command.WechatOpener;
import cn.hutool.json.JSONObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WXBot {
	BotInfo info = new BotInfo();

	public WXBot(int port) {
		info.setPort(port);
	}

	public WXBot run() throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(info.getPort()), 0);
		// ����WXMsgHandlerΪ������Ϣ�Ĵ�����
		server.createContext("/", new WXMsgHandler(this));
		// ����������
		server.start();
		JSONObject wxOpenResult = new WechatOpener(this).send(false);
		// ����Ѿ����� ��ȡ��½QR code
		System.out.println(wxOpenResult.toString());
		if (wxOpenResult.getInt("pid") == 0) {
			int pid = Integer.parseInt(
					wxOpenResult.getStr("msg")
					.replace("΢��[", "")
					.replace("]�Ѿ����й���", "")
				);
			info.setPid(pid);
			new WechatLoginQR(this).send();
		} else {
			info.setPid(wxOpenResult.getInt("pid"));
		}
		System.out.println(info.getPid());
		return this;
	}
}
