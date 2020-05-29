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
	TextMsgEventListener textMsgEventListener;
//	ͼƬ��Ϣ
	ImgMsgEventListener imgMsgEventListener;
//	������Ϣ
//	����ȷ����Ϣ
//	��Ƶ��Ϣ
//	��������
//	λ����Ϣ
//	��������
//	Ⱥ��Ա��Ϣ����
//	Ⱥ��Ա����
//	Ⱥ��Ա����
//	��ϵ����Ϣ����
//	�տ���
//	������֤���
//	����Ⱥ�Ľ��
//	xmlͼƬ��ַ
//	��¼��Ϣ-��Ȩ
//	��¼��Ϣ-����
//	��¼��Ϣ-��¼��ά��仯
//	��¼��Ϣ-΢�ŵ�¼
//	��¼��Ϣ-΢���˳�
//	��������ͨ��
//	�ܾ�����ͨ��
//	��������ͨ��
//	������ӶϿ�
//	΢�����ӶϿ�
//	ϵͳ��ʾ���ȷ��
//	ϵͳ��Ϣ


}
