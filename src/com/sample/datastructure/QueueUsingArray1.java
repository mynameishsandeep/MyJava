package com.sample.datastructure;

/**
 * The interface for a generic queue.
 * 
 * @author Alex Laird
 * @version 1.0
 * File: Queue.java
 * Created: Oct 2008
 *
 * @param <E> defines the generics for the queue
 */
interface MyQueue<E>
{
  public void enqueue(E element);
  public E dequeue() throws Exception;
  public E front() throws Exception;
  public int size();
  public boolean isEmpty();
}

public class QueueUsingArray1<E> implements MyQueue<E>
{
  public static final int  CAPACITY = 1000;  // default queue capacity
  protected int  capacity;  // current queue capacity
  protected int  front;  // index of the first element in queue
  protected int  next;  // index of the next available array cell in queue
  protected E[]  genArray;  // generic array used to implement the queue
  
  /**
   * Default constructor.  Passes the default capacity for the array if one is not specified.
   */
  public QueueUsingArray1()
  {
    this(CAPACITY);
  }
  
  /**
   * A constructor which will define the  generic array used to implement the queue and set it's size.
   * 
   * @param cap
   */
  public QueueUsingArray1(int cap)
  {
    capacity = cap + 1;
    genArray = (E[]) new Object[capacity];
    
    front = next = 0;
  }
  
  /**
   * Inserts an element at the rear of the queue.
   * 
   * @param element the element to be inserted
   */
  public void enqueue(E element)
  {
    
    
    // insert element, increment next pointer (wrap-around supported)
    genArray[next] = element;
    next = (++next)%capacity;
  }

  /**
   * Removes the element at the rear of the queue.
   * 
   * @throws QueueEmptyException if the queue is empty
   * @return the removed element
   */
  public E dequeue() throws Exception
  {
    E element;
    
    if(isEmpty())
      throw new Exception("Queue is empty.");
    
    // remove element, null and increment front pointer (wrap-around supported)
    element = genArray[front];
    genArray[front] = null;
    front = (++front)%capacity;
    
    return element;
  }
  
  /**
   * Returns, but does not remove, the front element of the queue.
   * 
   * @throws QueueEmptyException if the queue is empty
   * @return the front element of the queue
   */
  public E front() throws Exception
  {
    if(isEmpty())
      throw new Exception("Queue is empty.");
    
    return genArray[front];
  }
  
  /**
   * Returns the current number of elements in the queue.
   * 
   * @return the number of elements in the queue
   */
  public int size()
  {
    // return the size, wrap-around supported
    return(capacity - front + next)%capacity;
  }
  
  /**
   * Checks to see if the queue is empty.
   * 
   * @return true of false, depending on whether the queue is empty or not
   */
  public boolean isEmpty()
  {
    return(front == next);
  }
  
  /**
   * Will set all values of an array to null
   * 
   * @param array is the array who's values are to be set to null
   * @return the array with each value set to null
   */
  public static Object[] nullArray(Object[] array)
  {
    for(int i = 0; i < array.length; i++)
    {
      array[i] = null;
    }
    
    return array;
  }
  
