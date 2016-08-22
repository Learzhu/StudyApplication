package com.learzhu.study.studyapplication.modle;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * @author Learzhu
 * @version $Rev$
 * @time 2016/8/22 15:51
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$  15:51
 * @updateDes ${TODO}
 */
public class Book implements Parcelable {
    private String bookName;
    private String author;
    private int publishDate;

    //    private ArrayList list;
    private ArrayList<String> list;

    protected Book(Parcel in) {
        bookName = in.readString();
        author = in.readString();
        publishDate = in.readInt();

        //如果元素数据是list类型的时候需要： list = new ArrayList<?> in.readList(list);
        // 否则会出现空指针异常.并且读出和写入的数据类型必须相同.如果不想对部分关键字进行序列化,
        // 可以使用transient关键字来修饰以及static修饰.
        list = new ArrayList<String>();
//        list = in.readList(list, Book.class.getClassLoader());
//        list = in.readArrayList(Book.class.getClassLoader());
        in.readList(list, Book.class.getClassLoader());
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public Book() {
    }

//    public Book(String bookName, String author, int publishDate) {
//        this.bookName = bookName;
//        this.author = author;
//        this.publishDate = publishDate;
//    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookName);
        dest.writeString(author);
        dest.writeInt(publishDate);
        dest.writeList(list);
    }

//    @Override
//    public String toString() {
//        return "Book{" +
//                "bookName='" + bookName + '\'' +
//                ", author='" + author + '\'' +
//                ", publishDate=" + publishDate +
//                '}';
//    }


    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                ", list=" + list +
                '}';
    }
}
