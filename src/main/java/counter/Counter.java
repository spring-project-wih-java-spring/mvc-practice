package counter;

public class Counter implements Runnable{

    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        increment();
        System.out.println("value for thread after increment " + Thread.currentThread().getName() + " " + getCount());
        decrement();
        System.out.println("value for thread after decrement " + Thread.currentThread().getName() + " " + getCount());
    }
}
