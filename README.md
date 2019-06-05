# Java 9 ++ modules full tutorial

![Logging-Sins-793x397](https://user-images.githubusercontent.com/20374208/58885740-674c4900-86eb-11e9-9448-b0af3d8b52c0.png)
### Complety PDF with tutorial [download](https://github.com/goxr3plus/java9-modules-tutorial/files/3256292/JPMS.PDF)


- **Categories**
  - **Simple module**
  - **Optional**
  - **Transitive**
  - **Cyclic**
  - **Qualified**

Highly based on  [ java-9-new-features-in-simple-way-jshell-jpms-and-more ](https://www.udemy.com/java-9-new-features-in-simple-way-jshell-jpms-and-more/) and [Jenkov Tutorials](http://tutorials.jenkov.com/java/modules.html)

![chrome_2019-06-05_11-35-10](https://user-images.githubusercontent.com/20374208/58942200-fd34b200-8785-11e9-8f9c-dcb1aec1cf24.png)

![chrome_2019-06-05_11-39-19](https://user-images.githubusercontent.com/20374208/58942502-906de780-8786-11e9-98e7-4d5f070053c5.png)

---

![chrome_2019-06-05_11-41-00](https://user-images.githubusercontent.com/20374208/58942638-cf9c3880-8786-11e9-8ddd-76c120c49d6f.png)

---
# 1. Simple module

![chrome_2019-06-05_11-43-36](https://user-images.githubusercontent.com/20374208/58942863-433e4580-8787-11e9-829d-cda9256aaef9.png)

![chrome_2019-06-05_11-43-50](https://user-images.githubusercontent.com/20374208/58942864-433e4580-8787-11e9-9314-57b16f55a7ed.png)
![chrome_2019-06-05_11-44-17](https://user-images.githubusercontent.com/20374208/58942865-43d6dc00-8787-11e9-982f-f811fe625d1a.png)

##### Ps i have provided all the code in folders so you don't have to manually type it ;)

  Compile :
  
  ``` JAVA
  javac --module-source-path simple_module -d out1 -m moduleA
  ``` 

  Run :
  
  ``` JAVA
  java --module-path out1 -m moduleA/pack1.Main
  ```

---
# 2. Optional

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

---
# 3. Transitive 

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

---
# 4. Cyclic 

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

---
# 5. Qualified 

![chrome_2019-06-05_13-53-55](https://user-images.githubusercontent.com/20374208/58951282-5eb24c00-8799-11e9-8805-96f8d9f2bcb1.png)
![Uploading chrome_2019-06-05_14-47-44.png…]()
![Uploading chrome_2019-06-05_14-47-58.png…]()


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
  Well as we can see that error happens because inside our **exporterModule** we allow access to **pack2** only for moduleA :
  ![chrome_2019-06-05_14-42-10](https://user-images.githubusercontent.com/20374208/58953810-29f5c300-87a0-11e9-8a89-ff9c796ebed4.png)


  Do you want to fix it ? 
  
  Simply *export pack2 for moduleB also* like this :


  ``` JAVA
  export pack2 to moduleA,moduleB
  
  ```
  
  Okay but now how to run sir ?

  
 > java --module-path out5 -m moduleA/pack1.Test
   and 
 > java --module-path out5 -m moduleB/pack1.Test
  