  /**
   * The main method from which the program executes; it handles all testing and exception handling.
   * 
   * @param args unused
   */
  public static void main(String[] args) throws Exception
  {
    Object[] check = new Object[15];
    Object[] answers = new Object[15];
    boolean  pass = false;
    
    /*
     *  Test #1:  Compliance with Integer
     */
    
    System.out.println("Test #1:  Check to see if queue works properly with Integer objects.");
    
    QueueUsingArray1<Integer> iQueue = new QueueUsingArray1<Integer>();
    
    // valid output for test
    answers[0] = 1;
    answers[1] = 2;
    answers[2] = 3;
    answers[3] = 4;
    answers[4] = 5;
    
    // run test
    iQueue.enqueue(1);
    iQueue.enqueue(2);
    iQueue.enqueue(3);
    iQueue.enqueue(4);
    iQueue.enqueue(5);
    check[0] = iQueue.dequeue();
    check[1] = iQueue.dequeue();
    check[2] = iQueue.dequeue();
    check[3] = iQueue.dequeue();
    check[4] = iQueue.dequeue();
    
    // check test against valid output
    for(int i = 0; i < 5; i++)
    {
      if(check[i] == answers[i])
      {
        pass = true;
      }
      else
      {
        pass = false;
        
        break;
      }
    }
    
    // display result
    if(pass == true)
      System.out.println("PASSED!\n");      
    else
      System.out.println("FAILED!\n");
    
    /*
     * Test #2:  Compliance with String
     */
    System.out.println("Test #2:  Check to see if queue works properly with String objects.");
    
    pass = false;
    check = nullArray(check);
    answers = nullArray(answers);
    QueueUsingArray1<String> sQueue = new QueueUsingArray1<String>();
    
    // valid output
    answers[0] = "A";
    answers[1] = "B";
    answers[2] = "C";
    answers[3] = "D";
    answers[4] = "E";
    
    // run test
    sQueue.enqueue("A");
    sQueue.enqueue("B");
    sQueue.enqueue("C");
    sQueue.enqueue("D");
    sQueue.enqueue("E");    
    check[0] = sQueue.dequeue();
    check[1] = sQueue.dequeue();    
    check[2] = sQueue.dequeue();    
    check[3] = sQueue.dequeue();    
    check[4] = sQueue.dequeue();
    
    // check test against valid output
    for(int i = 0; i < 5; i++)
    {
      if(check[i].equals(answers[i]))
      {
        pass = true;
      }
      else
      {
        pass = false;
        
        break;
      }
    }
    
    // display result
    if(pass == true)
      System.out.println("PASSED!\n");      
    else
      System.out.println("FAILED!\n");
    
    /*
     * Test #3:  Compliance with generic Object
     */
    System.out.println("Test #3:  Check to see if queue works properly with generic Objects.");
    
    pass = false;
    check = nullArray(check);
    answers = nullArray(answers);
    QueueUsingArray1<Object> oQueue = new QueueUsingArray1<Object>();
    
    // valid output
    answers[0] = 1;
    answers[1] = 2;
    answers[2] = "A";
    answers[3] = 3;
    answers[4] = null;
    
    // run test
    oQueue.enqueue(1);
    oQueue.enqueue(2);
    oQueue.enqueue("A");
    oQueue.enqueue(3);
    oQueue.enqueue(null);    
    check[0] = oQueue.dequeue();
    check[1] = oQueue.dequeue();
    check[2] = oQueue.dequeue();
    check[3] = oQueue.dequeue();
    check[4] = oQueue.dequeue();
    
    // check test against valid output
    for(int i = 0; i < 5; i++)
    {
      try
      {
        if(check[i].equals(answers[i]))
        {
          pass = true;
        }
        else
        {
          pass = false;
          
          break;
        }
      }
      catch(NullPointerException c)
      {
        if(check[i] == answers[i])
        {
          pass = true;
        }
        else
        {
          pass = false;
          
          break;
        }
      }
    }
    
    // display result
    if(pass == true)
      System.out.println("PASSED!\n");      
    else
      System.out.println("FAILED!\n");
    
    /*
     * Test #4:  Wrap-around test
     */
    System.out.println("Test #4:  Create a queue sized five; load and unload elements to cause wrap-around.");
    
    pass = false;
    check = nullArray(check);
    answers = nullArray(answers);
    QueueUsingArray1<Integer> wrapQueue = new QueueUsingArray1<Integer>(5);
    
    // valid output
    answers[0] = 1;
    answers[1] = 2;
    answers[2] = 3;
    answers[3] = 4;
    answers[4] = 5;
    answers[5] = 6;
    answers[6] = 7;
    answers[7] = 8;
    
    // run test
    wrapQueue.enqueue(1);
    wrapQueue.enqueue(2);
    wrapQueue.enqueue(3);
    check[0] = wrapQueue.dequeue();
    check[1] = wrapQueue.dequeue();
    wrapQueue.enqueue(4);
    wrapQueue.enqueue(5);
    wrapQueue.enqueue(6);
    check[2] = wrapQueue.dequeue();
    check[3] = wrapQueue.dequeue();
    check[4] = wrapQueue.dequeue();
    check[5] = wrapQueue.dequeue();
    wrapQueue.enqueue(7);
    wrapQueue.enqueue(8);
    check[6] = wrapQueue.dequeue();
    check[7] = wrapQueue.dequeue();
    
    // check test against valid output
    for(int i = 0; i < 8; i++)
    {
      if(check[i] == answers[i])
      {
        pass = true;
      }
      else
      {
        pass = false;
        
        break;
      }
    }
    
    // display result
    if(pass == true)
      System.out.println("PASSED!\n");      
    else
      System.out.println("FAILED!\n");
    
    /*
     * Test #5:  Test for simple resize
     */
    System.out.println("Test #5:  Create a queue sized to five; load the queue with more than five to resize.");
    
    pass = false;
    check = nullArray(check);
    answers = nullArray(answers);
    QueueUsingArray1<Integer> simpleResizeQueue = new QueueUsingArray1<Integer>(5);
    
    // valid output
    answers[0] = 5;
    answers[1] = 10;
    answers[2] = 15;
    answers[3] = 20;
    answers[4] = 25;
    answers[5] = 30;
    answers[6] = 35;
    answers[7] = 40;
    answers[8] = 45;
    answers[9] = 50;
    
    // run test
    simpleResizeQueue.enqueue(5);
    simpleResizeQueue.enqueue(10);
    simpleResizeQueue.enqueue(15);
    simpleResizeQueue.enqueue(20);
    simpleResizeQueue.enqueue(25);
    simpleResizeQueue.enqueue(30);
    simpleResizeQueue.enqueue(35);
    simpleResizeQueue.enqueue(40);
    simpleResizeQueue.enqueue(45);
    simpleResizeQueue.enqueue(50);
    check[0] = simpleResizeQueue.dequeue();
    check[1] = simpleResizeQueue.dequeue();
    check[2] = simpleResizeQueue.dequeue();
    check[3] = simpleResizeQueue.dequeue();
    check[4] = simpleResizeQueue.dequeue();
    check[5] = simpleResizeQueue.dequeue();
    check[6] = simpleResizeQueue.dequeue();
    check[7] = simpleResizeQueue.dequeue();
    check[8] = simpleResizeQueue.dequeue();
    check[9] = simpleResizeQueue.dequeue();
    
    // check test against valid output
    for(int i = 0; i < 10; i++)
    {
      if(check[i] == answers[i])
      {
        pass = true;
      }
      else
      {
        pass = false;
        
        break;
      }
    }
    
    // display result
    if(pass == true)
      System.out.println("PASSED!\n");      
    else
      System.out.println("FAILED!\n");
    
    /*
     * Test #6:  Test for complex resize
     */
    System.out.println("Test #6:  Create a queue sized to ten; load and unload the queue to cause wrap-around; load "); 
    System.out.println("the queue with more than ten items to resize with wrap-around.");
    
    pass = false;
    check = nullArray(check);
    answers = nullArray(answers);
    QueueUsingArray1<Integer> complexResizeQueue = new QueueUsingArray1<Integer>(10);

    // valid output
    answers[0] = 1;
    answers[1] = 2;
    answers[2] = 3;
    answers[3] = 4;
    answers[4] = 5;
    answers[5] = 6;
    answers[6] = 7;
    answers[7] = 8;
    answers[8] = 9;
    answers[9] = 10;
    answers[10] = 11;
    answers[11] = 12;
    answers[12] = 13;
    answers[13] = 14;
    answers[14] = 15;
    
    // run test
    complexResizeQueue.enqueue(1);
    complexResizeQueue.enqueue(2);
    complexResizeQueue.enqueue(3);
    complexResizeQueue.enqueue(4);
    check[0] = complexResizeQueue.dequeue();
    check[1] = complexResizeQueue.dequeue();  
    complexResizeQueue.enqueue(5);
    complexResizeQueue.enqueue(6);
    complexResizeQueue.enqueue(7);
    check[2] = complexResizeQueue.dequeue();
    check[3] = complexResizeQueue.dequeue();
    complexResizeQueue.enqueue(8);
    complexResizeQueue.enqueue(9);
    complexResizeQueue.enqueue(10);
    complexResizeQueue.enqueue(11);
    complexResizeQueue.enqueue(12);
    complexResizeQueue.enqueue(13);
    complexResizeQueue.enqueue(14);
    complexResizeQueue.enqueue(15);
    check[4] = complexResizeQueue.dequeue();
    check[5] = complexResizeQueue.dequeue();
    check[6] = complexResizeQueue.dequeue();
    check[7] = complexResizeQueue.dequeue();
    check[8] = complexResizeQueue.dequeue();
    check[9] = complexResizeQueue.dequeue();
    check[10] = complexResizeQueue.dequeue();
    check[11] = complexResizeQueue.dequeue();
    check[12] = complexResizeQueue.dequeue();
    check[13] = complexResizeQueue.dequeue();
    check[14] = complexResizeQueue.dequeue();
    
    // check test against valid output
    for(int i = 0; i < 15; i++)
    {
      if(check[i] == answers[i])
      {
        pass = true;
      }
      else
      {
        pass = false;
        
        break;
      }
    }
    
    // display result
    if(pass == true)
      System.out.println("PASSED!\n");      
    else
      System.out.println("FAILED!\n");
    
    /*
     * Test #7:  Test for front check when queue is empty
     */
    System.out.println("Test #7:  Check front element before anything is stored there to throw QueueEmptyException.");
    
    pass = false;
    check = nullArray(check);
    answers = nullArray(answers);
    QueueUsingArray1<Double> frontQueue = new QueueUsingArray1<Double>();
    
    // run test
    try
    {
      frontQueue.front();
    }
    catch(Exception c)
    {
      System.out.println("The queue was empty when the front item was called.");
      
      pass = true;
    }
    finally
    {
      if(pass == true)
      {
        System.out.println("PASSED!\n");
      }
      else
      {
        System.out.println("FAILED!\n");
      }
    }
    
    /*
     * Test #8:  Test for QueueEmptyException after input
     */
    System.out.println("Test #8:  Load the queue with values; remove all elements plus one to throw QueueEmptyException.");
    
    pass = false;
    check = nullArray(check);
    answers = nullArray(answers);
    QueueUsingArray1<Double> queueEmptyQueue = new QueueUsingArray1<Double>();
    
    // run test
    try
    {
      queueEmptyQueue.enqueue(23.0);
      queueEmptyQueue.enqueue(17.77);
      queueEmptyQueue.enqueue(15.5);
      check[0] = queueEmptyQueue.dequeue();
      check[1] = queueEmptyQueue.dequeue();
      check[2] = queueEmptyQueue.dequeue();
      check[3] = queueEmptyQueue.dequeue();
    }
    catch(Exception c)
    {
      System.out.println("The queue was empty when the front item was called.");
      
      pass = true;
    }
    finally
    {
      if(pass == true)
      {
        System.out.println("PASSED!\n");
      }
      else
      {
        System.out.println("FAILED!\n");
      }
    }
  }
}

