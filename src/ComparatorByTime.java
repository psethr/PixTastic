
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seth
 */
public class ComparatorByTime implements Comparator<Picture>
{
    public int compare(Picture pic1, Picture pic2)
    {
        return (pic1.getTime()).compareTo(pic2.getTime());
    }
}
