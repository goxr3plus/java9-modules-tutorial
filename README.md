# Java 9 ++ modules full tutorial
#### Everything is tested with JDK 11.0.3
![Logging-Sins-793x397](https://user-images.githubusercontent.com/20374208/58885740-674c4900-86eb-11e9-9448-b0af3d8b52c0.png)
### Complety PDF with tutorial [download](https://github.com/goxr3plus/java9-modules-tutorial/files/3256292/JPMS.PDF)

I tried to make a simple yet fun, including code examples and pictures tutorial about a **hot and important topic** which is JPMS([**Java Platform Module System**](https://en.wikipedia.org/wiki/Java_Platform_Module_System)) which came in Java 9.

- **Contents**
  - [**Simple module**](#1)
  - [**Optional**](#2)
  - [**Transitive**](#3)
  - [**Cyclic**](#4)
  - [**Qualified Exports**](#5)
  - [**Observable**](#6)
  - [**Aggregator**](#7)
  - [**Module Graph**](#8)
  - [**Package Naming Conflicts**](#9)
  - [**Module Resolution Process**](#10)
  

Highly based on  [ java-9-new-features-in-simple-way-jshell-jpms-and-more ](https://www.udemy.com/java-9-new-features-in-simple-way-jshell-jpms-and-more/) and [Jenkov Tutorials](http://tutorials.jenkov.com/java/modules.html)

![chrome_2019-06-05_11-35-10](https://user-images.githubusercontent.com/20374208/58942200-fd34b200-8785-11e9-8f9c-dcb1aec1cf24.png)

![chrome_2019-06-05_11-39-19](https://user-images.githubusercontent.com/20374208/58942502-906de780-8786-11e9-98e7-4d5f070053c5.png)

---

![chrome_2019-06-05_11-41-00](https://user-images.githubusercontent.com/20374208/58942638-cf9c3880-8786-11e9-8ddd-76c120c49d6f.png)

<a name="1"></a>
---
# 1. ------------------- Simple module -------------------

![chrome_2019-06-05_11-43-36](https://user-images.githubusercontent.com/20374208/58942863-433e4580-8787-11e9-829d-cda9256aaef9.png)
![chrome_2019-06-05_14-47-44](https://user-images.githubusercontent.com/20374208/58954143-f9faef80-87a0-11e9-8e8c-452c2511be3f.png)
![chrome_2019-06-05_14-47-58](https://user-images.githubusercontent.com/20374208/58954144-f9faef80-87a0-11e9-8cfd-7376aa3816dd.png)

##### Ps i have provided all the code in folders so you don't have to manually type it ;
  Compile :
  
  ``` JAVA
  javac --module-source-path simple_module -d out1 -m moduleA
  ``` 

  Run :
  
  ``` JAVA
  java --module-path out1 -m moduleA/pack1.Main
  ```
<a name="2"></a>
---
# 2. ------------------- Optional -------------------

![chrome_2019-06-05_13-44-20](https://user-images.githubusercontent.com/20374208/58950802-3e35c200-8798-11e9-816b-f8305c705c10.png)
![chrome_2019-06-05_13-48-10](https://user-images.githubusercontent.com/20374208/58950963-a5ec0d00-8798-11e9-9b93-60847615f067.png)
![chrome_2019-06-05_13-45-15](https://user-images.githubusercontent.com/20374208/58950805-3ece5880-8798-11e9-9659-456fcc98c259.png)
![chrome_2019-06-05_13-45-28](https://user-images.githubusercontent.com/20374208/58950806-3ece5880-8798-11e9-985e-5bade3de14af.png)
![chrome_2019-06-05_13-47-21](https://user-images.githubusercontent.com/20374208/58950962-a5ec0d00-8798-11e9-9eb6-8c578883156d.png)


  Compile :
  
  ``` JAVA
  javac --module-source-path optional_module -d out2 -m moduleA,moduleB
  ```

  Run :
  
  ``` JAVA
  java --module-path out2 -m moduleB/pack2.Main
  ```
<a name="3"></a>
---
# 3. ------------------- Transitive -------------------  

![chrome_2019-06-05_13-36-59](https://user-images.githubusercontent.com/20374208/58950535-b780e500-8797-11e9-8af0-34e5bf10a33d.png)
![chrome_2019-06-05_13-37-16](https://user-images.githubusercontent.com/20374208/58950537-b780e500-8797-11e9-9016-54cada9774b8.png)
![chrome_2019-06-05_13-41-54](https://user-images.githubusercontent.com/20374208/58950538-b780e500-8797-11e9-900c-89eca1165b5a.png)
 
 **Be careful not spaces are allowed between (moduleA,moduleB,moduleC)**
  
  Compile :
  
 ``` JAVA
 javac --module-source-path transitive_module -d out3 -m moduleA,moduleB,moduleC
 ```


  Run :
  
 ``` JAVA
 java --module-path out3 -m moduleC/pack3.Main
 ```
<a name="4"></a>
---
# 4. ------------------- Cyclic ------------------- 


![chrome_2019-06-05_11-32-23](https://user-images.githubusercontent.com/20374208/58942031-a038fc00-8785-11e9-802d-7349461d92fc.png)
![chrome_2019-06-05_11-32-32](https://user-images.githubusercontent.com/20374208/58942032-a0d19280-8785-11e9-9c9c-c1ed6abdf6c1.png)
![2019-06-05_13-52-25](https://user-images.githubusercontent.com/20374208/58951203-290d6300-8799-11e9-84b9-91ec28e6939f.png)

  Compile :
  
``` JAVA
javac  --module-source-path cyclic_module -d out4 -m moduleA,moduleB
```

This will produce the following error :

``` JAVA
error: cyclic dependence involving moduleA requires moduleA;
```

![chrome_2019-06-05_11-26-05](https://user-images.githubusercontent.com/20374208/58941549-b6928800-8784-11e9-856f-8914ac6f3779.png)

<a name="5"></a>
---
# 5. ------------------- Qualified Exports-------------------  

![chrome_2019-06-05_13-53-55](https://user-images.githubusercontent.com/20374208/58951282-5eb24c00-8799-11e9-8805-96f8d9f2bcb1.png)
![chrome_2019-06-05_14-47-44](https://user-images.githubusercontent.com/20374208/58954268-5c53f000-87a1-11e9-886e-2316b1390602.png)
![chrome_2019-06-05_14-52-15](https://user-images.githubusercontent.com/20374208/58954318-85748080-87a1-11e9-9783-f5a824174da2.png)


  Compile : 
  ``` JAVA 
  javac --module-source-path qualified_module -d out5 -m exporterModule,moduleA,moduleB
  ```
  
  The error:
  
  ``` JAVA 
   error: package pack2 is not visible
            import pack2.B;
                   ^
          (package pack2 is declared in module exporterModule, which does not export it to module moduleB)
          1 error
  ```
  
  How to solve :
  Well as we can see that error happens because inside our **exporterModule** we allow access to **pack2** only for **moduleA** :
  
  ![chrome_2019-06-05_14-42-10](https://user-images.githubusercontent.com/20374208/58953810-29f5c300-87a0-11e9-8a89-ff9c796ebed4.png)


  Do you want to fix it ? 
  
  Simply **export pack2 for moduleB also** like this :


  ``` JAVA
  export pack2 to moduleA,moduleB;
  
  ```
  
  Okay but now how to run sir ?

 ``` JAVA
  java --module-path out5 -m moduleA/pack1.Test
 ```
  
 ``` JAVA
  java --module-path out5 -m moduleB/pack1.Test
 ```
 
 <a name="6"></a>
---
# 6. ------------------- Observable -------------------

![chrome_2019-06-06_18-33-04](https://user-images.githubusercontent.com/20374208/59045888-8e408180-8889-11e9-8d03-d5ec84ae2e83.png)


 Compile :
  
 ``` JAVA
 //TODO
 ```


 Run :
  
 ``` JAVA
  //TODO
 ```


<a name="7"></a>
---
# 7. ------------------- Aggregator -------------------  


![chrome_2019-06-06_18-16-35](https://user-images.githubusercontent.com/20374208/59044922-c0e97a80-8887-11e9-8d0b-a1d23231b3f6.png)
![chrome_2019-06-06_18-16-48](https://user-images.githubusercontent.com/20374208/59044927-c0e97a80-8887-11e9-9ede-ade53122ce5a.png)
![chrome_2019-06-06_18-17-36](https://user-images.githubusercontent.com/20374208/59044928-c0e97a80-8887-11e9-8e97-390ad24e84e8.png)
![chrome_2019-06-06_18-17-52](https://user-images.githubusercontent.com/20374208/59044929-c1821100-8887-11e9-849e-f08d8ef584a7.png)
![chrome_2019-06-06_18-18-59](https://user-images.githubusercontent.com/20374208/59044930-c1821100-8887-11e9-90fa-4001217bdffe.png)
![chrome_2019-06-06_18-19-16](https://user-images.githubusercontent.com/20374208/59044931-c1821100-8887-11e9-92a1-d29cf3301e3b.png)
![chrome_2019-06-06_18-19-35](https://user-images.githubusercontent.com/20374208/59044933-c1821100-8887-11e9-94cd-a8fca4208ba4.png)

 Compile :
  
 ``` JAVA
  javac --module-source-path aggregator_module -d out7 -m aggregator,moduleA,moduleB,moduleC,useModule
 ```
 

 Run :
  
 ``` JAVA
  java --module-path out7 -m useModule/pack4.Main
 ```


<a name="8"></a>
---
# 8. ------------------- Module Graph -------------------  


![chrome_2019-06-06_10-39-20](https://user-images.githubusercontent.com/20374208/59015559-f53d4680-8847-11e9-945f-8880116a45ce.png)
![chrome_2019-06-06_10-48-39](https://user-images.githubusercontent.com/20374208/59015940-d4c1bc00-8848-11e9-9b26-d41013453b80.png)
![2019-06-06_10-41-03](https://user-images.githubusercontent.com/20374208/59015561-f5d5dd00-8847-11e9-95ef-31ded987811f.png)
![chrome_2019-06-06_10-41-31](https://user-images.githubusercontent.com/20374208/59015562-f5d5dd00-8847-11e9-9f05-85de1c2eb3be.png)
![chrome_2019-06-06_10-41-51](https://user-images.githubusercontent.com/20374208/59015563-f5d5dd00-8847-11e9-8184-fc516f8e8dea.png)
![chrome_2019-06-06_10-42-03](https://user-images.githubusercontent.com/20374208/59015564-f5d5dd00-8847-11e9-89c2-6b852219c4b1.png)
![chrome_2019-06-06_10-42-12](https://user-images.githubusercontent.com/20374208/59015566-f66e7380-8847-11e9-86ab-d7e6799a866a.png)
![chrome_2019-06-06_10-42-23](https://user-images.githubusercontent.com/20374208/59015567-f66e7380-8847-11e9-94c6-86080734321b.png)

<a name="9"></a>
---
# 9. ------------ Package Naming Conflicts ------------

![chrome_2019-06-10_15-49-59](https://user-images.githubusercontent.com/20374208/59196550-af5de680-8b97-11e9-843c-59b4384d03aa.png)
![chrome_2019-06-10_15-50-33](https://user-images.githubusercontent.com/20374208/59196552-af5de680-8b97-11e9-8635-ba5702194a6b.png)
![chrome_2019-06-10_15-50-45](https://user-images.githubusercontent.com/20374208/59196553-af5de680-8b97-11e9-9496-023ec2b7b821.png)
![chrome_2019-06-10_15-51-00](https://user-images.githubusercontent.com/20374208/59196554-aff67d00-8b97-11e9-81b9-2617b95b2389.png)

 Compile :
  
 ``` JAVA
  javac  --module-source-path name_conflicts_module -d out9 -m moduleA,moduleB,useModule
 ```
 
 This will produce the following error :

``` JAVA
error: module useModule reads package pack1 from both moduleA and moduleB
module useModule{
^
1 error
```

<a name="10"></a>
---
# 10. ------------ Module Resolution Process ------------ 

![chrome_2019-06-10_16-06-02](https://user-images.githubusercontent.com/20374208/59197415-f64cdb80-8b99-11e9-8ed9-5ec4b7add576.png)
![chrome_2019-06-10_16-06-35](https://user-images.githubusercontent.com/20374208/59197416-f64cdb80-8b99-11e9-98ac-38c11509130f.png)
![chrome_2019-06-10_16-06-51](https://user-images.githubusercontent.com/20374208/59197418-f64cdb80-8b99-11e9-9668-8e8060923af4.png)
![chrome_2019-06-10_16-07-02](https://user-images.githubusercontent.com/20374208/59197419-f64cdb80-8b99-11e9-90a3-b377c3f34cc8.png)
![chrome_2019-06-10_16-07-38](https://user-images.githubusercontent.com/20374208/59197420-f64cdb80-8b99-11e9-8680-b230fac2b96c.png)
![chrome_2019-06-10_16-07-46](https://user-images.githubusercontent.com/20374208/59197421-f6e57200-8b99-11e9-9ab7-f97a06f3b3c7.png)

 Compile :
  
 ``` JAVA
   //TODO
 ```
