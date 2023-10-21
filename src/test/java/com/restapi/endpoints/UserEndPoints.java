package com.restapi.endpoints;

import com.restapi.payloads.UserPayload;
import com.restapi.urls.Urls;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Created for perform Create, Read, Update, Delete requests to the user APIs.

public class UserEndPoints {
public static Response createUser(UserPayload payload)
		{
			Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Urls.post_url);
				
			return response;
		}
		
		
		public static Response readUser(String userName)
		{
			Response response=given()
				.pathParam("username",userName)
				.when()
				.get(Urls.get_url);
				
			return response;
		}
		
		
		public static Response updateUser(String userName, UserPayload payload)
		{
			Response response= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.put(Urls.update_url);
				
			return response;
		}
		
		
		public static Response deleteUser(String userName)
		{
			Response response=given()
				.pathParam("username",userName)
				.when()
				.delete(Urls.delete_url);
				
			return response;
		}	    
}
