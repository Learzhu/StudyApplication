package com.learzhu.study.studyapplication.smalldatabases;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Learzhu on 2016/10/19.
 * Realm 数据模型不可以继承自除了 RealmObject 以外的其它对象。
 * 你可以选择不声明默认无参数构造器，但是如果你声明了，那么该构造器必须为空构造器。这是目前 Realm 的一个限制。但你可以自由添加任意其它的构造器。
 */

public class Country extends RealmObject {
    /**
     * 设置主键
     */
    @PrimaryKey
    private String code;
    private String name;
    private int population;

    public Country() {
    }

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public Country(String code, String name, int population) {
        this.code = code;
        this.name = name;
        this.population = population;
    }


    public String getName() {
        return name;
    }

    /*设置一个类型为 RealmObject 的属性为空值（null）会清除该属性的引用，但并不会删除对应的 RealmObject。*/
    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Error:(58, 19) 错误: Only getters and setters should be defined in model classes
     * @return
     */
//    @Override
//    public String toString() {
//        return "Country{" +
//                "code='" + code + '\'' +
//                ", name='" + name + '\'' +
//                ", population=" + population +
//                '}';
//    }
}
