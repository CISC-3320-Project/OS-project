/**
 * Class will represent a single job and will contain all operations performed
 * on job
 * Later program will create a job table to store job objects

*/
package osProject;

/**
 *
 * @author Johnson
 */
public class Job {
    private int jobNumber; 
    private int jobPriority;
    private int jobSize;
    private int maxTime;
    private int enterCPUTime;
    private boolean inMemory;
    private int address;
    private boolean doingIO;
    private boolean swapping;
    private boolean blocked;
    private boolean running;
    private boolean killed;
    
    //TODO JONSON: write accessors and mutators for all variables
    public Job(){
        jobNumber = -1;
        jobPriority = -1;
        jobSize = 0;
        maxTime = -1;
        enterCPUTime = -1;
        inMemory = false;
        address = -1;
        doingIO = false;
        swapping = false;
        blocked = false;
        running = false;
        killed = false;
    }
    
    public Job(int num, int priority, int size, int time, int currTime){
        jobNumber = num;
        jobPriority = priority;
        jobSize = size; 
        maxTime = time;
        enterCPUTime = currTime;
        inMemory = false;
        address = -1;
        doingIO = false;
        swapping = false;
        blocked = false;
        running = false;
        killed = false;
    }
    
}
