package com.example.recyclerviewhomework;

import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {


    private String name;

    public UserInfo(String name) {
        this.name = name;
    }
    protected UserInfo(Parcel in) {
        name = in.readString();

    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public String getName()
    {
        return name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
