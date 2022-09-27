package com.learning.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    println("Running on the main thread: ${Thread.currentThread().name}")

    GlobalScope.launch { // this launch function creates a background coroutine that runs on a background thread
        println("Other work starts: ${Thread.currentThread().name}")
        //Thread.sleep(1000) //perform some work
        println("Other work finishes: ${Thread.currentThread().name}")
    }


    //how can main wait for coroutine to finish?
    Thread.sleep(2000); // not a right way to wait because you dont know
    //how much time the work in coroutine is going to last

    runBlocking {  // creates a coroutine that block the current main thread (because it runs on this thread)
        delay(2000) // wait for co to finish (not right way to wait)
    }
    println("Main thread finishes: ${Thread.currentThread().name}")

}