package com.losolved.emplacamento.integration.sdk;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class BaseResult {
	
	
	
	public void populate(ResultSet result) {
	
	  List<Field> fields = Arrays.asList(this.getClass().getDeclaredFields());
	    for(Field field: fields) {
	        field.setAccessible(true);
	    }

	    
	    try {

				for(Field field: fields) {
			    	String name = field.getName();
			    	try{
			            String value = result.getString(name.toUpperCase());
			            field.set(this, field.getType().getConstructor(String.class).newInstance(value));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    
				}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	

}
