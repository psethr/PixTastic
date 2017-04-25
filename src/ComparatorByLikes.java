import java.util.*;
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Compares picture posts by number of likes
 * 
 */
public class ComparatorByLikes implements Comparator<Picture>
{
   /**
    * 
    * @param a picture post 
    * @param b another picture post
    * @return 
    */
    @Override
    public int compare(Picture a, Picture b)
    {
        int ct = 0;
        int likes1 = a.getLikes();
        int likes2 = b.getLikes();
        LocalDateTime time1 = a.getTime();
        LocalDateTime time2 = b.getTime();
        
        if (likes1 > likes2)
        {
            ct = 1;
        } 
        else if (likes1 < likes2)
        {
            ct = -1;
        }
        else if (likes1 == likes2)
        {
            ct = 1;
//            if (time1.compareTo(time2) > 0)
//            {
//                ct = 1;
//            }
//            else if (time1.compareTo(time2) < 0)
//            {
//                ct = -1;  
//            }
        
        }
    return ct;
    }
    
}
      
