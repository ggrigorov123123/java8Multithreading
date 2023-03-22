# JOIN

## Without Join
- The program will print always "0", which of course is wrong. The reason
is that the primary thread continues after the thread th is started and print
the value of prime within the thread has updated the variable. The primary 
thread does not wait for the thread th to terminate.

## With Join
- The problem can be solved by changing the main() method to use **join()**
- java.lang.Thread class provides the join() method which allows one thread to wait 
until another thread completes its execution. If t is a Thread object whose thread 
is currently executing, then t.join() will make sure that t is terminated before 
the next instruction is executed by the program. If there are multiple threads 
calling the join() methods that means overloading on join allows the programmer 
to specify a waiting period. However, as with sleep, join is dependent on the OS 
for timing, so you should not assume that join will wait exactly as long as you 
specify. There are three overloaded join functions.