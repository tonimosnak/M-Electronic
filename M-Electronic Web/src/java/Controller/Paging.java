package Controller;

import java.util.ArrayList;
import java.util.List;

public class Paging {
    
    private double counter;
    private double perPage = 4.0;
    

    public List paging(List list, int pageLink){
        List<Integer> paging = new ArrayList();
            
        this.counter = 0.0;

        for(Object countingProducts : list){
            counter++;
        }
        
        double perPageCounter = this.counter / this.perPage;
            
        for(int i = 1; i <= Math.ceil(perPageCounter); i++){
            if(i == pageLink){
                paging.add(i);
                if(perPageCounter  - 1 > pageLink){
                    paging.add(i + 1 );
                    if(perPageCounter - 2 > pageLink){
                        paging.add(i + 2);
                    }
                }
            }
            
        }
        
        return paging;
    }
    
    public int lastPage(){
        double maxPage = Math.ceil(this.counter / this.perPage);
        int lastPage =(int) maxPage;
        return lastPage;
    }
}
