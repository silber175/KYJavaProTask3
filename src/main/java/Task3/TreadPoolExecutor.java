package Task3;


import java.util.LinkedList;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreadPoolExecutor {
    private int threadCount ;
    private  LinkedList<Runnable> taskList;
    private ExecutorService threadPool;
    private boolean threadAviable;
    public ExecutorService getThreadPool()  {
        return this.threadPool;
    }
    public TreadPoolExecutor(int threadCount, LinkedList<Runnable> taskList) {
        this.threadCount = threadCount;
        this.taskList = taskList;
        threadPool = Executors.newFixedThreadPool(threadCount);

        taskAdd(this.taskList);
        threadAviable = true;
    }
    public void shutdown()  {
        threadAviable = false;
    }
    public void taskAdd(LinkedList<Runnable> taskList)   {
        if ( threadAviable == true) {
            Runnable task = taskList.poll();
            while (task != null) {
                threadPool.execute(task);
                task = taskList.poll();
            }
        }
        else {throw  new IllegalStateException("Новые задачи больше не принимаются пулом");}
    }
}

