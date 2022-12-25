package com.ck.strings.easy;

import java.util.function.IntConsumer;

// LC - 1195. Fizz Buzz Multithreaded - Maintain Order
// https://leetcode.com/problems/fizz-buzz-multithreaded/
public class FizzBuzzMultiThreadI {

    private int n;
    private int cnt;
    private int cnt3=1;
    private int cnt5=1;

    public FizzBuzzMultiThreadI(int n) {
        this.n = n;
        this.cnt=1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        
        synchronized(this){
            while(cnt<=n){
            	// optimization - start
                //if(cnt%3!=0 || cnt%5==0){
                // optimization - end
            	if(cnt3!=3 || cnt5==5){
                    wait();
                    continue;
                    
                }
                printFizz.run();
                // optimization - start
                cnt3=1;
                cnt5++;
                // optimization - end
                cnt++;
                notifyAll();
            }
        }
        
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized(this){
            while(cnt<=n){
            	// optimization - start
                //if(cnt%5!=0 || cnt%3==0){
                // optimization - end
                if(cnt5!=5 || cnt3==3){
                    wait();
                    continue;
                }
                
                printBuzz.run();
                // optimization - start
                cnt3++;
                cnt5=1;
                // optimization - end
                cnt++;
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized(this){
            while(cnt<=n){
            	// optimization - start
                //if(cnt%3!=0 || cnt%5!=0){
                // optimization - end
                if(cnt3!=3 || cnt5!=5){
                    wait();
                    continue;
                }
                printFizzBuzz.run();
                // optimization - start
                cnt3=1;
                cnt5=1;
                // optimization - end
                cnt++;
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized(this){
            while(cnt<=n){
            	// optimization - start
                //if(cnt%3==0 || cnt%5==0){
                // optimization - end
                if(cnt3==3 || cnt5==5){
                    wait();
                    continue;
                }
                printNumber.accept(cnt);
                // optimization - start
                cnt3++;
                cnt5++;
                // optimization - end
                cnt++;
                notifyAll();
            }
        }
    }
	
	public static void main(String[] args) {
		
		FizzBuzzMultiThreadI fb = new FizzBuzzMultiThreadI(15);
		Runnable r1 = ()->System.out.println("Fizz");
		Runnable r2 = ()->System.out.println("Buzz");
		Runnable r3 = ()->System.out.println("FizzBuzz");
		IntConsumer ic = (i) -> System.out.println(i);
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					fb.fizz(r1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					fb.buzz(r2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t3 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					fb.fizzbuzz(r3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					fb.number(ic);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
