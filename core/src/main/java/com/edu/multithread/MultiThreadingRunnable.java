package com.edu.multithread;

public class MultiThreadingRunnable implements Runnable {
	public static void main(String[] args) {
		createSimpleThread();
		createSimpleWithPriority();
	}

	private static void createSimpleWithPriority() {
		Thread guruthread1 = new Thread();
        guruthread1.start();
        try {
            guruthread1.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        guruthread1.setPriority(1);
        int gurupriority = guruthread1.getPriority();
        System.out.println("gurupriority: " + gurupriority);
        System.out.println("Thread Running");
	}

	private static void createSimpleThread() {
		Thread guruThread1 = new Thread("Guru1");
        Thread guruThread2 = new Thread("Guru2");
        guruThread1.start();
        guruThread2.start();
        System.out.println("Thread names are following:");
        System.out.println(guruThread1.getName());
        System.out.println(guruThread2.getName());
	}

	public void run() {
		
	}
}
