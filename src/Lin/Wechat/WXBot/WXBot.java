package Lin.Wechat.WXBot;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

import Lin.Wechat.Handler.WXMsgHandler;
import Lin.Wechat.Handler.Event.Interface.EventListener;
import Lin.Wechat.Handler.Event.Login.EventGetQrCode;
import Lin.Wechat.Sender.XTMAC;
import Lin.Wechat.Sender.Command.WechatLoginQR;
import Lin.Wechat.Sender.Command.WechatOpener;
import cn.hutool.json.JSONObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WXBot {
	//С��Token
	String token;
	// �ı���Ϣ
	EventListener textMsgEventListener;
	// ͼƬ��Ϣ
	EventListener imgMsgEventListener;
	// ������Ϣ
	EventListener voiceMsgEventListener;
	// ����ȷ����Ϣ
	EventListener friendConfirmEventListener;
	// ��Ƶ��Ϣ
	EventListener videoMsgEventListener;
	// ��������
	EventListener animationImgEventListener;
	// λ����Ϣ
	EventListener locationMsgEventListener;
	// ��������
	EventListener shareLinkEventListener;
	// Ⱥ��Ա��Ϣ����
	EventListener groupMemberInfoUpdateEventListener;
	// Ⱥ��Ա����
	EventListener groupMemberIncreaseEventListener;
	// Ⱥ��Ա����
	EventListener groupMemberDecreaseEventListener;
	// ��ϵ����Ϣ����
	EventListener friendInfoUpdateEventListener;
	// �տ���
	EventListener receivePaymentEventListener;
	// ������֤���
	EventListener friendAuthEventListener;
	// ����Ⱥ�Ľ��
	EventListener createGroupEventListener;
	// xmlͼƬ��ַ
	EventListener XMLImgPathEventListener;
	// ��¼��Ϣ-��Ȩ
	// ��¼��Ϣ-����
	// ��¼��Ϣ-��¼��ά��仯
	// ��¼��Ϣ-΢�ŵ�¼
	// ��¼��Ϣ-΢���˳�
	// ��������ͨ��
	EventListener voiceCallEventListener;
	// �ܾ�����ͨ��
	EventListener voiceCallRejectEventListener;
	// ��������ͨ��
	EventListener voiceCallAcceptEventListener;
	// ������ӶϿ�
	// ΢�����ӶϿ�
	// ϵͳ��ʾ���ȷ��
	// ϵͳ��Ϣ
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
		JSONObject wxOpenResult = new WechatOpener(this).send(true);
		// ����Ѿ����� ��ȡ��½QR code
		if (wxOpenResult.getInt("pid") == 0) {
			int pid = Integer.parseInt(wxOpenResult.getStr("msg").replace("΢��[", "").replace("]�Ѿ����й���", ""));
			info.setPid(pid);
			while(new WechatLoginQR(this).send().getStr("msg").equals("get fail"));
		} else {
			info.setPid(wxOpenResult.getInt("pid"));
		}
		String data = new XTMAC(this).send().getStr("data");
		this.info.setMac(data);
		return this;
	}
}
