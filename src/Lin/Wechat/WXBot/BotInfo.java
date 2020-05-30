package Lin.Wechat.WXBot;

import java.util.Date;

import javax.swing.JFrame;

import Lin.Wechat.Handler.Event.Interface.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BotInfo {
	int port;
	String apiHttp = "http://127.0.0.1:8203/api?json";
	Date authDate, expireDate;
	JFrame jf;
	String nickName, wxid;
	String QRPath = "C:\\QRGenerate\\";
	int pid;
//	�ı���Ϣ
	EventListener textMsgEventListener;
//	ͼƬ��Ϣ
	EventListener imgMsgEventListener;
//	������Ϣ
	EventListener voiceMsgEventListener;
//	����ȷ����Ϣ
	EventListener friendConfirmEventListener;
//	��Ƶ��Ϣ
	EventListener videoMsgEventListener;
//	��������
	EventListener animationImgEventListener;
//	λ����Ϣ
	EventListener locationMsgEventListener;
//	��������
	EventListener shareLinkEventListener;
//	Ⱥ��Ա��Ϣ����
	EventListener groupMemberInfoUpdateEventListener;
//	Ⱥ��Ա����
	EventListener groupMemberIncreaseEventListener;
//	Ⱥ��Ա����
	EventListener groupMemberDecreaseEventListener;
//	��ϵ����Ϣ����
	EventListener friendInfoUpdateEventListener;
//	�տ���
	EventListener receivePaymentEventListener;
//	������֤���
	EventListener friendAuthEventListener;
//	����Ⱥ�Ľ��
	EventListener createGroupEventListener;
//	xmlͼƬ��ַ
	EventListener XMLImgPathEventListener;
//	��¼��Ϣ-��Ȩ
//	��¼��Ϣ-����
//	��¼��Ϣ-��¼��ά��仯
//	��¼��Ϣ-΢�ŵ�¼
//	��¼��Ϣ-΢���˳�
//	��������ͨ��
	EventListener voiceCallEventListener;
//	�ܾ�����ͨ��
	EventListener voiceCallRejectEventListener;
//	��������ͨ��
	EventListener voiceCallAcceptEventListener;
//	������ӶϿ�
//	΢�����ӶϿ�
//	ϵͳ��ʾ���ȷ��
//	ϵͳ��Ϣ


}
