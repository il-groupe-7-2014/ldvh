package ihm.graphed;

import java.util.*;

public class QueueTest
{
   public static void main(String[] args)
   {
      BoundedQueue<String> q = new BoundedQueue<String>(10);

      q.add("Belgium");     
      q.add("Italy");     
      q.add("France");     
      q.removeFirst();
      q.add("Thailand");     

      ArrayList<String> a = new ArrayList<String>();
      a.addAll(q);
      System.out.println("Result of bulk add: " + a);
      System.out.println("Minimum: " + Collections.min(q));
   }
}
