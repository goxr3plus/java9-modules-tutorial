# java-modules-examples
(  Transitive , Optional , Cyclic , Qualified ) 

Here you will find 4 different folders each one representing a different example of java modules :

- **Categories**
  - 1. Very simple module 
  - 2. Optional
  - 3. Transitive
  - 4. Cyclic
  - 5. Qualified


So how to run : 

### 1. Very Simple module

  Compile :
> javac --module-source-path simple_module -d out1 -m moduleA

  Run :
> java --module-path out1 -m moduleA/pack1.Main


### 2. Optional 

  Compile :
> javac --module-source-path optional_module -d out2 -m moduleA,moduleB

  Run :
> java --module-path out1 -m moduleB/pack2.Main


### 3. Transitive 

  Compile :
> Be careful not spaces are allowed between (moduleA,moduleB,moduleC)

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



