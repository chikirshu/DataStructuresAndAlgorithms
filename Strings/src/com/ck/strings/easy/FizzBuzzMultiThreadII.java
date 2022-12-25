package com.ck.strings.easy;

import java.util.function.IntConsumer;

// Fizz Buzz - Order not important
public class FizzBuzzMultiThreadII {

	private int n;
    private int cnt;
    private int cnt3=1;
    private int cnt5=1;

    public FizzBuzzMultiThreadII(int n) {
        this.n = n;
        this.cnt=1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        
        synchronized(this){
            for(int i=3;i<=n;i=i+3) {
            	System.out.print(i);
            	printFizz.run();
            }
        }
        
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized(this){
        	for(int i=5;i<=n;i=i+5) {
            	System.out.print(i);
            	printBuzz.run();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized(this){
        	for(int i=15;i<=n;i=i+15) {
            	System.out.print(i);
            	printFizzBuzz.run();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized(this){
        	for(int i=1;i<=n;i++) {
        		if(i%3!=0 &&i%5!=0) {
        			printNumber.accept(i);
        		}
            }
        }
    }
	
	public static void main(String[] args) {
		
		FizzBuzzMultiThreadI fb = new FizzBuzzMultiThreadI(15000);
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
