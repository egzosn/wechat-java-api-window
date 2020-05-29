package Lin.Wechat.Handler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import Lin.Wechat.Handler.Event.Login.EventGetQrCode;
import Lin.Wechat.Handler.Event.Login.EventLogin;
import Lin.Wechat.Handler.Event.Login.EventLoginAuth;
import Lin.Wechat.Sender.Command.WechatLoginQR;
import Lin.Wechat.WXBot.WXBot;
import cn.hutool.json.JSONObject;

public class WXMsgHandler implements HttpHandler {
	WXBot bot;

	public WXMsgHandler(WXBot bot) {
		this.bot = bot;
	}

	public void handle(HttpExchange exchange) throws UnsupportedEncodingException, IOException {
		// ��������eС�������
		String response = IOUtils.toString(new InputStreamReader(exchange.getRequestBody(), "UTF-8"));
		// ��ӡ���ջ�����json
		//System.out.println(response);
		JSONObject rep = new JSONObject(response);
		switch (rep.getInt("type")) {
		case 1:
			// �ı���Ϣ;
			bot.getInfo().getTextMsgEventListener().process(rep, bot);
			break;
		case 3:
			// ͼƬ��Ϣ;
			bot.getInfo().getImgMsgEventListener().process(rep, bot);
			break;
		case 34:
			// ������Ϣ;
			break;
		case 37:
			// ����ȷ����Ϣ;
			break;
		case 43:
			// ��Ƶ��Ϣ;
			break;
		case 47:
			// ��������;
			break;
		case 48:
			// λ����Ϣ;
			break;
		case 49:
			// ��������;
			break;
		case 701:
			// Ⱥ��Ա��Ϣ����;
			break;
		case 702:
			// Ⱥ��Ա����;
			break;
		case 703:
			// Ⱥ��Ա����;
			break;
		case 704:
			// ��ϵ����Ϣ����;
			break;
		case 705:
			// �տ���;
			break;
		case 706:
			// ������֤���;
			break;
		case 707:
			// ����Ⱥ�Ľ��;
			break;
		case 708:
			// xmlͼƬ��ַ;
			break;
		case 720:
			// ��¼��Ϣ-��Ȩ;
			new EventLoginAuth(rep, bot);
			break;
		case 721:
			// ��¼��Ϣ-����;
			new EventGetQrCode(new WechatLoginQR(bot).send(), bot);
			break;
		case 723:
			// ��¼��Ϣ-��¼��ά��仯;
			new EventGetQrCode(rep, bot);
			break;
		case 724:
			// ��¼��Ϣ-΢�ŵ�¼;
			new EventLogin(rep, bot);
			break;
		case 725:
			// ��¼��Ϣ-΢���˳�;
			System.exit(0);
			break;
		case 726:
			// ��������ͨ��;
			break;
		case 727:
			// �ܾ�����ͨ��;
			break;
		case 728:
			// ��������ͨ��;
			break;
		case 802:
			// ������ӶϿ�;
			break;
		case 803:
			// ΢�����ӶϿ�;
			break;
		case 810:
			// ϵͳ��ʾ���ȷ��;
			break;
		case 10000:
			// ϵͳ��Ϣ;
			break;
		}
	}
}