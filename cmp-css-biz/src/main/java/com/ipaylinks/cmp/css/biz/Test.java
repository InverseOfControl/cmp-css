package com.ipaylinks.cmp.css.biz;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(1);
        set.add(5);
        set.add(3);

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(4);
        list.add(2);
        Collections.sort(list);

        for (Iterator it = set.iterator();it.hasNext();){
            System.out.println(it.next());
        }

        HashMap map = new HashMap();
        map.put(1,1);

        int h;
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

