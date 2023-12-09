package ru.knapp.threadpool;

public class ThreadPoolMain {

    public static void main(String[] args) throws Exception {

        ThreadPool threadPool = new ThreadPool(3, 50);

        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            Runnable myTask = () -> {
                String message = Thread.currentThread().getName() + ": Task " + taskNo;
                System.out.println(message);
            };
            threadPool.execute(myTask);
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();

    }
}