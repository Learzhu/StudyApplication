package com.learzhu.study.studyapplication.modle;

/**
 * @author Learzhu
 * @version $Rev$
 * @time 2016/8/22 17:13
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$  17:13
 * @updateDes ${TODO}
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉
 * <p>
 * 〈功能详细描述〉 数据类型序列化
 */
public class ParcelableType implements Parcelable {
    /**
     * int 类型
     */
    int age;
    /**
     * String 类型
     */
    String name;
    /**
     * boolean 注意该boolean的get和set方法
     **/
    boolean isGood;
    /**
     * boolean 类型
     **/
    boolean complete;
    /**
     * 数组
     **/
    private String[] ids;
    /**
     * 对象 [内部已经序列化]
     **/
    private Book bean;
    /**
     * list
     **/
    private ArrayList listBeans;

    /**
     * 默认构造方法
     */
    public ParcelableType() {
        // TODO Auto-generated constructor stub
    }

    public ParcelableType(Parcel in) {
        readFromParcel(in);
    }

    /***
     * 默认实现
     */
    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        /** int 写入 **/
        dest.writeInt(age);
        /** string 写入 **/
        dest.writeString(name);
        /** boolean 写入 **/
        dest.writeInt(isGood ? 1 : 0);
        /** boolean 写入 **/
        dest.writeInt(complete ? 1 : 0);
        /** 数组 写入 **/
        if (ids != null) {
            dest.writeInt(ids.length);
        } else {
            dest.writeInt(0);
        }
        dest.writeStringArray(ids);
        /** 对象 写入 **/
        dest.writeParcelable(bean, flags);
        /** list 写入 **/
        dest.writeList(listBeans);

    }

    @SuppressWarnings("unchecked")
    private void readFromParcel(Parcel in) {

        /** int 读出 */
        age = in.readInt();
        /** stirng 读出 */
        name = in.readString();
        /** boolean 读出 */
        isGood = (in.readInt() == 1) ? true : false;
        /** boolean 读出 */
        complete = (in.readInt() == 1) ? true : false;
        /** 数组 读出 */
        int length = in.readInt();
        ids = new String[length];
        in.readStringArray(ids);
        /** 对象 读出 */
        bean = in.readParcelable(Book.class.getClassLoader());
        /** list 读出 */
        listBeans = in.readArrayList(Book.class.getClassLoader());

    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ParcelableType createFromParcel(Parcel in) {
            return new ParcelableType(in);
        }

        public ParcelableType[] newArray(int size) {
            return new ParcelableType[size];
        }
    };

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

    /**
     * 功能描述:
     * <p>
     * 〈功能详细描述〉 fastJson解析时需要格式
     */
    public boolean isIsGood() {
        return isGood;
    }

    public void setIsGood(boolean isGood) {
        this.isGood = isGood;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public Book getBean() {
        return bean;
    }

    public void setBean(Book bean) {
        this.bean = bean;
    }

    public ArrayList getListBeans() {
        return listBeans;
    }

    public void setListBeans(ArrayList listBeans) {
        this.listBeans = listBeans;
    }

}
