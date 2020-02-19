// Run a task with the help of callable and store it's result in the Future.

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.Random;

class myClass {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> futureTask =executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);

                System.out.println("Starting...");

                try {
                    Thread.sleep(duration);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished.");
                return 1;
            }
        });

        executor.shutdown();

        try {
            System.out.println("Future value " + futureTask.get());
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        catch(ExecutionException e) {
            e.printStackTrace();
        }
    }
}
