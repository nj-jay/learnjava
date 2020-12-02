# java集合-List

java标准可自带的java.util包提供了集合类:Collection,它是除了Map外所有集合类的根接口。java的集合几个特点:实现了接口和实现类相互分离。支持泛型。java访问集合通过统一的方式-迭代器(iterator)。

java.util主要提供三种集合类

* List(有序列表)
* Set(无重复元素)
* Map(key-value)

## 写在前面

> 这方面的基础太重要了
>
> 基本就是写程序必不可少的东西
>
> 另外泛型这个特性，可以保证类型安全
>
> go中由于不支持泛型，造成这个语言争议很大
>
> 对于专门从事软件编程来说这个东西的确挺重要的
>
> 像python连变量类型都不用在意
>
> 它是弱类型语言,自然来说不用太关心其他的东西
>
> 或许这就是它受欢迎的原因吧
>
> 因为门槛低

## 使用List(建议参考官方api)

```java
List<String> list = new ArrayList<>();
list.add("A");
list.remove(int index); //return <E>
list.remove("A");//删除第一个出现的元素 return boolean
list.contains("C";//return boolean
list.get(int index);//return <E>
list.set(int index, E element);//return <E>
list.sort(Comparator c);//排序
list.clear();	
//List与Array相互转换
函数定义:public Object[] toArray()
Object[] array  =  list.toArray();
```

### 重写equals方法

```java
arrayList.add(new Student("nj"));

Student s = new Student("nj");

boolean c = arrayList.contains(s);


结果为false
不符合常规
重写equals方法即可
```

```java
@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }
//重新运行得到true
```

