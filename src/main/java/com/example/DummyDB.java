package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.alibaba.fastjson.JSON;
import com.google.common.io.Files;

public class DummyDB {
	private int totalCountries;
	//private String data = "Afghanistan,	Albania, Zimbabwe";
	private List<String> items;

	public DummyDB() {
//		items = new ArrayList<String>();
//		StringTokenizer st = new StringTokenizer(data, ",");

//		while (st.hasMoreTokens()) {
//			items.add(st.nextToken().trim());
//		}
		initList();
		totalCountries = items.size();
	}
	
	@SuppressWarnings("unchecked")
	private void initList() {
		items = new ArrayList<String>();
		 items.add("Abhi");
		 items.add("Bee");
		 items.add("Cee");
		 items.add("Dee");
		 items.add("Eee");
		 items.add("Eff");
		 items.add("Gee");
		 
		 try {
			String content = readFile("prod_names_short.json");
			System.out.println(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> getData(String query) {
		String country = null;
		query = query.toLowerCase();
		List<String> matched = new ArrayList<String>();
		for (int i = 0; i < totalCountries; i++) {
			country = items.get(i).toLowerCase();
			if (country.startsWith(query)) {
				matched.add(items.get(i));
			}
		}
		return matched;
	}
	
	static String readFile(String filename) throws IOException {
		String content = new Scanner(new File(filename)).useDelimiter("\\Z").next();
		//System.out.println(content);
		return content;
	}
	
}
