# Deamon and None Deamon Threads

## 1. Basics
- A thread may be a deamon or none deamon thread(also referred to as a worker).
A deamon is intended as a helper thread to another thread, and the difference
is that a deamon is automatically terminated when the program's last none deamon
terminates.

- Typically, daemon threads have nothing to do with priority. The JVM shuts down 
when all user non-daemon threads finish. Marking a thread as a daemon thread 
means that it can be safely killed when the JVM exits.

- Priority is about scheduling – about how often a thread gets a time slice in 
comparison to other threads that are ready to run. You can have low priority 
daemon threads or high priority daemon threads. You can have non-daemon threads 
that are also low and high priority. **As an aside, thread priorities only apply 
in certain specific situations and on certainly architectures and as a Java 
thread expert, I never use them**.

- In terms of when to make a thread daemon, I use daemon threads for any tasks 
that I don't care if they are interrupted when the JVM quits: keep-alive threads, 
statistics processors, log handling, etc.. Everything mission critical to the 
application is a non-daemon thread that has to be specifically interrupted or 
signaled to quit somehow.

## 2. Thread states
- New - thread is created, but not yet started
- Running - thread is performed on a processor
- Blocked - thread is blocked and is waiting on a lock
- Waiting - thread waits on a notification form another thread
- Timed_Waiting - thread waits on a notification because of a timeout
- Terminated - thread is terminated

## 3. sleep()

sleep(...[ms]) - That a thread is suspended means that in the period in
question it is not active and does not participate in the resource
allocation. It uses no CPU time.

## 4. Good to know
- When an application begins running, there is one non-daemon thread, whose 
job is to execute main(). The JVM exits when the last non-daemon thread exits.
If the main thread wasn't non-daemon then the JVM would start up and see that
there were no non-daemon threads running and would shutdown immediately.
- A thread created by a daemon thread is initially also a daemon thread.
- A thread created by a non-daemon thread is initially also a non-daemon thread.
- If you want to change the daemon status then you have to do so before the thread 
is started.


