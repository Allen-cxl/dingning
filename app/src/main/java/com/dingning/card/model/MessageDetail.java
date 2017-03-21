package com.dingning.card.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Allen on 2016/12/14.
 */

public class MessageDetail implements Parcelable {

    private String content;     //叮咛内容
    private String voice_url;   //语音url
    private String voice_time;  //语音时间
    private String video_url;   //视频url
    private String add_time;    //添加时间
    private List<Image> imgs;   //图片

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVoice_url() {
        return voice_url;
    }

    public void setVoice_url(String voice_url) {
        this.voice_url = voice_url;
    }

    public String getVoice_time() {
        return voice_time;
    }

    public void setVoice_time(String voice_time) {
        this.voice_time = voice_time;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public List<Image> getImgs() {
        return imgs;
    }

    public void setImgs(List<Image> imgs) {
        this.imgs = imgs;
    }

    @Override
    public String toString() {
        return "MessageDetail{" +
                "content='" + content + '\'' +
                ", voice_url='" + voice_url + '\'' +
                ", voice_time='" + voice_time + '\'' +
                ", video_url='" + video_url + '\'' +
                ", add_time='" + add_time + '\'' +
                ", imgs=" + imgs +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.content);
        dest.writeString(this.voice_url);
        dest.writeString(this.voice_time);
        dest.writeString(this.video_url);
        dest.writeString(this.add_time);
        dest.writeTypedList(this.imgs);
    }

    public MessageDetail() {
    }

    protected MessageDetail(Parcel in) {
        this.content = in.readString();
        this.voice_url = in.readString();
        this.voice_time = in.readString();
        this.video_url = in.readString();
        this.add_time = in.readString();
        this.imgs = in.createTypedArrayList(Image.CREATOR);
    }

    public static final Parcelable.Creator<MessageDetail> CREATOR = new Parcelable.Creator<MessageDetail>() {
        @Override
        public MessageDetail createFromParcel(Parcel source) {
            return new MessageDetail(source);
        }

        @Override
        public MessageDetail[] newArray(int size) {
            return new MessageDetail[size];
        }
    };
}
