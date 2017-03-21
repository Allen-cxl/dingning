package com.dingning.card.model;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Allen on 2016/12/30.
 */

public class ReadEvent implements Parcelable {

    public ReadEvent() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    protected ReadEvent(Parcel in) {
    }

    public static final Parcelable.Creator<ReadEvent> CREATOR = new Parcelable.Creator<ReadEvent>() {
        @Override
        public ReadEvent createFromParcel(Parcel source) {
            return new ReadEvent(source);
        }

        @Override
        public ReadEvent[] newArray(int size) {
            return new ReadEvent[size];
        }
    };
}
