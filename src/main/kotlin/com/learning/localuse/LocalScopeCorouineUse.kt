package com.learning.localuse

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { //creates a blocking co that runs on main thread

    println("Main thread starts: ${Thread.currentThread().name}")

   launch { // runs on the main thread because it is local scope, this child co inherits the scope of parent co
       println("other work starts: ${Thread.currentThread().name}")
       delay(1000)
       println("other work finishes: ${Thread.currentThread().name}")
   }

    println("Main thread finishes: ${Thread.currentThread().name}")

}