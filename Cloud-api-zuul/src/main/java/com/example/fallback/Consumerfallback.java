package com.example.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class Consumerfallback implements ZuulFallbackProvider {

	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		//*为所有服务提供回退      "consumer"
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		// TODO Auto-generated method stub
		return new ClientHttpResponse() {

			@Override
			public InputStream getBody() throws IOException {
				// TODO Auto-generated method stub
				ObjectMapper om=new ObjectMapper();
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("message", "无法连接网络，请重试");
				map.put("status", 200);
				return new ByteArrayInputStream(om.writeValueAsString(map).getBytes("UTF-8"));
			}

			@Override
			public HttpHeaders getHeaders() {
				// TODO Auto-generated method stub
				HttpHeaders header=new HttpHeaders();
				header.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return header;
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.OK.value();
			}

			@Override
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				
				return HttpStatus.OK.getReasonPhrase();
			}

			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

}
