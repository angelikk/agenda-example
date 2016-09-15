package com.icom.agenda;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by angelicazavala on 15/09/16.
 */

public class ContactBean implements Parcelable {


    public static final Creator<ContactBean> CREATOR = new Creator<ContactBean>() {
        @Override
        public ContactBean createFromParcel(Parcel in) {
            return new ContactBean(in);
        }

        @Override
        public ContactBean[] newArray(int size) {
            return new ContactBean[size];
        }
    };
    private int id;
    private String name;
    private String telephone;
    private String mail;
    private String address;
    private String picture;
    public ContactBean() {
    }

    protected ContactBean(Parcel in) {
        id = in.readInt();
        name = in.readString();
        telephone = in.readString();
        mail = in.readString();
        address = in.readString();
        picture = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(telephone);
        parcel.writeString(mail);
        parcel.writeString(address);
        parcel.writeString(picture);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
