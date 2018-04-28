package com.altimetrik.datastructure.list;

public class ListFindMidElement {

	/**
	 * Initially assign both pointer to top. 
	 * move p2 1 time. if next is null --> print p1
	 * move p2 second time. if next is null --> print p2
	 * move p1. 
	 * Above step continues till print
	 */
	public void findMidElement(SingleLinkedListCustom.Node node) {
		SingleLinkedListCustom.Node p1 = node;
		SingleLinkedListCustom.Node p2 = node;
		if (p1 == null) {
			System.out.println("No Element Found");
			return;
		}
		if (p1.next == null) {
			System.out.println("Only 1 Element Found");
			return;
		}
		
		do {
			if (p2.next != null) {
				p2 = p2.next;
				if (p2.next != null) {
					p2 = p2.next;
				} else {
					System.out.println(p1.data);
					return;
				}
			} else {
				System.out.println(p1.data);
				return;
			}
			p1 = p1.next;
		} while (true);
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
		list.add(100);
		l.findMidElement(list.getNode());

	}

}
