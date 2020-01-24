

/*
1) How would you prove/debug if MySQL is performing slow due to 1) IO 2)Memory
  	Application  ==> MySQL(Running in OS Kernel Space) ==> OS File System(which saves table as file system.)
  	a) 1) Index 2) statistics 3) Join Queries
  	b) Network File System which might be slow.
  	c) File Locked for longer time because of transaction.
  	d) stale Connection without closing. Do OS level TTL.
  	e) Check fileSystem used by MySQL to save the data to OS.   
  	
2) How would you enforce a app to run min/max limit of memory.
3) 
 */
public class FaceBookTelephonic2 {}
