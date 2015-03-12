package com.jshop.action.backstage.utils;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TimestampTypeAdapter implements JsonSerializer<Timestamp>, JsonDeserializer<Timestamp>  {
	 private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public Timestamp deserialize(JsonElement json, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		 if (!(json instanceof JsonPrimitive)) {
             throw new JsonParseException("The date should be a string value");
         }
         try {
             Date date = format.parse(json.getAsString());
             return new Timestamp(date.getTime());
         } catch (ParseException e) {
             throw new JsonParseException(e);
         }
	}

	@Override
	public JsonElement serialize(Timestamp src, Type arg1,
			JsonSerializationContext arg2) {
		String dateFormatAsString = format.format(new Date(src.getTime()));
        return new JsonPrimitive(dateFormatAsString);
	}

}
