# About

This is an implementation for a custom priority queue with the following requirements:

1) Each priority is defined by an integer with “1” being the highest.
2) The value of the items in the queue should be user-defined.
3) Every item in the same priority class should be dequeued on FIFO basis.
4) For every item with priority P that is dequeued twice from the queue, the next item should be of priority P+1. For example, if the following items are in the queue: 1212 3211 (spaces are for readability), then the sequence for dequeuing should be: 1121 1232

You can read more about this project on my [blog](https://musingsonprogramming.blogspot.com/2020/02/building-custom-priority-queue-in-java.html) where I describe my design decisions.

# Requirements

* Java 8
* JUnit 5.6.0
* make

You need to download junit-platform-console-standalone-1.6.0.jar from the
junit.org website and store it in the lib folder to run the tests.

If you don't have make, you can install on Mac using Homebrew with `brew install make`

# How to run

Run `make` in the root of the project.
