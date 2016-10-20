package com.learzhu.study.studyapplication.guava;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.google.common.io.Files;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.Futures;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * @author Learzhu
 * @version $Rev$
 * @time 2016/10/9 19:04
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$  19:04
 * @updateDes ${TODO}
 */
public class BasicUtilities {
    /**
     * null的特殊判断
     * <p/>
     * Optional无意直接模拟其他编程环境中的”可选” or “可能”语义，但它们的确有相似之处。
     * 使用Optional的意义在哪儿？
     * <p/>
     * 使用Optional除了赋予null语义，增加了可读性，最大的优点在于它是一种傻瓜式的防护。Optional迫使你积极思考引用缺失的情况，因为你必须显式地从Optional获取引用。直接使用null很容易让人忘掉某些情形，尽管FindBugs可以帮助查找null相关的问题，但是我们还是认为它并不能准确地定位问题根源。
     * <p/>
     * 如同输入参数，方法的返回值也可能是null。和其他人一样，你绝对很可能会忘记别人写的方法method(a,b)会返回一个null，就好像当你实现method(a,b)时，也很可能忘记输入参数a可以为null。将方法的返回类型指定为Optional，也可以迫使调用者思考返回的引用缺失的情形。
     */
    private void aboutNull() {
        Optional<Integer> possible = Optional.of(5);
        boolean mPresent = possible.isPresent();
        Integer mInteger = possible.get();
        System.out.println("aboutNull()--" + mPresent + mInteger);
    }

    /**
     * 预判的参数对错
     *
     * @param i
     * @param j
     */
    private void checkArg(int i, int j) {
//        Preconditions.checkArgument(i > 0, "Argument was %s but expected nonnegative", i);
        Preconditions.checkArgument(isSmaller(i, j), "Argument was %s but expected nonnegative", i);
        Preconditions.checkArgument(i < j, "Expected i < j, but %s > %s", i, j);
    }

    private boolean isBiger(int i, int j) {
        return i > j ? true : false;
    }

    private boolean isSmaller(int i, int j) {
        return i < j ? true : false;
    }

    /**
     * 。。。可以是没有参数的
     *
     * @param args
     * @return
     */
    private boolean isEqual(String... args) {
        if (args.length == 1 || args.length == 0) {
            return false;
        } else {
            return Objects.equals(args[0], args[1]);
        }
    }

    private boolean isEqual() {
//        return Objects.equals("a", "a");
        return Objects.equals(null, null);
    }

    private void toString1() {
        // Returns "ClassName{x=1}"
        com.google.common.base.Objects.toStringHelper(this).add("x", 1).toString();
        // Returns "MyObject{x=1}"
        String mS = com.google.common.base.Objects.toStringHelper("MyHelper").add("x", 1).toString();
        String ms = MoreObjects.toStringHelper("MyHelper").add("", 10).toString();
        System.out.println(ms);
    }

    private void compareTo() {

    }

    public static void main(String args[]) throws IOException {
        BasicUtilities mBasicUtilities = new BasicUtilities();
        mBasicUtilities.aboutNull();
        System.out.println("----------------");
//        mBasicUtilities.checkArg(-1, -1);
        mBasicUtilities.checkArg(1, 2);
        System.out.println("----------------");
        boolean mEqual = mBasicUtilities.isEqual();
        System.out.println("isEqual" + mEqual);
        System.out.println("".equals(null));
        System.out.println("----------------");
        mBasicUtilities.toString1();
        System.out.println("----------------");
        mBasicUtilities.testCompare();
        System.out.println("----------ordering------");
        mBasicUtilities.ordering("a", "b");
        System.out.println("----------testFoo------");
        mBasicUtilities.testFoo();
        System.out.println("----------ording1------");
        mBasicUtilities.ording1();
        System.out.println("----------testThrow------");
        mBasicUtilities.testThrowables();
    }

    private void testCompare() {
        Person mPerson0 = new Person(0, "A", "B");
        Person mPerson1 = new Person(0, "A", "B");
        System.out.println("person compare" + mPerson0.compareTo(mPerson1));
        System.out.println("person compare1" + mPerson0.compareTo1(mPerson1));
    }

    class Person implements Comparable<Person> {
        private String lastName;
        private String firstName;
        private int zipCode;

        public Person(int zipCode, String firstName, String lastName) {
            this.zipCode = zipCode;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Person() {
        }

        @Override
        public int compareTo(Person another) {
            int equal = lastName.compareTo(another.lastName);
            if (equal != 0) {
                return equal;
            }
            equal = firstName.compareTo(another.firstName);
            if (equal != 0) {
                return equal;
            }
            return Integer.compare(zipCode, another.zipCode);
        }

        /**
         * 链式
         *
         * @param another
         * @return
         */
        public int compareTo1(Person another) {
            return ComparisonChain.start().compare(this.lastName, another.lastName).compare(this.firstName, another.firstName).compare(this.zipCode, another.zipCode).result();
        }
    }

    public void order() {
        Ordering<Person> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<Person, Comparable>() {
            @Override
            public Comparable apply(Person input) {
                return null;
            }
        });
    }

    public void ordering(String left, String right) {
        Ordering<String> ordering = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };
        int mCompare = ordering.compare(left, right);
        System.out.println("Ordering--" + mCompare);
    }

    public void ording1() {
        Integer mMin = Ordering.natural().usingToString().min(1, 20);
        System.out.println("ordering1" + mMin);
    }

    public void testFoo() {
        Foo foo = new Foo(null, 0);
        System.out.println(foo.toString());
    }

    class Foo {
        @NonNull
        String sortBy;
        @NonNull
        int notSortedBy;

        //        public Foo(String sortBy, @NonNull int notSortedBy) {
//            this.sortBy = sortBy;
//            this.notSortedBy = notSortedBy;
//        }
        public Foo(@NonNull String sortBy, @NonNull int notSortedBy) {
            this.sortBy = sortBy;
            this.notSortedBy = notSortedBy;
        }
    }
//    class Foo {
//        @Nullable
//        String sortBy;
//        @NonNull
//        int notSortedBy;
//
////        public Foo(String sortBy, @NonNull int notSortedBy) {
////            this.sortBy = sortBy;
////            this.notSortedBy = notSortedBy;
////        }
//        public Foo(@NonNull String sortBy, @NonNull int notSortedBy) {
//            this.sortBy = sortBy;
//            this.notSortedBy = notSortedBy;
//        }
//    }

    private void testThrowables() throws IOException {
        File mFile = new File(getClass().getResource("/test.txt").getFile());
        List<String> lines = null;
        try {
            lines = Files.readLines(mFile, Charsets.UTF_8);
            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable t) {
            Throwables.propagateIfInstanceOf(t, IOException.class);
//            Throwables.propagateIfInstanceOf(t, SQLException.class);
            throw Throwables.propagate(t);
        }
    }
}


