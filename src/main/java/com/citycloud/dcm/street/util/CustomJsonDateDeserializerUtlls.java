package com.citycloud.dcm.street.util;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wansiliang
 * @date 2019/12/4 11:17
 */
public class CustomJsonDateDeserializerUtlls extends JsonDeserializer<Date> {
    private SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public Date deserialize(com.fasterxml.jackson.core.JsonParser jp, DeserializationContext deserializationContext) throws IOException, com.fasterxml.jackson.core.JsonProcessingException {
        String text = jp.getText();

        if (StringUtils.hasText(text)) {
            try {
                if (text.indexOf(":") == -1 && text.length() == 10) {
                    return this.dateFormat.parse(text);
                } else if (text.indexOf(":") > 0 && text.length() == 19) {
                    return this.datetimeFormat.parse(text);
                } else {
                    throw new IllegalArgumentException("Could not parse date, date format is error ");
                }
            } catch (ParseException ex) {
                IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + ex.getMessage());
                iae.initCause(ex);
                throw iae;
            }
        } else {
            return null;
        }
    }
}

