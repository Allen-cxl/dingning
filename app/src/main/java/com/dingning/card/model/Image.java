package com.dingning.card.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Allen on 2016/12/14.
 */

public class Image implements Parcelable {

    public String getImg_url() {
        return img_url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "img_url='" + img_url + '\'' +
                '}';
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    private String img_url;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.img_url);
    }

    public Image() {
    }

    protected Image(Parcel in) {
        this.img_url = in.readString();
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
