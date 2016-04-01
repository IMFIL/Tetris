package TPackage;

public class TIMER {

long start = 0;
long delay;

public TIMER(long delay) {
    this.delay = delay;
    start();
    boolean time = isExpired();
}

public void start() {
    this.start = System.currentTimeMillis();
}

public boolean isExpired() {
    while ((System.currentTimeMillis() - this.start) < this.delay){
    	
    }
    return true;
}

}
  
