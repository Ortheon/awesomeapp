package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class Sanitizer {
	
	private static String sanitizerOffensiveWords(String content) {
				return content.replaceAll("offensiveWords","****");
				
	}
	private static String sanitizerExternalDomain(String content) {
		String temp;
        Pattern p = Pattern.compile("www.*");
        Pattern d = Pattern.compile("www.site.com");
        List<String> words = new ArrayList<>();
        words = Arrays.asList(content.split(" "));
        
        for (int i = 0; i < words.size(); i++) {
        	Matcher domain = d.matcher(words.get(i));
        	if(domain.find()) {
        		continue;
        	}
        	Matcher matcher = p.matcher(words.get(i));
        	temp =  matcher.replaceFirst("");
        	words.set(i, temp);
         
		}
        StringBuilder contentSanitized = new StringBuilder("");
        for (int i = 0; i < words.size(); i++) {
        	contentSanitized.append(words.get(i)).append(" ");
		}
        content = contentSanitized.toString();
        return content;
	}
	
	private static String sanitizerFirstLetterUpperCase(String content, String director) {
		
		Matcher matcherSurname;
		Matcher matcherName;
		
		String[] tempDirector = director.split(" ");
		String name = StringUtils.capitalize(tempDirector[0]);
		String surname = StringUtils.capitalize(tempDirector[1]);
		
        Pattern p = Pattern.compile(tempDirector[0]);
        Pattern d = Pattern.compile(tempDirector[1]);
        List<String> words = new ArrayList<>();
        words = Arrays.asList(content.split(" "));
        
        for (int i = 0; i < words.size(); i++) {
        	
        	matcherSurname = d.matcher(words.get(i));
        	if(matcherSurname.find()) {
        		words.set(i, surname);	
        	}
        	matcherName = p.matcher(words.get(i));
        	if(matcherName.find()) {
        	words.set(i, name);
        	}
		}
        StringBuilder contentSanitized= new StringBuilder("");
        for (int i = 0; i < words.size()-1; i++) {
        	contentSanitized.append(words.get(i)).append(" ");       
		}
        contentSanitized.append(words.get(words.size()-1)); 
		content = contentSanitized.toString();
		
		return content;
	}

	private static String sanitizerTooManySpaces(String content) {
		
		Matcher matcherSpaces;
		Pattern s = Pattern.compile(" +");
		matcherSpaces = s.matcher(content);
		content = matcherSpaces.replaceAll(" ");
		return content;
	}
	
public static String sanitizer(String content/*, String director*/) 	{
	
		content = sanitizerExternalDomain(content);
		content = sanitizerOffensiveWords(content);
		//content = sanitizerFirstLetterUpperCase(content, director);
		content = sanitizerTooManySpaces(content);
		return content;
	}
}
