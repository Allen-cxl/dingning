package com.dingning.card.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Allen on 2016/12/15.
 */

public class StudentNotice implements Parcelable {

    private String student_id;
    private String rid;
    private String type;
    private String message;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "StudentNotice{" +
                "student_id='" + student_id + '\'' +
                ", rid='" + rid + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public StudentNotice() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.student_id);
        dest.writeString(this.rid);
        dest.writeString(this.type);
        dest.writeString(this.message);
    }

    protected StudentNotice(Parcel in) {
        this.student_id = in.readString();
        this.rid = in.readString();
        this.type = in.readString();
        this.message = in.readString();
    }

    public static final Creator<StudentNotice> CREATOR = new Creator<StudentNotice>() {
        @Override
        public StudentNotice createFromParcel(Parcel source) {
            return new StudentNotice(source);
        }

        @Override
        public StudentNotice[] newArray(int size) {
            return new StudentNotice[size];
        }
    };
}
