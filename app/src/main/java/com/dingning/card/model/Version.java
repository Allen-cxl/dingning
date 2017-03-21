package com.dingning.card.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Allen on 2016/12/20.
 */

public class Version implements Parcelable {

    public static final int UPDATE_FALSE = 0;  //现在不用更新
    public static final int UPDATE_TRUE= 1;  //现在必须更新

    private String version_name;
    private int version_code;
    private String content;
    private String url;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public int getVersion_code() {
        return version_code;
    }

    public void setVersion_code(int version_code) {
        this.version_code = version_code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Version{" +
                "version_name='" + version_name + '\'' +
                ", version_code=" + version_code +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.version_name);
        dest.writeInt(this.version_code);
        dest.writeString(this.content);
        dest.writeString(this.url);
        dest.writeInt(this.type);
    }

    public Version() {
    }

    protected Version(Parcel in) {
        this.version_name = in.readString();
        this.version_code = in.readInt();
        this.content = in.readString();
        this.url = in.readString();
        this.type = in.readInt();
    }

    public static final Creator<Version> CREATOR = new Creator<Version>() {
        @Override
        public Version createFromParcel(Parcel source) {
            return new Version(source);
        }

        @Override
        public Version[] newArray(int size) {
            return new Version[size];
        }
    };
}
