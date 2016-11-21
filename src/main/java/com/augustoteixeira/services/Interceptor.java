package com.augustoteixeira.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.augustoteixeira.configuration.ServerConfiguration;
import com.augustoteixeira.objects.APIObject;
import com.augustoteixeira.utils.Util;

@RestController
public class Interceptor {

	@Autowired
	private ServerConfiguration config;

	@RequestMapping(value = "/bj-jackett/get/api", method = RequestMethod.GET, produces = "application/rss+xml")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String getContent(APIObject obj, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Access: " + obj);
		String uri = obj.createJackettURL(config);
		
		System.out.println("URI: "+ uri);

		try {
			Document document = Jsoup.connect(uri).header("Accept", "application/rss+xml, text/rss+xml, text/xml").get();			
			String xml = Util.normalizeTexts(document);
			return xml;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
