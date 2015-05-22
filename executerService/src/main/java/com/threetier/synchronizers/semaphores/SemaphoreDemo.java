package com.threetier.synchronizers.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreDemo {

    public static void main(String[] args) {

        final Pool pool = new Pool();

        Task task = new Task(pool);

        ExecutorService[] executors = new ExecutorService[Pool.MAX_AVAILABLE + 1];

        for (int i = 0; i < executors.length; i++) {
            executors[i] = Executors.newSingleThreadExecutor();
            executors[i].execute(task);
        }
    }
}
