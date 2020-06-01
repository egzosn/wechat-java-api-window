package Lin.Wechat.Handler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.vdurmont.emoji.EmojiParser;

import Lin.Wechat.Handler.Event.Interface.Event;
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
		String response = EmojiParser
				.parseToAliases(IOUtils.toString(new InputStreamReader(exchange.getRequestBody(), "UTF-8")));
		//System.out.println(alias);
		// ��ӡ���ջ�����json
		//System.out.println(response);
		JSONObject rep = new JSONObject(response);
		if (bot.getInfo().getPid() != rep.getInt("pid")) {
			// System.out.println("PID incorrect");
			return;
		}
		Event event = new Event(rep, bot);
		switch (rep.getInt("type")) {
		case 1:
			// �ı���Ϣ;
			bot.getMsgHandler().onTextMessage(event);
			break;
		case 3:
			// ͼƬ��Ϣ;
			bot.getMsgHandler().onImgMessage(event);
			break;
		case 34:
			// ������Ϣ;
			bot.getMsgHandler().onVoiceMessage(event);
			break;
		case 37:
			// ����ȷ����Ϣ;
			bot.getMsgHandler().onFriendMessage(event);
			break;
		case 43:
			// ��Ƶ��Ϣ;
			bot.getMsgHandler().onVideoMessage(event);
			break;
		case 47:
			// ��������;
			bot.getMsgHandler().onEmotionMessage(event);
			break;
		case 48:
			// λ����Ϣ;
			bot.getMsgHandler().onLocationMessage(event);
			break;
		case 49:
			// ��������;
			bot.getMsgHandler().onLinkShareMessage(event);
			break;
		case 701:
			// Ⱥ��Ա��Ϣ����;
			bot.getMsgHandler().onGroupMemberInfoUpdateMessage(event);
			break;
		case 702:
			// Ⱥ��Ա����;
			bot.getMsgHandler().onGroupMemberIncreaseMessage(event);
			break;
		case 703:
			// Ⱥ��Ա����;
			bot.getMsgHandler().onGroupMemberDecreaseMessage(event);
			break;
		case 704:
			// ��ϵ����Ϣ����;
			bot.getMsgHandler().onFriendInfoUpdateMessage(event);
			break;
		case 705:
			// �տ���;
			bot.getMsgHandler().onReceivePaymentMessage(event);
			break;
		case 706:
			// ������֤���;
			bot.getMsgHandler().onFriendAuthMessage(event);
			break;
		case 707:
			// ����Ⱥ�Ľ��;
			bot.getMsgHandler().onCreateGroupMessage(event);
			break;
		case 708:
			// xmlͼƬ��ַ;
			bot.getMsgHandler().onXMLImgPathMessage(event);
			break;
		case 720:
			// ��¼��Ϣ-��Ȩ;
			new EventLoginAuth(rep, bot);
			break;
		case 721:
			// ��¼��Ϣ-����;
			String qrRequestResult;
			do {
				qrRequestResult = new WechatLoginQR(bot).send().getStr("msg");
				// System.out.println("MSG " + str);
			} while (qrRequestResult.equals("get fail") || qrRequestResult.equals("InitWaiting"));
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
			// System.exit(0);
			break;
		case 726:
			// ��������ͨ��;
			bot.getMsgHandler().onVoiceCallMessage(event);
			break;
		case 727:
			// �ܾ�����ͨ��;
			bot.getMsgHandler().onVoiceCallRejectMessage(event);
			break;
		case 728:
			// ��������ͨ��;
			bot.getMsgHandler().onVoiceCallAcceptMessage(event);
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
			bot.getMsgHandler().onSystemMessage(event);
			break;
		}
	}
}