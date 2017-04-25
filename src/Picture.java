import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Picture
{
    private RegisteredUser owner;
    protected String filepath;  //filepath of the picture
    protected String caption; //caption attached to the picture
    protected String comments; //comments attached to the picture
    protected String hashtag; //hashtags assigned to the picture
    private ArrayList<String> likedBy;
    protected int likes; //number of likes associated with a picture
    protected LocalDateTime time;  //time a picture was 
    
    /**
    *  Default constructor to initialize a picture.
    *  @param f the pathway to the picture
    *  @param cap the caption for the picture
    *  @param com the comments attached to the picture
    *  @param h the hashtags attached to the picture
    *  @param l the number of likes a picture has
    */
    public Picture(String f, String cap, String com, String h, int l)
    {
        filepath = f;
        caption = cap;
        comments = com;
        hashtag = h;
        likes = l;
        time = LocalDateTime.now();
        owner = GUI.userLoggedIn;
        likedBy = new ArrayList<String>();
    }
    /**
     * Accessor method for file-path.
     * @return the file-path of a picture
     */
    public String getFPath()
    {
        return filepath;
    }
    /**
     * Setting file path to variable 
     * @param path 
     */
    public void setFPath(String path)
    {
        filepath = path;
    }
    /**
     * Accessor method for the caption.
     * @return the caption of a picture
     */
    public String getCaption()
    {
        return caption;
    }
    /**
     * Setting caption to variable 
     * @param captions 
     */
    public void setCaptions(String captions)
    {
        this.caption = captions;
    }
    /**
     * Accessor method for comments.
     * @return the comments of a picture
     */
    public String getComments()
    {
        return comments;
    }
    /**
     * Setting comments using a variable 
     * @param comments 
     */
    public void addComments(String comments)
    {
       this.comments = comments;
    }
    /**
     * Accessor method for hashtags.
     * @return the hashtags of a picture
     */
    public String getHashtag()
    {
        return hashtag;
    }
    /**
     * Setting hashtag to variable
     * @param tag 
     */
    public void setHashtag(String tag)
    {
        hashtag = tag;
    }
    /**
     * Accessor method for likes.
     * @return the number of likes a picture has
     */
    public int getLikes()
    {
        return likes;
    }
    /**
     * Increases the number of likes when the like button is clicked.
     * @return the new number of likes associated with a picture
     */
    public int addLikes(RegisteredUser user)
    {
        likes = likes + 1;
        getLikedBy().add(user.getUsername());
        return likes;
    }

    /**
     * Accessor method for user
     * @return the owner
     */
    public RegisteredUser getOwner() {
        return owner;
    }

    /**
     * Setting method for user
     * @param owner the owner to set
     */
    public void setOwner(RegisteredUser owner) {
        this.owner = owner;
    }
    
    /**
     * Accessor method for time 
     * @return time 
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Accessor method for likes from picture 
     * @return the likedBy
     */
    public ArrayList<String> getLikedBy() {
        return likedBy;
    }

    /**
     * Setting method for likes from a picture 
     * @param likedBy the likedBy to set
     */
    public void setLikedBy(ArrayList<String> likedBy) {
        this.likedBy = likedBy;
    }
}
