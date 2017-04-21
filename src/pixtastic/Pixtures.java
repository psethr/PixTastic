/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixtastic;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rachel
 */
@Entity
@Table(name = "PIXTURES")
@NamedQueries({
    @NamedQuery(name = "Pixtures.findAll", query = "SELECT p FROM Pixtures p"),
    @NamedQuery(name = "Pixtures.findById", query = "SELECT p FROM Pixtures p WHERE p.id = :id"),
    @NamedQuery(name = "Pixtures.findByCaption", query = "SELECT p FROM Pixtures p WHERE p.caption = :caption"),
    @NamedQuery(name = "Pixtures.findByComments", query = "SELECT p FROM Pixtures p WHERE p.comments = :comments"),
    @NamedQuery(name = "Pixtures.findByHashtags", query = "SELECT p FROM Pixtures p WHERE p.hashtags = :hashtags"),
    @NamedQuery(name = "Pixtures.findByLikes", query = "SELECT p FROM Pixtures p WHERE p.likes = :likes")})
public class Pixtures implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CAPTION")
    private String caption;
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "HASHTAGS")
    private String hashtags;
    @Column(name = "LIKES")
    private Integer likes;
    @JoinColumn(name = "PIXUSER", referencedColumnName = "ID")
    @ManyToOne
    private Pixusers pixuser;

    public Pixtures() {
    }

    public Pixtures(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Pixusers getPixuser() {
        return pixuser;
    }

    public void setPixuser(Pixusers pixuser) {
        this.pixuser = pixuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pixtures)) {
            return false;
        }
        Pixtures other = (Pixtures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pixtastic.Pixtures[ id=" + id + " ]";
    }
    
}
