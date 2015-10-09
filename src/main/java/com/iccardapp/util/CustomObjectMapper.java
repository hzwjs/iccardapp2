package com.iccardapp.util;



import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.springframework.stereotype.Component;

/**
 * 解决SpringMVC使用@ResponseBody返回json时，日期格式默认显示为时间戳的问题。需配合<mvc:message-converters>
 * 使用
 * 
 * @author hellostory
 * @date 2013-10-31 下午04:17:52
 */
@Component("customObjectMapper")
public class CustomObjectMapper extends ObjectMapper {
	public CustomObjectMapper() {
		CustomSerializerFactory factory = new CustomSerializerFactory();
		factory.addGenericMapping(Timestamp.class,
			new JsonSerializer<Timestamp>() {
				@Override
				public void serialize(Timestamp value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException, JsonProcessingException {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					jsonGenerator.writeString(sdf.format(value));
				}
			});
		this.setSerializerFactory(factory);
	}
}