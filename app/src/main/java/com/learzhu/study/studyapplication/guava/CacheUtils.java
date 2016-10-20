package com.learzhu.study.studyapplication.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

import java.security.Key;
import java.util.concurrent.TimeUnit;

/**
 * @author Learzhu
 * @version $Rev$
 * @time 2016/10/10 17:43
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$  17:43
 * @updateDes ${TODO}
 * <p>
 * Guava Cache适用于：
 * <p>
 * 你愿意消耗一些内存空间来提升速度。
 * 你预料到某些键会被查询一次以上。
 * 缓存中存放的数据总量不会超出内存容量。（Guava Cache是单个应用运行时的本地缓存。它不把数据存放到文件或外部服务器。如果这不符合你的需求，请尝试Memcached这类工具）
 * 如果你的场景符合上述的每一条，Guava Cache就适合你。
 * <p>
 * Guava Cache提供了三种基本的缓存回收方式：基于容量回收、定时回收和基于引用回收。
 */
public class CacheUtils {
    public static void main(String args[]) {
    }

//    private void test() {
//        LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
//                .maximumSize(1000)
//                .expireAfterWrite(10, TimeUnit.MINUTES)
//                .removalListener(MY_LISTENER)
//                .build(
//                        new CacheLoader<Key, Graph>() {
//                            public Graph load(Key key) throws AnyException {
//                                return createExpensiveGraph(key);
//                            }
//                        });
//    }

    private void cacheMap() {
//        cacheMap();
    }
}
