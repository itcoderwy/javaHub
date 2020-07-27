Java获取反射的三种方法:
1. 通过new对象实现反射机制（ 对象.getClass() ）           //(对应第三个图的阶段)
2. 通过路径实现反射机制（ Class.forName("包名.类名") ）//一般用在配置文件当中
3. 通过类名实现反射机制 （ 类名.Class ）                       //对应在图的第一个阶段

在获取反射方法后最重要的是三点即--(成员变量,构造方法,成员方法)所以自己觉着这三个方法比较重要.下面分别列举:

1),成员变量在java对象时候是成员变量,在加载成class类的时候就变成了Field[] 数组 ,其中有两个重要的方法需要记住:(细分成四个)

Field getDeclaredField(String name)返回一个 Field对象，它反映此表示的类或接口的指定已声明字段 类对象。
Field[] getDeclaredFields()返回的数组 Field对象反映此表示的类或接口声明的所有字段 类对象。

Field getField(String name)返回一个 Field对象，它反映此表示的类或接口的指定公共成员字段 类对象。
Field[] getFields()返回包含一个数组 Field对象反射由此表示的类或接口的所有可访问的公共字段 类对象。

2),构造方法--------Constructor[]数组 
Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)返回一个 Constructor对象，该对象反映 Constructor对象表示的类或接口的指定 类函数。
Constructor<?>[] getDeclaredConstructors()返回一个反映 Constructor对象表示的类声明的所有 Constructor对象的数组 类 。

Constructor<T> getConstructor(类<?>... parameterTypes)返回一个 Constructor对象，该对象反映 Constructor对象表示的类的指定的公共 类函数。
Constructor<?>[] getConstructors()返回包含一个数组 Constructor对象反射由此表示的类的所有公共构造 类对象。

创建对象:
T newInstance()创建由此 类对象表示的类的新实例。
注:如果使用空参构造方法创建对象,操作可以简化:Class对象的newInstance方法.

3),成员方法--------Method[] 
方法 getMethod(String name, 类<?>... parameterTypes)返回一个 方法对象，它反映此表示的类或接口的指定公共成员方法 类对象。
方法[] getMethods()返回包含一个数组 方法对象反射由此表示的类或接口的所有公共方法 类对象，包括那些由类或接口和那些从超类和超接口继承的声明。

方法 getDeclaredMethod(String name, 类<?>... parameterTypes)返回一个 方法对象，它反映此表示的类或接口的指定声明的方法 类对象。
方法[] getDeclaredMethods()返回包含一个数组 方法对象反射的类或接口的所有声明的方法，通过此表示 类对象，包括公共，保护，默认（包）访问和私有方法，但不包括继承的方法。

执行方法:





干货:
  只有在上面这几个方法会了以后才可以做一些操作
  有一个重要的方法-----method.setAccessible(true);
这个方法不管是什么私有的还是什么  统统都可以改变对象的属性或者使用对象中的私有方法,也就是说这个方法设置成true,没什么不能改变的了

