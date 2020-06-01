package Lin.Wechat.Handler.Event.Interface;

public interface EventHandler {
	// �ı���Ϣ 1
	public void onTextMessage(Event event);

	// ͼƬ��Ϣ 3
	public void onImgMessage(Event event);

	// ������Ϣ 34
	public void onVoiceMessage(Event event);

	// ����ȷ����Ϣ 37
	public void onFriendMessage(Event event);

	// ��Ƶ��Ϣ 43
	public void onVideoMessage(Event event);

	// �������� 47
	public void onEmotionMessage(Event event);

	// λ����Ϣ 48
	public void onLocationMessage(Event event);

	// �������� 49
	public void onLinkShareMessage(Event event);

	// Ⱥ��Ա��Ϣ���� 701
	public void onGroupMemberInfoUpdateMessage(Event event);

	// Ⱥ��Ա���� 702
	public void onGroupMemberIncreaseMessage(Event event);

	// Ⱥ��Ա���� 703
	public void onGroupMemberDecreaseMessage(Event event);

	// ��ϵ����Ϣ���� 704
	public void onFriendInfoUpdateMessage(Event event);

	// �տ��� 705
	public void onReceivePaymentMessage(Event event);

	// ������֤��� 706
	public void onFriendAuthMessage(Event event);

	// ����Ⱥ�Ľ�� 707
	public void onCreateGroupMessage(Event event);

	// xmlͼƬ��ַ 708
	public void onXMLImgPathMessage(Event event);

	// ��¼��Ϣ-��Ȩ 720
	// ��¼��Ϣ-���� 721
	// ��¼��Ϣ-��¼��ά��仯 723
	// ��¼��Ϣ-΢�ŵ�¼ 724
	// ��¼��Ϣ-΢���˳� 725
	// ��������ͨ�� 726
	public void onVoiceCallMessage(Event event);

	// �ܾ�����ͨ�� 727
	public void onVoiceCallRejectMessage(Event event);

	// ��������ͨ�� 728
	public void onVoiceCallAcceptMessage(Event event);

	// ������ӶϿ� 802
	// ΢�����ӶϿ� 803
	// ϵͳ��ʾ���ȷ�� 810
	// ϵͳ��Ϣ 10000
	public void onSystemMessage(Event event);

}