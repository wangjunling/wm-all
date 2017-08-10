package site.wmblog.common.sms.luosimao;



import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import site.wmblog.common.sms.AbstractPhoneMessage;
import site.wmblog.common.util.FastJson;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import java.util.Map;

public class LuoSiMaoPhoneMessageImpl extends AbstractPhoneMessage {

	public static final Logger logger = LoggerFactory.getLogger(LuoSiMaoPhoneMessageImpl.class);


	private String sendUrl;
	private String token;

	public void sendMessage(Map<String,String> phoneByMessage){

	}

	public void sendMessage(String content, String phone) {
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter(
				"api", token));
		WebResource webResource = client.resource(
				sendUrl);
		MultivaluedMapImpl formData = new MultivaluedMapImpl();
		formData.add("mobile", phone);
		formData.add("message", content);
		ClientResponse response =  webResource.type( MediaType.APPLICATION_FORM_URLENCODED ).
				post(ClientResponse.class, formData);
		logger.info("luosimao send param phone : {} content : {}",phone,content);
		String jsonResult = response.getEntity(String.class);
		logger.info("luosimao send msg result : {}",jsonResult);
		int status = response.getStatus();
		if (status == 200) {
			if (StringUtils.isEmpty(jsonResult))
				throw new RuntimeException("luosimao send result null!");

			Map<String,String> map = FastJson.fromJson(jsonResult,Map.class);
			if (map == null || !map.get("msg").equals("ok"))
				throw new RuntimeException("luosimao send result null!");

		} else {
				throw new RuntimeException("luosimao result http status not succ!");
		}

	}

	public String getSendUrl() {
		return sendUrl;
	}

	public void setSendUrl(String sendUrl) {
		this.sendUrl = sendUrl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
