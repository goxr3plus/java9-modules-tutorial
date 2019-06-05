# Examples from Java 9 ++ modules

![Logging-Sins-793x397](https://user-images.githubusercontent.com/20374208/58885740-674c4900-86eb-11e9-9448-b0af3d8b52c0.png)


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
### 1. Simple module

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
### 2. Optional 

  Compile :
  
  ``` JAVA
  javac --module-source-path optional_module -d out2 -m moduleA,moduleB
  ```

  Run :
  
  ``` JAVA
  java --module-path out2 -m moduleB/pack2.Main
  ```

---
### 3. Transitive 
 
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
### 4. Cyclic 

![chrome_2019-06-05_11-32-23](https://user-images.githubusercontent.com/20374208/58942031-a038fc00-8785-11e9-802d-7349461d92fc.png)
![chrome_2019-06-05_11-32-32](https://user-images.githubusercontent.com/20374208/58942032-a0d19280-8785-11e9-9c9c-c1ed6abdf6c1.png)

``` JAVA
 module moduleA{
  
  requires moduleB;
  
 }
```

``` JAVA
 module moduleB{
  
  requires moduleA;
  
 }
```

  Compile :
  
``` JAVA
javac  --module-source-path src -d out -m moduleA,moduleB
```

This will produce the following error :

``` JAVA
error: cyclic dependence involving moduleA requires moduleA;
```

![chrome_2019-06-05_11-26-05](https://user-images.githubusercontent.com/20374208/58941549-b6928800-8784-11e9-856f-8914ac6f3779.png)

---
### 5. Qualified 

//TODO

  Compile :
>

  Run :
> 



