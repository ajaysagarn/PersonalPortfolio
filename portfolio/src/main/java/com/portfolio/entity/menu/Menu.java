package com.portfolio.entity.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ajsa.dyrepo.repository.property.model.Property;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {

	private String id;
	
	private String name;
	
	private List<MenuItem> menuItems;

	public List<Property> getNodeProperties( Map<String, Object>  attributes){
		List<Property> properties = new ArrayList<>();


		for(Map.Entry<String, Object> value: attributes.entrySet()){
			String type = value.getValue().getClass().getName();
			properties.add(Property.builder()
					.name(value.getKey())
					.type(type.substring(type.lastIndexOf('.')+1,type.length()))
					.id(value.getKey()).value(value.getValue().toString()).build());
		}


		return properties;
	}


}
