//package osProject;
import java.util.*;
/**
 *
 * @author Anton
 */
public class os {
    //declare all nesseccary variables here
    static List<Job> jobTable; //store jobs that is not in memory but enter system
    static MemoryManager memory; //representation of the 100K memory
    static Queue<Integer> IOQueue; //queue of jobs that waiting for I/O
    static boolean swapInProgress;
    static boolean processingIO;
    
    public static void startup (){
        //the first function called by SOS
        //intialize variables here so it will be visible for SOS
        jobTable = new LinkedList<Job>();
        memory = new MemoryManager();
        IOQueue = new LinkedList();
        swapInProgress = false;
        processingIO = false;
        
    }
    
    public static void Crint(int [] a, int [] p){
        //TODO Johnson
        bookkeeper(p[5]);
        //when new job come into system SOS call this function
        //so this function should take care of saving all information about job
        //this function will store jobs in jobTable
        jobTable.add(new Job(p[1],p[2],p[3],p[4],p[5])); 
        swapper();
        runJob(a,p);
    }
    
    public static void Dskint(int [] a, int[] p){
        //TODO Anton
        bookkeeper(p[5]);
        //notify that I/O was completed
        //function should find job that was send to do I/O
        //mark that I/O for that job was done and 
        //select new job from IO queue to do I/O and send it to do I/O
        processingIO = false;
        int posOfIOJob = findJobDoingIO();
        jobTable.get(posOfIOJob).setDoingIO(false);
        jobTable.get(posOfIOJob).setBlocked(false);
        jobTable.get(posOfIOJob).setRequestIO(false);
        if(jobTable.get(posOfIOJob).getKilled()){
            terminateJob(posOfIOJob);
        }
        runIO();
        runJob(a,p);
    }
    
    public static void Drint(int[] a, int[] p){
        //TODO Anton
        bookkeeper(p[5]);
        //trasfer between drum and memory completed
        //boolean should be changed to indicate that drum is free for another swapp
        //job that was swapped have to be moved from jobTable to readyQueue
        //try to swap another job into memory
        swapInProgress = false;
        for(int i = 0; i<jobTable.size(); i++){
            if(jobTable.get(i).getSwapping()){
                jobTable.get(i).setSwapping(false);
                jobTable.get(i).setInMemory(true);
                break;
            }       
        }
        runJob(a,p);
    }
    
    public static void Svc (int[] a, int [] p){
        //TODO Anton
        int stoppedJob = bookkeeper(p[5]);
        /**
        function handle service request
        should have 3 main IF statements, each for particular situation
        1st IF - job terminated (probably freed memory and change status of the job)
        2nd IF - job requesting I/O (put job in I/O queue and call function for handling I/O)
        3rd IF - blocks job until it finishes its I/O
        **/
        if (a[0] == 5){
            //request to terminate job
            //if job not currently doing or not waiting for I/O it must be killed
            //and memory have to be freed up
            //if job currently doing I/O or waiting for I/O set job flag 'killed'
            //to true
            if(jobTable.get(stoppedJob).getDoingIO() || jobTable.get(stoppedJob).getRequestIO())
                jobTable.get(stoppedJob).setKilled(true);
            else{
                terminateJob(stoppedJob);
            }
        }
        if(a[0] == 6){
            //request to do I/O
            //place jobNumber into IOQueue
            //try to run IO if no job doing IO 
            jobTable.get(stoppedJob).setRequestIO(true);
            IOQueue.add(jobTable.get(stoppedJob).getJobNumber());
            if(IOQueue.size()==1 && !processingIO){ //if job requesting I/O is the only job that wants do I/O then send it to do I/O
                runIO();
            }
        }
        if(a[0] == 7){
            //request to be blocked
            //job have to be blocked when it is doing IO
            //or requested IO
            if(jobTable.get(stoppedJob).getDoingIO() || jobTable.get(stoppedJob).getRequestIO())
                jobTable.get(stoppedJob).setBlocked(true);
        }
        runJob(a,p);
    }
    
