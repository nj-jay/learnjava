package com.nj_jay.collection.list;
import java.util.*;

public class ListDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        //List重写了toString方法
        System.out.println(list);
        System.out.println("=====remove index of 0=====");
        list.remove(0);
        System.out.println(list);
        System.out.println("=====remove element======");
        boolean c = list.remove("C");
        if (c) {

            System.out.println("删除成功");

        }


        System.out.println("=========");

        //一般来说使用上面的方式去创建一个ArrayList对象
        //只有用到ArrayList特有的方法的时候才会用下面的方式
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        System.out.println(arrayList);

        //ArrayList的特有方法
        //这时，trimToSize() 方法可以删除未分配的空间
        // 并更改 ArrayList 的容量 使其等于 ArrayList 中的元素个数。
        arrayList.trimToSize();
        System.out.println(arrayList.size());

        //遍历-> 推荐方式
        System.out.println("==========");
        System.out.println("遍历list->推荐方式");
        for (String s : list) {

            System.out.println(s);

        }

        //遍历-> 不推荐
        System.out.println("========");
        System.out.println("遍历list-> 不推荐方式");
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i));

        }

        //最高效的方式,与方式一相同,只不过方式一简化使用了　for-each
        //自动变成该方式-> Iterator
        //推荐使用第一种方式
        System.out.println("========");
        System.out.println("原始高效方式");
        System.out.println("推荐第一种方式");
        for (Iterator<String> it = list.iterator(); it.hasNext();) {

            String s = it.next();

            System.out.println(s);

        }

        System.out.println("========");
        System.out.println("指定位置添加元素");
        System.out.println("list:" + list);
        list.add(0, "A");
        System.out.println("====添加后====");
        System.out.println(list);

        System.out.println("=======List与Array相互转换");

        Object[] array = list.toArray();
        System.out.println(list.getClass().getName());
        System.out.println(array.getClass().getName());
        System.out.println(array[0]);
        System.out.println(list.get(0));
        System.out.println(Arrays.toString(array));

        System.out.println("=====sort=====");

        arrayList.sort(Comparator.reverseOrder());

        System.out.println(arrayList);

        System.out.println("=====clear=====");
        arrayList.clear();
        System.out.println(arrayList);
    }

}
