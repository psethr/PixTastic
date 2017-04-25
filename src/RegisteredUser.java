
import java.io.Serializable;
import java.util.ArrayList;

public class RegisteredUser implements Serializable
{
    private String username;
    private String name;
    private String location;
    private String profilePic;
    private String bio;
    private boolean isRegistered;
    private ArrayList<Picture> al;
    private ArrayList<RegisteredUser> alFollowing;
    
    /**
     * Constructor to initialize a registered user
     * @param username username selected by user
     * @param name real name of user
     * @param location user's location
     * @param profilePic user's photo
     * @param bio user's profile biography 
     * @param isRegistered whether user is registered or not
     */
    public RegisteredUser(
            String username,
            String name,
            String location,
            String profilePic,
            String bio,
           boolean isRegistered)
    
    {
        this.username = username;
        this.name = name;
        this.location = location;
        this.profilePic = profilePic;
        this.bio = bio;
        this.isRegistered = isRegistered;
        al = new ArrayList<Picture>();
        alFollowing = new ArrayList<RegisteredUser>();
    }
    
    public RegisteredUser Owner(String uname, ArrayList<RegisteredUser> al)
    {
        RegisteredUser user = null;
        for (RegisteredUser ele : al)
        {
            if (uname.equals(ele.getUsername()))
            {
                user = ele;
            }
        }
        return user;
    }
    
    public boolean isOwner(String uname)
    {
        return (uname.equals(username));        
    }
    /**
     * Accessor method for username 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setting method for username
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
    * Accessor method for user's real name 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setting method to set name 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor method for location
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setting method for user's location
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Accessor method for profile picture
     * @return the profilePic
     */
    public String getProfilePic() {
        return profilePic;
    }

    /**
     * Setting method for profile photo
     * @param profilePic the profilePic to set
     */
    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    /**
     * Accessor method for bio
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * Setting method for user's profile bio
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * Boolean method for if user is registered or not
     * @return the isRegistered
     */
    public boolean isRegistered() {
        return isRegistered;
    }

    /**
     * Setting method for isRegistered boolean
     * @param isRegistered the isRegistered to set
     */
    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    /**
     * Accessor method for arraylist of registered users
     * @return the al
     */
    public ArrayList<Picture> getArraylist() {
        return al;
    }

    /**
     * Setting method for arraylist of registered users
     * @param al the al to set
     */
    public void setArratList(ArrayList<Picture> al) {
        this.al = al;
    }
    
    /**
     * Adding picture to profile 
     * @param pic 
     */
    public void addPicture(Picture pic) {
        al.add(pic);
    }

    /**
    * Getting list of user's followed 
     * @return the alFollowing
     */
    public ArrayList<RegisteredUser> getAlFollowing() {
        return alFollowing;
    }

    /**
     * Setting list of user's followed.
     * @param alFollowing the alFollowing to set
     */
    public void setAlFollowing(ArrayList<RegisteredUser> alFollowing) {
        this.alFollowing = alFollowing;
    }
    
    /**
     * Adding a follower
     * @param user
     */
    public void addFollower(RegisteredUser user) {
        alFollowing.add(user);
    }
    
    /**
     * 
     * @param list arraylist of registered users 
     * @return s sting 
     */
    public String toString(String list)
    {
        String s = "";
        if (list.equalsIgnoreCase("pic"))
        {
            for (Picture ele : al)
            {
                s += ele.getFPath()+",  ";
            }
        }
        else if (list.equalsIgnoreCase("follower"))
        {
            for (RegisteredUser ele : alFollowing)
            {
                s += ele.getUsername()+",  ";
            }
        }
        return s;
    }
    
    /**
     * Closing toString
     * @return string
     */
    public String toCloseString(){
       
        String s = " " + username + " " + " " + name + " " + " " + location 
                + " " + " " + profilePic + " " + " " + bio;
        return s;
    }
}
