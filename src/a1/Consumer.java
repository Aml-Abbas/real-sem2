package a1;

class Consumer extends Thread {
    Buffer theBuffer;
    Consumer(Buffer b) {
        super();
        theBuffer = b;
    }
    public void run() {
        try {
            sleep(10); // 10s until work starts.
            while (true) {
                System.out.println(theBuffer.getLine());
            }
        } catch (Exception e) {/* Let thread terminate. */};
    } // run
} // a1.Consumer
