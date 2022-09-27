package com.learning.coroutine

import kotlin.concurrent.thread

fun main() { //operates on the main thread

    println("Running on the main thread: ${Thread.currentThread().name}")

    thread {
        /*
        this background thread did not block the code of the main thread
        which means that these 2 threads are running in parallel,
        the main thread will not wait for this thread to finish its work
         */
        println("Other work starts: ${Thread.currentThread().name}")
        //Thread.sleep(1000) //perform some work
        println("Other work finishes: ${Thread.currentThread().name}")
    }

    println("Ending, still on main thread: ${Thread.currentThread().name}")

}
