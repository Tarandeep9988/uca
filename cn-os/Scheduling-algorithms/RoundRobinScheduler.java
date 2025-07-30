import java.util.List;
import java.util.HashMap;

public class RoundRobinScheduler implements Scheduler {
    int timeQuantum;
    HashMap<Task, Thread> taskThreadMap;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
        this.taskThreadMap = new HashMap<>();
    }

    @Override
    public void execute(List<Task> taskList) {
        // 1. Create and start threads (they immediately wait)
        // Start the time and put them in queue as they come.
        for (Task task : taskList) {
            Thread t = new Thread(task, "Task-" + task.getTaskId() + "-" + task.getArrivalTime());
            taskThreadMap.put(task, t);
        }

        int currentTime = 0, completed = 0;

        while (completed < taskList.size()) {

        }

        printStatistic(taskList);
        
    }

    private void printStatistic(List<Task> taskList) {

    }
}