    public static void Tro(int[] a, int [] p, int index){
        //TODO Johnson
        bookkeeper(p[5]);
        /**
         * Timer run out
         * if job is not done in the time slice put it back in the memory queue
         * job must be terminated and memory freed up if job done and it is not waiting for IO 
         * or not doing IO
         * Also when memory freed up try to swap in new job
         */
        
        if(jobTable.get(index).getJobSize()  == 0)
        	//terminate()
        else
        	//Add to the end of the arraylist. 
        
        runJob(a,p);
    }
    
    public static int CPUScheduler(){
        //TODO Jonhson
        //will use Round robin for our CPU scheduling
        //return index of the job in the readyQueue to run
        //if there is no job to run return -1
    	int quantum = 5; 
    	
    	
    	while (jobTable.isEmpty != true){
    		for(int i = 0; i < 100000; i++){
    			if(jobTable.get(i).getJobSize() < quantum &&
    			   jobTable.get(i).getJobSize() != 0)
    				return jobTable.get(i); 
    		}
    	}
    	
    	
    	
    	
        return -1;
    }
    
    public static void swapper(){
        //TODO Philippe
        /**internal method that will swap from memory to the drum
         * if currently nothing swapping, do new swap into memory
         */
        if(!swapInProgress){
           
        }
    }
    public static int bookkeeper(int currTime){
        //TODO Philippe
        /**
         * function should calculate how much time interrupted job spend on CPU
         * time spend on CPU have to be subtracted from the maxCPUTime
         * function also return position of the job on the readyQueue that was interrupted
         * if no job was running, return -1;
         */
        return -1;
    }
    
    public static void runJob(int [] a, int [] p){
        //TODO Philippe
        /**
         * this function call CPUScheduler() to select job from readyQueue
         * that will be run on CPU
         * if there is no job to run CPU will IDLE
         * if there is job to run put job parameters into
         * a[0] = 1, p[2], p[3], p[4]
         * also time when job enter CPU have to be recorded
         */
    	
    	int index = CPUScheduler(); 
    	int quantum = 5;
    	
    	if(index != -1){
    		if(jobTable.get(index).getJobSize() < quatum){
    			a[0] = 2;
    			p[2] = jobTable.get(index).getAddress(); 
    			p[3] = jobTable.get(index).getJobSize(); 
    			p[4] = jobTable.get(index).getJobSize(); 
    			updateJobSize(index,quantum);
    			Tro(a,p,index);
    		}
    		else
    		{
    			a[0] = 2;
    			p[2] = jobTable.get(index).getAddress();
    			p[3] = jobTable.get(index).getJobSize();
    			p[4] = quatum; 
    			updateJobSize(index,quantum); 
    			Tro(a,p,index); 
    		
    		}
    	}
    }
    public static void runIO(){
        //TODO Philippe
        /**
         * if no job processing IO pick next to do IO
         * IO queue is empty function should do nothing
         * 
         */
        if(!processingIO){
            
        }
    }
    
    public static void terminateJob(int position){
        //TODO Philippe
        /**
         * accepts position of the job on the readyQueue that have to be terminated
         * freed up memory
         * delete job from readyQueue
         */
        
    }
    /**
     * function below will make code cleaner
     * and will prevent us from writing the same code over and over.
     * Anton will implement this functions
     */
    public static int findRunningJob(){
        /**
         * return index of running job on the readyQueue
         * otherwise return -1
         */
        for(int i = 0; i<jobTable.size();i++)
            if(jobTable.get(i).getRunning())
                return i;
        return -1;
    }
    public static int findJobDoingIO(){
        /**
         * return index of job doing IO on the readyQueue
         * otherwise return -1
         */
        for(int i = 0; i<jobTable.size();i++)
            if(jobTable.get(i).getDoingIO())
                return i;
        return -1;
    }
    public static int findJobNumber(int number){
        //accepts number of the job
        //return position of the job in the ready queue
        //if no such number return -1
        for(int i = 0; i<jobTable.size();i++)
            if(jobTable.get(i).getJobNumber() == number)
                return i;
        return -1;
    }

    public void updateJobSize(int index, int quantum){
    	int jobSize = jobTable.get(index).getJobSize();
    	int difference = quantum - jobSize;
    	
    	if(difference <= 0){
    		jobTable.get(index).setJobSize(0);
    	}
    	else
    		jobTable.get(index).setJobSize(difference);
    }
}

