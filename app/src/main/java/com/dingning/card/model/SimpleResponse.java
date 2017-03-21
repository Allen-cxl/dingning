package com.dingning.card.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/28
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class SimpleResponse implements Parcelable {

    public int status;
    public String info;

    public BaseResponse toLzyResponse() {
        BaseResponse lzyResponse = new BaseResponse();
        lzyResponse.status = status;
        lzyResponse.info = info;
        return lzyResponse;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.status);
        dest.writeString(this.info);
    }

    public SimpleResponse() {
    }

    protected SimpleResponse(Parcel in) {
        this.status = in.readInt();
        this.info = in.readString();
    }

    public static final Parcelable.Creator<SimpleResponse> CREATOR = new Parcelable.Creator<SimpleResponse>() {
        @Override
        public SimpleResponse createFromParcel(Parcel source) {
            return new SimpleResponse(source);
        }

        @Override
        public SimpleResponse[] newArray(int size) {
            return new SimpleResponse[size];
        }
    };
}