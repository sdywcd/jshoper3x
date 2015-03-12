package com.jshop.action.backstage.utils;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class SQLDateTypeAdapter implements JsonSerializer<java.sql.Date> {
	  private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public JsonElement serialize(Date src, Type arg1,
			JsonSerializationContext arg2) {
		 String dateFormatAsString = format.format(new java.sql.Date(src.getTime()));
         return new JsonPrimitive(dateFormatAsString);
	}

}
