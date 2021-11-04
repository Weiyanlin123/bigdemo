package com.citycloud.dcm.street.util;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class DateEditorUtil extends JsonSerializer<Date> {

//	@Override
//	public void serialize(Date value, JsonGenerator jgen, SerializerProvider arg2)
//			throws IOException, JsonProcessingException {
//		// TODO Auto-generated method stub
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String formattedDate = formatter.format(value);
//		jgen.writeString(formattedDate);
//	}

	@Override
	public void serialize(Date date, com.fasterxml.jackson.core.JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = formatter.format(date);
		jsonGenerator.writeString(formattedDate);
	}
}