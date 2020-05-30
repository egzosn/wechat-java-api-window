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
			bot.getTextMsgEventListener().process(rep, bot);
			break;
		case 3:
			// ͼƬ��Ϣ;
			bot.getImgMsgEventListener().process(rep, bot);
			break;
		case 34:
			// ������Ϣ;
			bot.getVoiceMsgEventListener().process(rep, bot);
			break;
		case 37:
			// ����ȷ����Ϣ;
			bot.getFriendConfirmEventListener().process(rep, bot);
			break;
		case 43:
			// ��Ƶ��Ϣ;
			bot.getVideoMsgEventListener().process(rep, bot);
			break;
		case 47:
			// ��������;
			bot.getAnimationImgEventListener().process(rep, bot);
			break;
		case 48:
			// λ����Ϣ;
			bot.getLocationMsgEventListener().process(rep, bot);
			break;
		case 49:
			// ��������;
			bot.getShareLinkEventListener().process(rep, bot);
			break;
		case 701:
			// Ⱥ��Ա��Ϣ����;
			bot.getGroupMemberInfoUpdateEventListener().process(rep, bot);
			break;
		case 702:
			// Ⱥ��Ա����;
			bot.getGroupMemberIncreaseEventListener().process(rep, bot);
			break;
		case 703:
			// Ⱥ��Ա����;
			bot.getGroupMemberDecreaseEventListener().process(rep, bot);
			break;
		case 704:
			// ��ϵ����Ϣ����;
			bot.getFriendInfoUpdateEventListener().process(rep, bot);
			break;
		case 705:
			// �տ���;
			bot.getReceivePaymentEventListener().process(rep, bot);
			break;
		case 706:
			// ������֤���;
			bot.getFriendAuthEventListener().process(rep, bot);
			break;
		case 707:
			// ����Ⱥ�Ľ��;
			bot.getCreateGroupEventListener().process(rep, bot);
			break;
		case 708:
			// xmlͼƬ��ַ;
			bot.getXMLImgPathEventListener().process(rep, bot);
			break;
		case 720:
			// ��¼��Ϣ-��Ȩ;
			new EventLoginAuth(rep, bot);
			break;
		case 721:
			// ��¼��Ϣ-����;
			//new WechatLoginQR(bot).send();
			while(new WechatLoginQR(bot).send().getStr("msg").equals("get fail"));
			break;
		case 723:
			// ��¼��Ϣ-��¼��ά��仯;
			new EventGetQrCode().result(rep, bot);
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
			bot.getVoiceCallEventListener().process(rep, bot);
			break;
		case 727:
			// �ܾ�����ͨ��;
			bot.getVoiceCallRejectEventListener().process(rep, bot);
			break;
		case 728:
			// ��������ͨ��;
			bot.getVoiceCallAcceptEventListener().process(rep, bot);
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