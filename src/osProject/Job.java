/**
 * Class will represent a single job and will contain all operations performed
 * on job
 * Later program will create a job table to store job objects

*/
//package osProject;

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
    private boolean requestIO; 
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
        requestIO = false; 
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
        requestIO = false; 
        swapping = false;
        blocked = false;
        running = false;
        killed = false;
    }
    
    public int getJobNumber(){
    	return jobNumber; 
    }
    
    public void setJobNumber(int jobNumber){
    	this.jobNumber = jobNumber; 
    }
    
    public int getjobPriority(){
    	return jobPriority; 
    }
    
    public void setJobPriority(int jobPriority){
    	this.jobPriority = jobPriority; 
    }
    
    public int getJobSize(){
    	return jobSize;
    }
    
    public void setJobSize(int jobSize){
    	this.jobSize = jobSize; 
    }
    
    public int getMaxTime(){
    	return maxTime;
    }
    
    public void setMaxTime(int maxTime){
    	this.maxTime = maxTime; 
    }
    
    public int getEnterCPUTime(){
    	return enterCPUTime; 
    }
    
    public void setEnterCPUTime(int enterCPUTime){
    	this.enterCPUTime = enterCPUTime; 
    }
    
    public boolean getInMemory(){
    	return inMemory; 
    }
    
    public void setInMemory(boolean inMemory){
    	this.inMemory = inMemory; 
    }
    
    public int getAddress(){
    	return address; 
    }
    
    public void setAddress(int address){
    	this.address = address; 
    }
    
    
    public boolean getDoingIO(){
    	return doingIO; 
    }
    
    public void setDoingIO(boolean doingIO){
    	this.doingIO = doingIO; 
    }
    
    public boolean getRequestIO(){
    	return requestIO; 
    }
    
    public void setRequestIO(boolean requestIO){
    	this.requestIO = requestIO; 
    }
    
    public boolean getSwapping(){
    	return swapping; 
    }
    
    public void setSwapping(boolean swapping){
    	this.swapping = swapping; 
    }
    
    public boolean getBlocked(){
    	return blocked; 
    }
    
    public void setBlocked(boolean blocked){
    	this.blocked = blocked; 
    }
    
    public boolean getRunning(){
    	return running; 
    }
    
    public void setRunning(boolean running){
    	this.running = running; 
    }
    
    public boolean getKilled(){
    	return killed; 
    }
    
    public void setKilled(boolean killed){
    	this.killed = killed; 
    }
}
