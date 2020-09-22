package a2;

import java.util.PriorityQueue;

public class YourMonitor {

    private int nCounters;
    // Put your attributes here...
    private int nWaiting;
    private PriorityQueue<Integer> queue;
    private PriorityQueue<Integer> clerk;

    public YourMonitor(int n) {
        this.nCounters = n;  //antal disker
      // Initialize your attributes here...
        this.nWaiting=0;
        this.queue= new PriorityQueue<>();
        this.clerk= new PriorityQueue<>();

    }

    /**
     * Return the next queue number in the intervall 0...99.
     * There is never more than 100 customers waiting.
     */
    synchronized int customerArrived() {
     // Implement this method...
        nWaiting++;
        queue.add(nWaiting);
        notifyAll();
    return nWaiting;
    }
    /**
     * Register the clerk at counter id as free. Send a customer if any.
     */
    synchronized void clerkFree(int id){
     // Implement this method...
        clerk.add(id);
        notifyAll();
    }
    /**
     * Wait for there to be a free clerk and a waiting customer , then
     * return the queue number of next customer to serve and the counter
     * number of the engaged clerk.
     */
    synchronized DispData getDisplayData() throws InterruptedException {
     // Implement this method...
        while (queue.size()==0 || clerk.size()==0){
            wait();
        }
        DispData dispData= new DispData( queue.poll(), clerk.poll());
        return dispData;
    }

}
