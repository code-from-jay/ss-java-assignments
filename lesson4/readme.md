# Concurrency

---

## Assignment 1
Implement a Singleton with double-checked locking.

## Assignment 2
Write a program to create a deadlock between two threads.

## Assignment 3
Write a program with on thread (the producer) that produces items (in this case, simple ints). Another thread (the consumer) consumes items. For communication purposes, both threads have access to a bounded buffer which is basically an array.

---

# JUnit

---

## Assignment 4
Create unit tests for the Line Class.
1. Create a file called LineTest.java
2. Create tests for the `getSlope`, `getDistance`, and `parallelTo` methods
3. Because of rounding errors, it is bad practice to test double values for exact equality.
   To get around this, you can pass a small value (such as .0001) to `assertEquals` to be used as a delta.

---