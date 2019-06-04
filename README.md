# java-modules-examples

![Logging-Sins-793x397](https://user-images.githubusercontent.com/20374208/58885740-674c4900-86eb-11e9-9448-b0af3d8b52c0.png)


- **Categories**
  - **Simple module**
  - **Optional**
  - **Transitive**
  - **Cyclic**
  - **Qualified**

### 1. Simple module

  Compile :
> javac --module-source-path simple_module -d out1 -m moduleA

  Run :
> java --module-path out1 -m moduleA/pack1.Main


### 2. Optional 

  Compile :
> javac --module-source-path optional_module -d out2 -m moduleA,moduleB

  Run :
> java --module-path out2 -m moduleB/pack2.Main


### 3. Transitive 
 
  **Be careful not spaces are allowed between (moduleA,moduleB,moduleC)**
  Compile :
> javac --module-source-path transitive_module -d out3 -m moduleA,moduleB,moduleC


  Run :
> java --module-path out3 -m moduleC/pack3.Main


### 4. Cyclic 

//TODO

  Compile :
>

  Run :
> 


### 5. Qualified 

//TODO

  Compile :
>

  Run :
> 



