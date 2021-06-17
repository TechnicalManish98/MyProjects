package com.dev.core;

import java.util.ArrayList;
import java.util.List;

public class TesterThread implements Runnable{
	

List<String> List = new ArrayList<String>();

public TesterThread(ArrayList<String> list) {
	this.List = list;
	
}


@Override
public void run() {
	System.out.println("Child Thread Class...");
	this.List.add("Name");
	
}

}
