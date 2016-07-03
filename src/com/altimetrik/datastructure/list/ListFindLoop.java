package com.altimetrik.datastructure.list;

public class ListFindLoop {
	public void findLoop(SingleLinkedListCustom.Node node) {
		while(true) {
			
		}
	}

	public static void main(String[] args) {
		ListFindMidElement l = new ListFindMidElement();
		SingleLinkedListCustom list = new SingleLinkedListCustom();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(80);
		list.add(90);
		list.makeALoop(70);
	}
}
