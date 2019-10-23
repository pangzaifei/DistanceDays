package com.color.distancedays.sharelib.bean;

import android.os.Parcel;

/**
 * 分享的图片对象
 * Created by zhangk on 2018/8/22.
 */

public class ShareImageObject extends ShareObject{

  public String imageLocalPath; //图片下载在本地的路径
  public byte[] bitmap;

  public ShareImageObject(int shareType, int sharePlatform, String imageLocalPath) {
    super(shareType, sharePlatform);
    this.imageLocalPath = imageLocalPath;
  }

  public ShareImageObject(int shareType, int sharePlatform, byte[] bitmap) {
    super(shareType, sharePlatform);
    this.bitmap = bitmap;
  }


  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
    dest.writeString(this.imageLocalPath);
    dest.writeByteArray(this.bitmap);
  }

  protected ShareImageObject(Parcel in) {
    super(in);
    this.imageLocalPath = in.readString();
    byte[] byteArray = in.createByteArray();
    in.unmarshall(byteArray, 0, byteArray.length);
    this.bitmap = byteArray;
  }

  public static final Creator<ShareImageObject> CREATOR = new Creator<ShareImageObject>() {
    @Override
    public ShareImageObject createFromParcel(Parcel source) {
      return new ShareImageObject(source);
    }

    @Override
    public ShareImageObject[] newArray(int size) {
      return new ShareImageObject[size];
    }
  };
}
