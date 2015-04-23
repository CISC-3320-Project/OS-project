/** * Should be able to add to the memory
 * delete from the memory
 * find free space for job
 */
//package osProject;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Anton
 */
//TODO Anton
public class MemoryManager {
    private final int MAX_SIZE = 100;
    private List<Integer> memory;
    
    public MemoryManager(){
        memory = new LinkedList<>();
        for(int i = 0; i<MAX_SIZE; i++)
            memory.add(0);
    }
    
    public boolean addToMemory(Job j){
        int sizeNeeded = j.getJobSize();
        boolean startAddSet = false;
        int startAdd = -1;
        int endAdd;
        //int space = 0;
        for(int i = 0; i<MAX_SIZE; i++){ //find spase in memory for job
            if(memory.get(i)==0 && startAddSet==false){
                startAdd = i;
                startAddSet = true;
            }
            if((memory.get(i)==1 && startAddSet) || i == 99){
                endAdd = i;
                if((endAdd-startAdd)>=sizeNeeded){ //check if right size for our job
                    j.setAddress(startAdd); //assign starting address for tis job
                    //j.setInMemory(true);
                    break;
                }
                else
                    startAddSet = false;
                
            }   
        }
        if(startAddSet){
            for(int i = j.getAddress(); i<j.getAddress()+j.getJobSize(); i++)
                memory.set(i, 1);
        return true;
        }
        return false;  
    }
    
    public void removeFromMemory(Job j){
        for(int i = j.getAddress(); i<j.getAddress()+j.getJobSize(); i++)
            memory.set(i, 0);
    }
}
