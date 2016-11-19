package com.augustoteixeira;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Util {

	static final Pattern TITLE_PATTERN = Pattern.compile("<title>(.*\\[.*\\])</title>", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	
	static final Pattern DESCRIPTION_PATTERN = Pattern.compile("<description>(.*)</description>", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

	public static String normalizeTexts(Document document) {
		String xml = document.toString();
		for (Element e : document.select("title")) {
			Matcher matcher = TITLE_PATTERN.matcher(e.toString());
	        while (matcher.find()) {
	        	String title = matcher.group(1);
	            String newTitle = title.replaceAll("\\s(\\d{4})\\s", "").replaceAll("(?is)full hd", "1080p").replaceAll("(?is)hd", "720p");

	        	xml = xml.replace(title, newTitle);
	            System.out.println("=======================");
	            System.out.println("From: " + title);
	            System.out.println("To: " + newTitle);
	            System.out.println("=======================");
//	            xml = xml;
	        }	        
		}
//		for (Element e : document.select("description")) {
//			Matcher matcher = DESCRIPTION_PATTERN.matcher(e.toString());
//	        while (matcher.find()) {
//	        	String title = matcher.group(1);
//	            String newTitle = title.replaceAll("\\s*\\[\\s*", ".").replaceAll("\\s*\\]", "")
//	                    .replaceAll("(?is)full hd", "1080p").replaceAll("(?is)hd", "720p").replaceAll("\\s*/\\s*", ".");
//	            xml = xml.replace(title, newTitle);
////	            xml = xml.replace(title, "Arrow S05E01 1080p HDTV X264-DIMENSION");
//	            System.out.println("=======================");
//	            System.out.println("From: " + title);
//	            System.out.println("To: " + newTitle);
//	            System.out.println("=======================");
//	        }	        
//		}
		return xml;
	}
}
