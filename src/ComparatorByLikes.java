import java.util.*;
import java.time.LocalDateTime;


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
    * @return  ordered array list
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
            ct = -1;
        } 
        else if (likes1 < likes2)
        {
            ct = 1;
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
      
