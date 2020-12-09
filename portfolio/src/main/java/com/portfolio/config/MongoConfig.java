package com.portfolio.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "ajsadb";
	}
	
	@Override
	public MongoClient mongoClient() {
		ConnectionString connectionString = new ConnectionString("mongodb://ajsadb:361899@localhost:27888/?authSource=admin&authMechanism=SCRAM-SHA-1");
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
					.applyConnectionString(connectionString).build();
		return MongoClients.create(mongoClientSettings);
		
	}
	
	@Override
	 public Collection getMappingBasePackages() {
		return Collections.singleton("com.example");    
	}
	
}
