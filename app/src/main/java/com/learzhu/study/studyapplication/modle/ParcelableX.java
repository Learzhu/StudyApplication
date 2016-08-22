package com.learzhu.study.studyapplication.modle;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Learzhu
 * @version $Rev$
 * @time 2016/8/22 17:54
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$  17:54
 * @updateDes ${TODO}
 */
public class ParcelableX implements Parcelable {
    private ArrayList arrayList;

    protected ParcelableX(Parcel in) {
    }

    public static final Creator<ParcelableX> CREATOR = new Creator<ParcelableX>() {
        @Override
        public ParcelableX createFromParcel(Parcel in) {
            return new ParcelableX(in);
        }

        @Override
        public ParcelableX[] newArray(int size) {
            return new ParcelableX[size];
        }
    };

    public ArrayList getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public ParcelableX(ArrayList arrayList) {
        this.arrayList = arrayList;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
