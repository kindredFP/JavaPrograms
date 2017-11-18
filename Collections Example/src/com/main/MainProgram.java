package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainProgram {

	public static void main(String[] args) {
		
		MyObject myobj1 = new MyObject();
		MyObject myobj2 = new MyObject();
		MyObject myobj3 = new MyObject();
		MyObject myobj4 = new MyObject();
		List<MyObject> myList = new ArrayList<MyObject>();
		
		myobj1.storeString("b");
		myobj2.storeString("y");
		myobj3.storeString("a");
		myobj4.storeString("t");
		
		myList.add(myobj1);
		myList.add(myobj2);
		myList.add(myobj3);
		myList.add(myobj4);

		Collections.sort(myList, new MyObjectComparator());
		
		for (int i = 0;i < myList.size() ;i++){
			System.out.println(myList.get(i).returnString());
		}
	
	
	}

}
