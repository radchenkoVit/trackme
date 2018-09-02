package com.treavit.backend.system.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @Column(name = "user_id")
//    @GeneratedValue(generator="gen")
//    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="user"))
    private Long userId;

    @Lob
    @Column(name = "image_data")
    private byte[] image;

//    @OneToOne TODO: Taras, tries to link tables -> failed
//    @PrimaryKeyJoinColumn
//    private User user;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Image{" +
                "userId=" + userId +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
