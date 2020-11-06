package com.example.practicerecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonInfo implements Parcelable {
    private String name;
    private Integer age;
    private String image;
    public PersonInfo(String name, Integer age,String image) {
        this.name = name;
        this.age = age;
        this.image = image;

    }

    protected PersonInfo(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0) {
            age = null;
        } else {
            age = in.readInt();
        }
        image = in.readString();
    }

    public static final Creator<PersonInfo> CREATOR = new Creator<PersonInfo>() {
        @Override
        public PersonInfo createFromParcel(Parcel in) {
            return new PersonInfo(in);
        }

        @Override
        public PersonInfo[] newArray(int size) {
            return new PersonInfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        if (age == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(age);
        }
        dest.writeString(image);
    }
}
