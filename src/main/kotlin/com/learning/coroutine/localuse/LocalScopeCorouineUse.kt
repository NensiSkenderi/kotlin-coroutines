package com.learning.coroutine.localuse

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { //creates a blocking co that runs on main thread

    println("Main thread starts: ${Thread.currentThread().name}")

   val job: Job = launch { // runs on the main thread because it is local scope, this child co inherits the scope of parent co
       println("other work starts: ${Thread.currentThread().name}")
       delay(1000)
       println("other work finishes: ${Thread.currentThread().name}")
   }

    //delay(2000) // since this is not the right way to wait

    //we use this
    job.join() // will wait for the co to finish its execution
    println("Main thread finishes: ${Thread.currentThread().name}")

}