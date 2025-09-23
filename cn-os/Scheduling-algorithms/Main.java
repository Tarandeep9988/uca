import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create a list of tasks (taskId, arrivalTime, burstTime, priority)
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1, 0, 5, 1));   // arrives at 0, needs 5 units
        taskList.add(new Task(2, 2, 3, 2));   // arrives at 2, needs 3 units
        taskList.add(new Task(3, 4, 6, 1));   // arrives at 4, needs 6 units
        taskList.add(new Task(4, 6, 4, 3));   // arrives at 6, needs 4 units

        // Create Round Robin scheduler with time quantum = 2
        RoundRobinScheduler scheduler = new RoundRobinScheduler(2);

        // Execute scheduling
        scheduler.execute(taskList);
    }
}
