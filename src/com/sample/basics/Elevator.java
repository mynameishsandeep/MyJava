package com.sample.basics;

/*

Elevator logic maintains two different queues - 
	1) one for the upward traversal and 
	2) second for downward traversal along with the direction flag which holds the current direction of movement. 
	
	At any given point in time, only single queue is active for the serving the requests, 
	though both the queues can enqueue requests.
	
	PriorityQueue is used for storing the user requests where priority is decided based on following algorithm.
		1) For upward movement PriorityQueue
			The floor number with lower value has the higher priority.
		2) For downward movement PriorityQueue
			The floor number with higher value has the higher priority.
	
	Requests are removed from the PiorityQueue as soon as they are served. 
	
	====Corner Cases======
	If current floor is 5th and user presses 4th floor with upward moving elevator, 
	then the requests are queued to the downward movement priority queue (which is not yet active)


 */
public class Elevator {

}
