package com.dingning.card.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Allen on 2016/12/16.
 */

public class MessageList implements Parcelable {

    private String total;
    private List<Message> messages;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "MessageList{" +
                "total='" + total + '\'' +
                ", messages=" + messages +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.total);
        dest.writeTypedList(this.messages);
    }

    public MessageList() {
    }

    protected MessageList(Parcel in) {
        this.total = in.readString();
        this.messages = in.createTypedArrayList(Message.CREATOR);
    }

    public static final Parcelable.Creator<MessageList> CREATOR = new Parcelable.Creator<MessageList>() {
        @Override
        public MessageList createFromParcel(Parcel source) {
            return new MessageList(source);
        }

        @Override
        public MessageList[] newArray(int size) {
            return new MessageList[size];
        }
    };
}
