package com.altimetrik.datastructure.list;

/**
 * Use the logic single pointer and double pointer.
 * 1) Verify if the double pointer is not null. Then increment double pointer.
 * 2) Verify again if the double pointer is not null. Then increment double pointer.
 * 3) If double pointer is null. Then there is no loop.
 * 4) Increment single pointer. 
 * 5) If single pointer == double pointer. Then found loop.
 *   
 */
public class ListFindLoop {
	public boolean hasCycle(ListNode singlePointer) {
        ListNode doublePointer = singlePointer;
		while (doublePointer != null && doublePointer.next!=null) {
			doublePointer = doublePointer.next.next;
			singlePointer = singlePointer.next;
			if (singlePointer == doublePointer) {
				return true;
			}
		}
		return false;
    }

}
