package com.main;

import java.util.Comparator;

public class MyObjectComparator implements Comparator<MyObject> {
	
	public int compare(MyObject chair1, MyObject chair2) {
        return chair1.returnString().compareTo(chair2.returnString());
    }
}
