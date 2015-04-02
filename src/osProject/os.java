package osProject;

/**
 *
 * @author Anton
 */
public class os {
    //declare all nesseccary variables here
    
    public static void startup (){
        //the first function called by SOS
        //intialize variables here so it will be visible for SOS
    }
    
    public static void Crint(int [] a, int [] p){
        //when new job come into system SOS call this function
        //so this function should take care of saving all information about job
    }
    
    public static void Dskint(int [] a, int[] p){
        //notify that I/O was completed
        //not sure what this function shoud do. Have to clarify
        
    }
    
    public static void Drint(int[] a, int[] p){
        //trasfer between drum and memory completed
    }
    
    public static void Svc (int[] a, int [] p){
        /**
        function handle service request
        should have 3 main IF statements, each for particular situation
        1st IF - job terminated (probably freed memory and change status of the job)
        2nd IF - job requesting I/O (put job in I/O queue and call function for handling I/O)
        3rd IF - blocks job until it finishes its I/O
        **/
    }
    
    public static void Tro(int[] a, int [] p){
        /**
         * Timer run out
         * if job is not done in the time slice put it back in the memory queue
         * if job done terminate it
         */
    }
    /*
    this is basic structure of OS. 
    More function will be added to this file or new classes will be created
    such as memoryManagment(), CPUScheduler(), timeManager(), dispatcher, swapper()
    */
    
}
