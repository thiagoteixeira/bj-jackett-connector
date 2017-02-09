package me.bjshare.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Util {

	private static final Pattern TITLE_PATTERN = Pattern.compile("<title>(.*\\[.*\\])</title>",
			Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	
	private static final Pattern PUBDATE_PATTERN = Pattern.compile("<pubDate>(.+)</pubDate>",
			Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

	public static String normalizeTexts(Document document) {
		String xml = document.toString();
		for (Element e : document.select("title")) {
			Matcher matcher = TITLE_PATTERN.matcher(e.toString());
			while (matcher.find()) {
				String title = matcher.group(1);
				String newTitle = title.replaceAll("\\s(\\d{4})\\s", "").replaceAll("(?is)full hd", "1080p")
						.replaceAll("(?is)(hd)(\\s+|])", "720p$2");

				xml = xml.replace(title, newTitle);
				System.out.println("=========== CHANGING TITLE ============");
				System.out.println("From: " + title);
				System.out.println("To: " + newTitle);
				System.out.println("=======================");
			}
		}
		for (Element e : document.select("pubDate")) {
			Matcher matcher = PUBDATE_PATTERN.matcher(e.toString());
			while (matcher.find()) {
				String pubDate = matcher.group(1);
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z");
				String newPubDate = dateFormat.format(date);

				xml = xml.replace(pubDate.trim(), newPubDate);
				System.out.println("=========== CHANGING PUBDATE ============");
				System.out.println("From: " + pubDate);
				System.out.println("To: " + newPubDate);
				System.out.println("=======================");
			}
		}
		return xml;
	}
}
