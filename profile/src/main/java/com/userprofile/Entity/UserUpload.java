package com.userprofile.Entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="UserUpload")
public class UserUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    public UserUpload() {
        super();
    }
        String image_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }

    String image_url;
    @Temporal(TemporalType.DATE)
    @CreatedDate
    Date date;
    String description;
    String tag[];


    public NewUser getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "UserUpload{" +
                "id=" + id +
                ", image_name='" + image_name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", tag=" + Arrays.toString(tag) +
                ", userId=" + userId +
                '}';
    }

    public UserUpload(int id, String image_name, String image_url, Date date, String description, String[] tag, NewUser userId) {
        this.id = id;
        this.image_name = image_name;
        this.image_url = image_url;
        this.date = date;
        this.description = description;
        this.tag = tag;
        this.userId = userId;
    }

    public void setUserId(NewUser userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id_ID")
    NewUser userId;

}
