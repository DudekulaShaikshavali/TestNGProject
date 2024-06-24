package com.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class StringOccurance {
	public static void main(String[] args) {
		String s="ramalinga subrahmanyam";
		Map<Character,Integer>map=new LinkedHashMap<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(map.containsKey(c)) {
				int a=map.get(c);
				map.put(c,a+1);
			}else {
				map.put(c, 1);
			}
			
			
		}
		
	}

}
