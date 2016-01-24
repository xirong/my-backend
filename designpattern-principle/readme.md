说明 
=======

这个目录用来汇总学习设计模式时的各种资料，欢迎 issue + PR，一起丰富。

------------


下面的综述介绍来自 [@guohongjun](https://github.com/guohongjun) 的 repo [DesignPattern-principle](https://github.com/guohongjun/DesignPattern-principle/blob/master/README.md) ，感谢作者的整理，在此借用下。

# DesignPattern-principle

关于设计模式原则，有的按照solid原则总结，有的说六原则，大家都总结的都不一致。学习了这位[仁兄](http://my.csdn.net/zhengzhb)的文章基础上，今天这里把我理解的设计模式几大原则给大家分享一下：

>* 单一职责原则
>* 开闭原则
>* 接口分离原则
>* 里氏代换原则
>* 依赖倒置原则
>* 迪米特原则 
>* 优先使用组合，而不是使用继承

## 单一职责原则
--------------------

> 定义：不要存在多于一个导致类变更的原因。通俗的说，即单一职责是说一个类或者一个方法，只做一件事，或者完成一个任务。

问题由来：类T负责两个不同的职责：职责Z1，职责Z2。当由于职责Z1需求发生改变而需要修改类T时，有可能会导致原本运行正常的职责Z2功能发生故障。

解决：遵循单一职责原则。分别建立两个类T1、T2，使T1完成职责Z1功能，T2完成职责Z2功能。这样，当修改类T1时，不会使职责Z2发生故障风险；同理，当修改T2时，也不会使职责Z1发生故障风险。

举例说明： 用一个类描述动物行走的

```java 
public class Animal {
		public void run(String str) {
			System.out.println("行走 " + str);
		}
	}
public class Client {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.run("牛");
		animal.run("羊");
	}
}
```

运行了一下后，发现不对哈。鱼等水生的动物是不能行走的,那么怎么办呢？所以我们要修改一下，遵循单一职责原则，让陆生动物使用 Terrestrial 这个类；而水生动物使用 Aquatic 这个类。

```java 
class Terrestrial{
		public void run(String animal){
			System.out.println(animal+"陆地行走");
		}
	}
class Aquatic{
		public void run(String animal){
			System.out.println(animal+"水中游行");
		}
	}
public class Client {
	public static void main(String[] args) {
		Terrestrial terrestrial = new Terrestrial();
		terrestrial.breathe("牛");
		terrestrial.breathe("羊");
		terrestrial.breathe("猪");

		Aquatic aquatic = new Aquatic();
		aquatic.breathe("鱼");
		}
	}	
```

遵循单一职责原的优点有：

>* 可以降低类的复杂度，一个类只负责一项职责，其逻辑肯定要比负责多项职责简单的多；
>* 提高类的可读性，提高系统的可维护性；
>* 变更引起的风险降低，变更是必然的，如果单一职责原则遵守的好，当修改一个功能时，可以显著降低对其他功能的影响。
>* 需要说明的一点是单一职责原则不只是面向对象编程思想所特有的，只要是模块化的程序设计，都适用单一职责原则。

## 开闭原则
--------------------

> 定义：是说软件实体（类、模块、函数等等）应该可以扩展，但是不可修改。
开闭原则的核心是：对扩展开放，对修改关闭。

**“可变性的封装原则”意味着两点：**

- 一种可变性不应当散落在代码的很多角落里，而应当被封装到一个对象里面。继承应当被看做是封装变化的方法，而不应当被认为是从一般的对象生成特殊的对象方法。
- 一种可变性不应当与另一种可变性混合在一起。所有的类图的继承结构一般不会超过两层，不然就意味着将两种不同的可变性混合在一起。

此处我借鉴了[花郎V](http://www.cnblogs.com/loulijun/archive/2012/03/14/2394055.html)这个仁兄的文章，很感谢哈。

```java
public interface IBoy {
		// 年龄
		public int getAge();

		// 姓名
		public String getName();

		// 长相
		public String getFace();

	}


	public class StrongerBoy implements IBoy {
		private String name;
		private int age;
		private String face;

		public StrongerBoy(String name, int age, String face, String figure) {
			this.name = name;
			this.age = age;
			this.face = face;
		}

		@Override
		public int getAge() {
			return age;
		}

		@Override
		public String getFace() {
			return face;
		}

		@Override
		public String getName() {
			return name;
		}
	}

	public class Mans {
		private final static ArrayList<IBoy> boys = new ArrayList<IBoy>();
		// 静态初始化块
		static {
			boy.add(new StrongerBoy("谢霆锋", 30, "帅气"));
			boy.add(new StrongerBoy("冯小刚", 60, "成熟"));
		}

		public static void main(String args[]) {
			System.out.println("----------美女在这里----------");
			for (IBoy boy : boys) {
				System.out.println("姓名:" + boy.getName() + " 年龄:"
						+ boy.getAge() + "  长相:" + boy.getFace());
			}
		}
	}
}

```

这个程序写的不错哈，我运行了一下，感觉不错。此时问题来了，如果要加个外国名人怎么办？修改 Iboy 这个接口吗，这样做就符合不了开闭原则了。所以，我这里想到了扩展，但是如何扩展呢？
可以定义一个 IForeigner 接口继承自 IBoy，在 IForeigner 接口中添加国籍属性 getCountry()，然后实现这个接口即可，然后就只需要在场景类中做稍微修改就可以了。

```java 

	public interface IForeigner extends IBoy {
		// 国籍
		public String getCountry();
	}
	
	public class ForeignerBoy implements IForeigner {  
	    private String name;  
	    private int age;  
	    private String country;  
	    private String face;  
	    private String figure;  
	       
	    public ForeignerBoy(String name, int age, String country, String face, String figure)  
	    {  
	        this.name = name;  
	        this.age = age;  
	        this.country = country;  
	        this.face =face;  
	        this.figure = figure;  
	    }  
	    @Override 
	    public String getCountry() {  
	        // TODO Auto-generated method stub  
	        return country;  
	    }  
	   
	    @Override 
	    public int getAge() {  
	        // TODO Auto-generated method stub  
	        return age;  
	    }  
	   
	    @Override 
	    public String getFace() {  
	        // TODO Auto-generated method stub  
	        return face;  
	    }  
	   
	    @Override 
	    public String getName() {  
	        // TODO Auto-generated method stub  
	        return name;  
	    }  
	   
	} 
	boys.add(new ForeignerBoy("richale",28,"美国","阳光")); 
```

设计原则是死的，也要根据实际的需求，我们要灵活使用这个开闭原则。


## 接口分离原则
--------------------

> 定义：客户端不应该依赖它不需要的接口，类间的依赖关系应该建立在最小的接口上。

通俗的说就是：接口中的方法要尽量的少，不要使接口过于臃肿，不要有过多不相关的逻辑方法。参考于[李天炜](http://tianweili.github.io/blog/2015/02/10/interface-segregation-principle/)的文章

```java 
public interface I {
    public void method1();
    public void method2();
    public void method3();
}
public class B implements I{
 
    @Override
    public void method1() {
        System.out.println("类B实现了接口I的方法1");
    }
 
    @Override
    public void method2() {
        System.out.println("类B实现了接口I的方法2");
    }
 
    @Override
    public void method3() {//类B并不需要接口I的方法3功能，但是由于实现接口I，所以不得不实现方法3
        //在这里写一个空方法
    }
}
public class D implements I{
 
    @Override
    public void method2() {
        System.out.println("类D实现了接口I的方法2");
    }
 
    @Override
    public void method3() {
        System.out.println("类D实现了接口I的方法3");
    }
 
    @Override
    public void method1() {//类D并不需要接口I的方法1功能，但是由于实现接口I，所以不得不实现方法1
        //在这里写一个空方法
    }
}
//类A通过接口I依赖类B
public class A {
    public void depend1(I i){
        i.method1();
    }
}
//类C通过接口I依赖类D
public class C {
    public void depend1(I i){
        i.method3();
    }
}
public class Client {
    public static void main(String[] args) {
        A a = new A();
        I i1 = new B();
        a.depend1(i1);
         
        C c = new C();
        I i2 = new D();
        c.depend1(i2);
    }
}
```

运行结果：

``` java
类B实现了接口I的方法1
类D实现了接口I的方法3
```

从以上代码可以看出，如果接口过于臃肿，不同业务逻辑的抽象方法都放在一个接口内，则会造成它的实现类必须实现自己并不需要的方法，这种设计方式显然是不妥当的。所以我们要修改上述设计方法，把接口I拆分成3个接口，使得实现类只需要实现自己需要的接口即可。只贴出修改后的接口和实现类的代码，修改代码如下：

```java 
public interface I1 {
    public void method1();
}
public interface I2 {
    public void method2();
}
public interface I3 {
    public void method3();
}
 
public class B implements I1,I2{
    @Override
    public void method1() {
        System.out.println("类B实现了接口I的方法1");
    }
 
    @Override
    public void method2() {
        System.out.println("类B实现了接口I的方法2");
    }
}
 
public class D implements I2,I3{
    @Override
    public void method2() {
        System.out.println("类D实现了接口I的方法2");
    }
 
    @Override
    public void method3() {
        System.out.println("类D实现了接口I的方法3");
    }
}
```

### 与单一职责原则的区别

到了这里，有些人可能觉得接口隔离原则与单一职责原则很相似，其实不然。

1. 单一职责原则注重的是职责；而接口隔离原则注重对接口依赖的隔离。

2. 单一职责原则主要是约束类，其次才是接口和方法，它针对的是程序中的实现和细节；而接口隔离原则主要约束接口，主要针对抽象，针对程序整体框架的构建。
3. 接口尽量小
4. 接口高内聚
5. 接口设计是有限度的

**注意事项：**

> 原则是软件大师们经验的总结，在软件设计中具有一定的指导作用，但不能按部就班哈。对于接口隔离原则来说，接口尽量小，但是也要有限度。对接口进行细化可以提高程序设计灵活性是不争的事实，但是如果过小，则会造成接口数量过多，使设计复杂化，所以一定要适度。


## 里氏代换原则
--------------------

里氏代换原则是由麻省理工学院（MIT）计算机科学实验室的Liskov女士，在1987年的OOPSLA大会上发表的一篇文章《[Data Abstraction and Hierarchy](http://www.rendezvouswithdestiny.net/index_files/LiskovSub.pdf)》里面提出来的，主要阐述了有关继承的一些原则，也就是什么时候应该使用继承，什么时候不应该使用继承，以及其中的蕴涵的原理。2002年，软件工程大师Robert C. Martin，出版了一本《[Agile Software Development Principles Patterns and Practices](http://book.douban.com/subject/1459003/)》，在文中他把里氏代换原则最终简化为一句话："Subtypes must be substitutable for their base types"，也就是说，子类必须能够替换成它们的基类。

>定义1：如果对每一个类型为 T1的对象 Object1，都有类型为 T2 的对象Object2，使得以 T1定义的所有程序 P 在所有的对象 Object1 都代换成 Object2 时，程序 P 的行为没有发生变化，那么类型 T2 是类型 T1 的子类型。

>定义2：所有引用父类的地方必须能正常地使用其子类的对象。

问题由来：有一功能P1，由类Superclass完成。现需要将功能P1进行扩展，扩展后的功能为P，其中P由原有功能P1与新功能P2组成。新功能P由类Superclass的子类Subclass来完成，则子类B在完成新功能P2的同时，有可能会导致原有功能P1发生故障。

解决方案：当使用继承时，遵循里氏替换原则。类Subclass继承类Superclass时，除添加新的方法完成新增功能P2外，尽量不要重写父类Superclass的方法，也尽量不要重载父类Superclass的方法。

不说没用营养的了，上代码：

``` java
public class Superclass {
		public int subtraction(int a, int b) {
			return a - b;
		}
	}
	public class Subclass extends Superclass {
		public int subtraction(int a, int b) {
			return a - b - 1;
		}
	}
	public class Client {
		public static void main(String[] args) {
			Subclass subclass = new Subclass();
			SuperClass supuerClass = new SuperClass();
			System.out.println("SuperClass +  "
					+ SuperClass.subtraction(10 - 5));
			System.out.println("subclass +  "+subclass.subtraction(10 - 5));
		}
	}
```

大家看一下上面的代码中子类可以代替父类，而不使原来的父类的计算功能不变吗？答案是否定的。
里氏替换原则通俗的来讲就是：子类可以扩展父类的功能，但不能改变父类原有的功能。它包含以下4层含义：

1. 子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法。
2. 子类中可以增加自己特有的方法。
3. 当子类的方法重载父类的方法时，方法的前置条件（即方法的形参）要比父类方法的输入参数更宽松。
4. 当子类的方法实现父类的抽象方法时，方法的后置条件（即方法的返回值）要比父类更严格。

## 依赖倒置原则
--------------------

> 定义：高层模块不应该依赖低层模块，二者都应该依赖其抽象；抽象不应该依赖细节；细节应该依赖抽象。编程应该依赖抽象，不应该依赖细节。

问题由来：类A直接依赖类B，假如要将类A改为依赖类C，则必须通过修改类A的代码来达成。这种场景下，类A一般是高层模块，负责复杂的业务逻辑；类B和类C是低层模块，负责基本的原子操作；假如修改类A，会给程序带来不必要的风险。

解决方案：将类A修改为依赖接口I，类B和类C各自实现接口I，类A通过接口I间接与类B或者类C发生联系，则会大大降低修改类A的几率。

依赖倒置原则的核心思想是面向接口编程，我们依旧用一个例子来说明面向接口编程比相对于面向实现编程好在什么地方。场景是这样的，母亲给孩子讲故事，只要给她一本书，她就可以照着书给孩子讲故事了。举个例子说明一下：

```java
class Book {
		public String getContent() {
			return "这个是一个关于毛主席的故事……";
		}
	}

	class Mother {
		public void read(Book book) {
			System.out.println("妈妈开始讲故事");
			System.out.println(book.getContent());
		}
	}

	public class Client {
		public static void main(String[] args) {
			Mother mother = new Mother();
			mother.read(new Book());
		}
	}
```

运行结果：

``` java
妈妈开始讲故事

这个是一个关于毛主席的故事……
```

运行良好，假如有一天，需求变成这样：不是给书而是给一份报纸，让这位母亲讲一下报纸上的故事，报纸的代码如下：

```java 
class NewsPaper {
		public String getContent() {
			return "中国篮球超人姚明……";
		}
	}

```

这位母亲就办不到，因为她居然不会读报纸上的故事，这太荒唐了，只是将书换成报纸，居然必须要修改Mother才能读。假如以后需求换成杂志呢？换成网页呢？还要不断地修改Mother，这显然不是好的设计。原因就是Mother与Book之间的耦合性太高了，必须降低他们之间的耦合度才行。

我们引入一个抽象的接口IReader。读物，只要是带字的都属于读物：

```java
public Interface IReader{
    public String getContent();
}
```
Mother类与接口IReader发生依赖关系，而Book和Newspaper都属于读物的范围，它们各自都去实现IReader接口，这样就符合依赖倒置原则了，代码修改为：

```java
	class Newspaper implements IReader {
		public String getContent() {
			return "中国篮球超人姚明……";
		}
	}

	class Book implements IReader {
		public String getContent() {
			return "这个是一个关于毛主席的故事……";
		}
	}

	class Mother {
		public void read(IReader reader) {
			System.out.println("妈妈开始讲故事");
			System.out.println(reader.getContent());
		}
	}

	public class Client {
		public static void main(String[] args) {
			Mother mother = new Mother();
			mother.read(new Book());
			mother.read(new Newspaper());
		}
	}
```

这样以后，妈妈就是万能的了，主要是读物，妈妈都可以讲给我了。

这样修改后，无论以后怎样扩展Client类，都不需要再修改Mother类了。这只是一个简单的例子，实际情况中，代表高层模块的Mother类将负责完成主要的业务逻辑，一旦需要对它进行修改，引入错误的风险极大。所以遵循依赖倒置原则可以降低类之间的耦合性，提高系统的稳定性，降低修改程序造成的风险。

采用依赖倒置原则给多人并行开发带来了极大的便利，比如上例中，原本Mother类与Book类直接耦合时，Mother类必须等Book类编码完成后才可以进行编码，因为Mother类依赖于Book类。修改后的程序则可以同时开工，互不影响，因为Mother与Book类一点关系也没有。参与协作开发的人越多、项目越庞大，采用依赖导致原则的意义就越重大。现在很流行的TDD开发模式就是依赖倒置原则最成功的应用。

传递依赖关系有三种方式，以上的例子中使用的方法是接口传递，另外还有两种传递方式：构造方法传递和setter方法传递，相信用过Spring框架的，对依赖的传递方式一定不会陌生。

在实际编程中，我们一般需要做到如下3点：

1. 低层模块尽量都要有抽象类或接口，或者两者都有。
2. 变量的声明类型尽量是抽象类或接口。
3. 使用继承时遵循里氏替换原则。

依赖倒置原则的核心就是要我们面向接口编程，理解了面向接口编程，也就理解了依赖倒置。


## 迪米特原则
--------------------

> 定义：也叫最少知道原则，如果两个类不必彼此直接通信，那么这两个类就不应放生直接的互相作用。如果其中一个类需要调用另一个类的某个方法的化，可以用使用第三者转发这个调用。

强调的前提：在类的结构设计上，每一个类都应当尽量降低成员的访问权限，也就是说，一个类包装好自己的private状态，不需要让别的类知道的字段或行为就不要公开。

根本思想是：强调类之间的松耦合，类之间的耦合越弱，越有利于复用，一个处在弱耦合的类被修改，不会对有关系的类造成波及。

```java
public class A {
		public B getB(String str) {
			return new B(str);
		}

		public void work() {
			B b = getB("李同学");
			C c = b.getC("谢霆锋");
			c.work();
		}
	}

	public class B {
		public String name;

		public B() {

		}

		public B(String name) {
			this.name = name;
		}

		public C getC(String name) {
			return new C(name);
		}
	}

	public class C {

		public String name;

		public C(String name) {
			this.name = name;
		}

		public void work() {
			System.out.println(name + "帮我把这件事做好了");
		}
	}
public class Client {
  public static void main(String[] args) {
      A a = new A("王同学");
      a.work();
  }
}
```

运行结果是：

``` java
谢霆锋帮我把这件事做好了。
```

运行结果正常，但是我们发现一个问题，A类与B类有关联，而A类与C类没有什么关联。C类出现在A类中是不是有点不合时宜呢？
看到这里很多人都会明白，这种场景在实际开发中是非常常见的一种情况。对象A需要调用对象B的方法，对象B有需要调用对象C的方法……就是常见的`getXXX().getXXX().getXXX()`……类似于这种代码。如果你发现你的代码中也有这样的代码，那就考虑下是不是违反迪米特法则，是不是要重构一下了。

修改一下该例子：

```java 

public class A {
    pubic A(){
    
    }
	public B getB(String str) {
		return new B(str);
	}

	public void work() {
		B b = getB("王同学");
		b.work();
	}
}

public class B {
	public String name;

	public B() {

	}
	public B(String name) {
		this.name = name;
	}
    public void work(){
        C c= getC(“谢霆锋”);
        c.work;
    }
	public C getC(String name) {
		return new C(name);
	}
}

public class C {
	public String name;
	public C(String name) {
		this.name = name;
	}
	public void work() {
			System.out.println(name + "帮我把这件事做好了");
		}
	}
public class Client {
  public static void main(String[] args) {
      A a = new A("王同学");
      a.work();
  }
}
```

运行结果如下：

``` java 
谢霆锋帮我把这件事做好了
```

上面代码只是修改了下类A和B的work方法，使之符合了迪米特法则：

- 类A只与最直接的朋友类B通信，不与类C通信；
- 类A只调用类B提供的方法即可，不用关心类B内部是如何实现的（至于B是怎么调用的C，这些A都不用关心）。

## 优先使用组合，而不是使用继承
--------------------

定义：这个就不用解释了吧，学习过面向对象编程的同学，都应该知道这个事。

** 组合：**
>通过创建一个由其他对象组合的对象来获得新功能的重用方法
新功能的获得是通过调用组合对象的功能实现的，有时又叫聚合。

例如：
一个对象拥有或者对另外一个对象负责并且两个对象有相同的生命周期。(GOF)
一个对象包含另一个对象集合
被包含对象对其他对象是不可见的并且只能从包含它的对象中访问的特殊组合形式
组合的优缺点

**优点**

- 被包含对象通过包含他们的类来访问
- 黑盒重用，因为被包含对象的内部细节是不可见的
- 很好的封装
- 每个类专注于一个任务
- 通过获得和被包含对象的类型相同的对象引用，可以在运行时动态定义组合的方式  

**缺点**

- 结果系统可能会包含更多的对象
- 为了使组合时可以使用不同的对象，必须小心的定义接口

**继承：**
> 通过扩展已实现的对象来获得新功能的重用方法
> 基类有用通用的属性和方法
> 子类提供更多的属性和方法来扩展基类


**优点**

- 新的实现很容易，因为大部分是继承而来的
- 很容易修改和扩展已有的实现

**缺点**

- 打破了封装，因为基类向子类暴露了实现细节
- 白盒重用，因为基类的内部细节通常对子类是可见的
- 当父类的实现改变时可能要相应的对子类做出改变
- 不能在运行时改变由父类继承来的实现

由此可见，组合比继承具有更大的灵活性和更稳定的结构，一般情况下应该优先考虑组合。只有当下列条件满足时才考虑使用继承：

- 子类是一种特殊的类型，而不只是父类的一个角色
- 子类的实例不需要变成另一个类的对象
- 子类扩展，而不是覆盖或者使父类的功能失效

实例
参见Effective Java第四章第14条
