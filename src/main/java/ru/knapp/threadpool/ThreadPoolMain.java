package ru.knapp.threadpool;

public class ThreadPoolMain {

    public static void main(String[] args) throws Exception {

        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i = 1; i <= 10; i++) {
            System.out.println("fori " + i);
            int taskNo = i;
            Runnable myTask = () -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String message = Thread.currentThread().getName() + ": Task " + taskNo;
                System.out.println(message);
            };
            System.out.println("execute " + i);
            threadPool.execute(myTask);
            System.out.println("execute done" + i);
        }
        System.out.println("waitUntilAllTasksFinished ");
        threadPool.waitUntilAllTasksFinished();
        System.out.println("stop");
        threadPool.stop();

    }
}