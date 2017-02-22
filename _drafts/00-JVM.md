
# JVM 相关

## 7、Java中的四种引用类型
* 强引用  
    如果一个对象是强引用，那么它就不会被垃圾回收器回收。内存不足时，抛出OutOfMemoryError错误，使程序异常终止。如果想中断强引用和某个对象之间的关联，可以显示的将其设置为null，这样，JVM就可以在合适的时候进行垃圾回收。
* 软引用  
    如果内存空间足够，软引用就会一直存在；只有当内存不足时，才会被垃圾回收器回收。
* 弱引用  
    弱引用对象的声明周期更短，无论当前内存是否足够，只要被垃圾回收期检测到就会被回收。不过垃圾回收器是一个优先级较低的线程，所以并不一定能迅速发现弱引用对象。
* 虚引用  
    顾名思义，形同虚设，相当于没有引用，任何时候都可以被垃圾回收器回收。

## 9、编译器常量
公共静态不可变变量也就是我们所以说的编译器常量，这里的public是可选的。实际上这些变量在编译时会被替换掉，因为编译器知道这些变量的值，并且在运行时不会被更改。唯一需要注意的地方在于，如果引用了第三方包，替换包的时候如果值有变化，就要重新编译程序，不然程序中的值还是原来的包内的常量的值。

## 10、如何判断一个对象是否应该被垃圾回收

* 引用计数
* 对象可达性分析

当前虚拟机大部分使用对象可达性分析来判断。

## 11、垃圾回收算法

* 标记-清除  
    会暂停当前程序的运行；会产生大量的内存碎片
* 标记-复制  
    也会暂停当前程序；可用空间缩小为原来的一般，空间利用率低
* 标记-整理  
    也会暂停当前程序；非实时性的回收
* 分代回收  
    - 新生代  
        每次垃圾回收都有大量对象死去，使用标记-复制算法，另外因为死去的对象大概占比98%，所以不需要按照1:1来分配内存，而是划分为一块较大的Eden和两块较小的Survivor区域，大小为8:1。每次新生代可用区域为Eden加上其中一块Survivor区域，共90%的内存空间，这样只有10%内存被闲置。当存活的对象大于10%的内存空间，也就是Survivor内存空间不够用时，就将某些存活时间足够长的对象转移到老年代。
    - 老年代
        对于老年代来说，大部分对象都处于存活状态。如果一个大对象在老年代依然放不下，那就要在老年代使用标记-清除或者标记-整理算法来进行垃圾回收了。
    - 永久代

## 调用System.gc()会发生什么
通知GC开始工作，但是GC真正开始的时间不确定。

