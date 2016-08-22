package com.learzhu.study.studyapplication.modle;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Learzhu
 * @version $Rev$
 * @time 2016/8/22 15:28
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$  15:28
 * @updateDes ${TODO}
 */
public class Man implements Parcelable {

    private int age;
    private String name;

    // 读数据进行恢复
    protected Man(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    // 用来创建自定义的Parcelable的对象
    public static final Creator<Man> CREATOR = new Creator<Man>() {
        @Override
        public Man createFromParcel(Parcel in) {
            return new Man(in);
        }

        @Override
        public Man[] newArray(int size) {
            return new Man[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    // 写数据进行保存
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
