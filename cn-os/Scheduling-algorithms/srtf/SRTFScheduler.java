import java.util.*;

public class SRTFScheduler implements Scheduler {

    private Map<Task, Thread> taskThreadMap;

    public SRTFScheduler() {
        taskThreadMap = new HashMap<>();
    }

    @Override
    public void execute(List<Task> taskList) {
        PriorityQueue<Task> queue = new PriorityQueue<Task>((t1, t2) -> {
            if (t1.getRemainingTime() != t2.getRemainingTime()) {
                return Integer.compare(t1.getRemainingTime(), t2.getRemainingTime());
            }

            if (t1.getPriority() != t2.getPriority()) {
                return Integer.compare(t2.getPriority(), t1.getPriority());
            }

            return Integer.compare(t1.getArrivalTime(), t2.getArrivalTime());
        });

        for (Task t : taskList) {
            Thread thread = new Thread(t);
            thread.start();
            taskThreadMap.put(t, thread);
        }

        int currentTime = 0;
        int completed = 0;
        int idx = 0;

        while (completed < taskList.size()) {
            // adding in the queue , the task that has arrived
            while (idx < taskList.size() && taskList.get(idx).getArrivalTime() <= currentTime) {
                queue.offer(taskList.get(idx));
                idx++;
            }

            if (queue.isEmpty()) {
                currentTime++;
                Thread.sleep(100);
                continue;
            }

            Task currentTask = queue.poll();
            currentTask.resume(); // Execute one unit
            Thread.sleep(100);
            currentTime++;

            if (currentTask.isCompleted()) {
                currentTask.calculateTimes(currentTime);
                completed++;
                System.out.printf("Task %d is completed at this time %d", currentTask.getTaskId(), currentTime);
            } else {
                // task is paused
                queue.offer(currentTask);
            }
        }

        for (Thread t : taskThreadMap.values()) {
            t.join();
        }
        printStatistic(taskList);
    }

    private void printStatistic(List<Task> taskList) {
        System.out.println("\nTask | Completion | Turnaround | Waiting");
        for (Task t : taskList) {
            System.out.printf(" %2d  |     %2d     |     %2d     |    %2d\n",
                    t.getTaskId(), t.getCompletionTime(),
                    t.getTurnaroundTime(), t.getWaitingTime());
        }
    }
}


