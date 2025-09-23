import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SrtfSchedular implements Scheduler {
    Map<Task, Thread> taskThreadMap;

    public SrtfSchedular() {
        this.taskThreadMap = new HashMap<>();
    }

    @Override
    public void execute(List<Task> taskList) throws InterruptedException {
        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> {
            if (t1.getRemainingTime() != t2.getRemainingTime()) {
                return Integer.compare(t1.getRemainingTime(), t2.getRemainingTime());
            }
            return Integer.compare(t1.getPriority(), t2.getPriority());
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
                pq.offer(taskList.get(idx));
                idx++;
            }

            if (pq.isEmpty()) {
                currentTime++;
                Thread.sleep(100);
                continue;
            }

            Task currentTask = pq.poll();

            if (!currentTask.isCompleted()) {
                currentTask.resume(); // Executre one unit
                Thread.sleep(100);
                currentTime++;

                // Other Task Might Arrive in the same Time
                while (idx < taskList.size() && taskList.get(idx).getArrivalTime() <= currentTime) {
                    pq.offer(taskList.get(idx));
                    idx++;
                }
            }

            if (currentTask.isCompleted()) {
                currentTask.calculateTimes(currentTime);
                completed++;
                System.out.printf("Task %d is completed at this time %d\n", currentTask.getTaskId(), currentTime);
            } else {
                // task is paused
                pq.offer(currentTask);
            }
        }

        // Make sure threads join back
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