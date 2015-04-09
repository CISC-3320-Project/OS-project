/**
 * Class will represent memory and functions on it.
 * Should be able to add to the memory
 * delete from the memory
 * find free space for job
 */
package osProject;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Anton
 */
public class MemoryManager {
    private final int MAX_SIZE = 100;
    private List<Integer> memory;
    
    public MemoryManager(){
        memory = new LinkedList<>();
        for(int i = 0; i<MAX_SIZE; i++)
            memory.add(0);
    }
    
    public void addToMemory(Job j){
        int sizeNeeded = j.getJobSize();
        boolean startAddSet = false;
        int startAdd = -1;
        int endAdd;
        //int space = 0;
        for(int i = 0; i<MAX_SIZE; i++){
            if(memory.get(i)==0 && startAddSet==false){
                startAdd = i;
                startAddSet = true;
                //space++;
            }
            if((memory.get(i)==1 && startAddSet) || i == 99){
                endAdd = i;
                if((endAdd-startAdd)>=sizeNeeded){
                    j.setAddress(startAdd);
                    j.setInMemory(true);
                    break;
                }
                else
                    startAddSet = false;
                
            }   
        }
        if(startAddSet)
            for(int i = j.getAddress(); i<j.getAddress()+j.getJobSize(); i++)
                memory.set(i, 1);
        
    }
    
    public void removeFromMemory(Job j){
        for(int i = j.getAddress(); i<j.getAddress()+j.getJobSize(); i++)
            memory.set(i, 0);
    }
    
    public String toString(){
        String s = new String();
        for(int i=0; i<MAX_SIZE; i++)
            s+=memory.get(i) + " ";
        return s;
    }


    public static void main(String [] args){
        MemoryManager mem = new MemoryManager();
        Job j = new Job(1,1,10,12,12);
        Job j1 = new Job(2,1,2,12,12);
        Job j2 = new Job(3,1,70,12,12);
        Job j3 = new Job(4,1,3,12,12);
        mem.addToMemory(j);
        mem.addToMemory(j1);
        mem.addToMemory(j2);
        System.out.println(mem.toString());
        mem.removeFromMemory(j1);
        System.out.println(mem.toString());
        mem.addToMemory(j3);
        System.out.println(mem.toString());
        //mem.removeFromMemory(j);
        //System.out.println(mem.toString());

    }
}
