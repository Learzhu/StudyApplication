package com.learzhu.study.studyapplication.guava;

import android.graphics.Color;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.io.Files;
import com.google.common.primitives.Ints;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Learzhu
 * @version $Rev$
 * @time 2016/10/9 15:25
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$  15:25
 * @updateDes ${TODO}
 */
public class CollectionsUtils {
    private void newHashMap1() {
        Map<String, Map<Long, List<String>>> map = new HashMap<String, Map<Long, List<String>>>();
        Map<String, Map<Long, List<String>>> mMap = Maps.newHashMap();
//        Map<String, Map<Long, List<String>>> mMap1=newHashMap();
    }

    /**
     * 读取文件
     */
    private void readFile() {
        File mFile = new File(getClass().getResource("./test.txt").getFile());
        List<String> lines = null;
        try {
            lines = Files.readLines(mFile, Charsets.UTF_8);
            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void compare() {
        int compare = Ints.compare(5, 20);
    }

    private void convert() {
//        List<Integer> mList = Lists.listOf(1, 2, 3, 4);
//        List<Integer> mList = Lists.
//        int[] array2 = Ints.toArray(mList);
    }

    private void immutable() {
        ImmutableList<String> of = ImmutableList.of("a", "b");
    }

    private void charMatcher() {
//        CharMatcher.inRange('a', 'c').or(CharMatcher.inRange('b'));
    }


    private void split() {
        int[] numbers = {1, 2, 3, 4, 5};
        String mJoin1 = Joiner.on(";").join(Ints.asList(numbers));
        System.out.println(mJoin1);
        String mJoin = Ints.join(";", numbers);
        System.out.println(mJoin);
        System.out.println("-----------------");
        String mString = "aaa , bbbb,,,, ccc,";
        String[] splitString = mString.split(",");
        System.out.println(splitString.toString());
        for (String x : splitString
                ) {
            System.out.println(x);
        }
        System.out.println("------------");
        Iterable<String> mSplit = Splitter.on(",").omitEmptyStrings().trimResults().split(mString);
        for (String y :
                mSplit) {
            System.out.println(y);
        }
    }


    private boolean ifContain() {
        int[] array = {1, 2, 3, 4, 5};
        int a = 3;
        boolean result = false;
        for (int x :
                array) {
            if (a == x) {
                result = true;
            }
        }
        System.out.println(result);
        boolean mContains = Ints.contains(array, a);
        System.out.println(mContains);
        return result;
    }

    private void function() {
        Map<Thing, Integer> things = new HashMap<>();
        things.put(new Thing("a"), 10);
        things.put(new Thing("b"), 20);
//        Map userPriceMap = Maps.transformValues(things, new Function() {
//            double eurToUsd = 2;
//
//            @Override
//            public Object apply(Object input) {
//                return (Object(input * eurToUsd));
//            }
//        });
        Map userPriceMap = Maps.transformValues(things, new Function() {
            @Override
            public Object apply(Object input) {
                return "dd";
            }
        });
        String mA = (String) userPriceMap.get(new Thing("a"));
        System.out.println(mA);

        String mB = (String) userPriceMap.get(new Thing("b"));
        System.out.println(mB);

    }


//    private void filter() {
//        List<String> names = listOf("Aleksander", "Jaran", "Integrasco", "Guava", "Java");
//    }

//    private List<String> listOf(String... java) {
//        ArrayList<String> mObjects = Lists.newArrayList();
//
//        return Lists.newArrayList().add;
//    }

    class Thing {
        private int price;
        private String name;

        public Thing(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public Thing(String name) {
            this.name = name;
        }
    }

    private void set() {
    }

    private void testImmutableSet() {
        Collections.unmodifiableCollection(new ArrayList<Object>());
    }

    public static void main(String args[]) {
//        new CollectionsUtils().readFile();
//        System.out.println();
        CollectionsUtils mCollectionsUtils = new CollectionsUtils();
        mCollectionsUtils.split();
        System.out.println("-----------");
        mCollectionsUtils.ifContain();
        System.out.println("-----------");
        mCollectionsUtils.function();
        System.out.println("-----copy------");
        mCollectionsUtils.copy();
        System.out.println("-----collection------");
        mCollectionsUtils.collections();
    }

    ArrayList<String> topicList = new ArrayList<String>() {
        {
            for (int i = 0; i < 20; i++) {
                add(i, "top " + i);
            }
        }
    };
//    private static final List<Color> WEBSAFE_COLORS = new ArrayList<Color>() {
//        {
//            add(1,new Color(Color.BLACK));
//        }
//    };
//    private static final ImmutableSet<Color> GOOGLE_COLORS = ImmutableSet.<Color>builder().addAll(WEBSAFE_COLORS).add(new Color(1,2,2)).build();

    private void copy() {
        ImmutableSet<String> mStrings = ImmutableSet.of("a", "b");
        System.out.println(mStrings.toString());
        ImmutableList<String> copy = ImmutableList.copyOf(mStrings);
        System.out.println(copy.toString());
        System.out.println(mStrings.equals(copy));
    }

    /**
     * ”集合[set]概念的延伸，它的元素可以重复出现…与集合[set]相同而与元组[tuple]相反的是，Multiset元素的顺序是无关紧要的：Multiset {a, a, b}和{a, b, a}是相等的
     */
    private void multiset() {
        List<String> words = new ArrayList<String>() {
            {
                for (int i = 0; i < 20; i++) {
                    add(i, "top " + i);
                }
            }
        };
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String word :
                words) {
            Integer count = counts.get(word);
            if (count == null) {
                counts.put(word, 1);
            } else {
                counts.put(word, count + 1);
            }
        }
    }

    private void collections() {
        List<String> list = new ArrayList<>();
        List<String> list1 = Lists.newArrayList("aaa", "bbb");
        List<String> list2 = Lists.newArrayListWithCapacity(200);
        Map map = Maps.newHashMap();
        Multiset<String> multiset = HashMultiset.create();
        /*concatenated包括元素 1, 2, 3, 4, 5, 6*/
        Iterable<Integer> concatenated = Iterables.concat(Ints.asList(1, 2, 3), Ints.asList(4, 5, 6));
        String mLast = Iterables.getLast(list);
        System.out.println("last--" + mLast);
        String mOnlyElement = Iterables.getOnlyElement(list1);
        System.out.println("only--" + mOnlyElement);
        List<List<String>> mPartition = Lists.partition(list1, 2);
        System.out.println(mPartition.get(0).get(0) + mPartition.get(1).get(1));
    }

    /**
     * AbstractIterator继承了UnmodifiableIterator，所以禁止实现remove()方法。如果你需要支持remove()的迭代器，就不应该继承AbstractIterator。
     *
     * @param in
     * @return
     */
    private static Iterator<String> skipNulls(final Iterator<String> in) {
        return new AbstractIterator<String>() {
            @Override
            protected String computeNext() {
                while (in.hasNext()) {
                    String mNext = in.next();
                    if (mNext != null) {
                        return mNext;
                    }
                }
                return endOfData();
            }
        };
    }

    private void abstractSequentiallterator() {
        Iterator<Integer> test = new AbstractSequentialIterator<Integer>(1) {
            @Override
            protected Integer computeNext(Integer previous) {
                return (previous == 1 << 30) ? null : previous * 2;
            }
        };
    }
}
