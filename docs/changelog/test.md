# TEST
您不用在意这个，我在试验Markdown语法

TODO list
* 把v1ch04-v1ch08代码大都调通
  //进度 v1ch05-copyOfTest
* 继续学习集合、泛型列表
* 整合学习路线 加入spring的几篇文章
## tes2
* 按这个路线学到Spring的时候，找到SpringinAction5th，结果被带到坑里了，这本书第一部分直接说上springboot，看到第三章才发现路线被带偏了。还好回过神来重新审视了一下路线图，发现spring实战第四版才是适合这个路线的书，第一部分就是springcore。感谢大佬指点！
* 核心原则，少浪费时间多回报。方法是通过调整学习顺序
* 将多篇文章浓缩起来放到github

![](images/TODO_images/3223e801.png)

一周
## 1.泛型
## 泛型数组列表
ArrayList是一个有类型参数的泛型类。例如ArrayList<Employee>,在添加删除元素时，它能自动地调整数组容量，而不需要为此编写任何代码

### 声明数组列表
声明和构造一个保存Employee对象的数组列表
```java
Array<Employee> staff = new ArrayList<Employee>();
```

java10后，可以使用var关键字
```java
var staff = new ArrayList<Employee>();
```

不使用var关键字的话，也可以省去右边的类型参数
```java
Array<Employee> staff = new ArrayList<>();
```

* 如果使用var声明ArrayList,就不要使用菱形语法
```java
// not ok



