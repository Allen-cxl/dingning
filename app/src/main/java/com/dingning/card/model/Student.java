package com.dingning.card.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Allen on 2016/12/13.
 */

public class Student implements Parcelable {

    private String student_name;
    private String student_id;

    @Override
    public String toString() {
        return "Student{" +
                "student_name='" + student_name + '\'' +
                ", student_id='" + student_id + '\'' +
                ", class_name='" + class_name + '\'' +
                ", class_id='" + class_id + '\'' +
                ", student_pic='" + student_pic + '\'' +
                ", parent=" + parent +
                '}';
    }

    private String class_name;
    private String class_id;
    private String student_pic;
    private List<Parent> parent;

    public String getStudent_name() {
        return student_name;
    }

    public List<Parent> getParent() {
        return parent;
    }

    public void setParent(List<Parent> parent) {
        this.parent = parent;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getStudent_pic() {
        return student_pic;
    }

    public void setStudent_pic(String student_pic) {
        this.student_pic = student_pic;
    }

    public Student() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.student_name);
        dest.writeString(this.student_id);
        dest.writeString(this.class_name);
        dest.writeString(this.class_id);
        dest.writeString(this.student_pic);
        dest.writeTypedList(this.parent);
    }

    protected Student(Parcel in) {
        this.student_name = in.readString();
        this.student_id = in.readString();
        this.class_name = in.readString();
        this.class_id = in.readString();
        this.student_pic = in.readString();
        this.parent = in.createTypedArrayList(Parent.CREATOR);
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
