package com.restutriew.suitmediaandroiddevelopertest;

import android.os.Parcel;
import android.os.Parcelable;

public class GuestModel implements Parcelable {
    String id;
    String email;
    String first_name;
    String last_name;
    String avatar;

    public GuestModel(String id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }



    protected GuestModel(Parcel in) {
        id = in.readString();
        email = in.readString();
        first_name = in.readString();
        last_name = in.readString();
        avatar = in.readString();
    }

    public static final Creator<GuestModel> CREATOR = new Creator<GuestModel>() {
        @Override
        public GuestModel createFromParcel(Parcel in) {
            return new GuestModel(in);
        }

        @Override
        public GuestModel[] newArray(int size) {
            return new GuestModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(email);
        parcel.writeString(first_name);
        parcel.writeString(last_name);
        parcel.writeString(avatar);
    }
}
