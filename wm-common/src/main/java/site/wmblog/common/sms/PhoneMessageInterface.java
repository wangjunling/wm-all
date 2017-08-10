package site.wmblog.common.sms;

import java.util.Map;

public interface PhoneMessageInterface {

	/**
	 * key phone
	 * val message
	 * @param phoneByMessage
	 * @return
	 */
	public void sendMessage(Map<String,String> phoneByMessage);
	
	public void sendMessage(String content, String phone);

}
