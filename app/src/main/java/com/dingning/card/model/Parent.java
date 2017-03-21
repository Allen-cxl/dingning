package com.dingning.card.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Allen on 2016/12/13.
 */

public class Parent implements Parcelable {


    private String parent_id;
    private String parent_name;
    private String relation;
    private String parent_pic;
    private boolean isSelected;

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getParent_pic() {
        return parent_pic;
    }

    public void setParent_pic(String parent_pic) {
        this.parent_pic = parent_pic;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Parent() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.parent_id);
        dest.writeString(this.parent_name);
        dest.writeString(this.relation);
        dest.writeString(this.parent_pic);
        dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
    }

    protected Parent(Parcel in) {
        this.parent_id = in.readString();
        this.parent_name = in.readString();
        this.relation = in.readString();
        this.parent_pic = in.readString();
        this.isSelected = in.readByte() != 0;
    }

    public static final Creator<Parent> CREATOR = new Creator<Parent>() {
        @Override
        public Parent createFromParcel(Parcel source) {
            return new Parent(source);
        }

        @Override
        public Parent[] newArray(int size) {
            return new Parent[size];
        }
    };

    @Override
    public String toString() {
        return "Parent{" +
                "parent_id='" + parent_id + '\'' +
                ", parent_name='" + parent_name + '\'' +
                ", relation='" + relation + '\'' +
                ", parent_pic='" + parent_pic + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }
}
