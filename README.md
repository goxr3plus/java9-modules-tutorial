# java-modules-examples
**(  Very Simple Module , Optional , Transitive , Cyclic , Qualified )**

- **Categories**
  - **Very simple module**
  - **Optional**
  - **Transitive**
  - **Cyclic**
  - **Qualified**


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



