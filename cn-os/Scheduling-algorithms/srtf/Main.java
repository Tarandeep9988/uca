import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 0, 5, 2));  
        tasks.add(new Task(2, 1, 3, 1));  
        tasks.add(new Task(3, 2, 8, 3));  
        tasks.add(new Task(4, 3, 6, 2));  

        // Sort tasks by arrival time before passing to scheduler
        tasks.sort(Comparator.comparingInt(Task::getArrivalTime));

        // Create scheduler and run
        SRTFScheduler scheduler = new SRTFScheduler();
        scheduler.execute(tasks);
    }
}
