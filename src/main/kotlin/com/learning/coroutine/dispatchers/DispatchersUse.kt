package com.learning.coroutine.dispatchers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    // this -> CoroutineScope instance
    // coroutineContext  -> CoroutineContext instance


    // Without parameter: CONFINED DISPATCHER
    launch { // inherits everything from the parent (the runBlocking co which runs on main)
        println("CONFINED DISPATCHER thread name ${Thread.currentThread().name}") // executes on main
        delay(1000)
        println("CONFINED DISPATCHER after delay ${Thread.currentThread().name}") // executes on main
    }

    // With parameter: DEFAULT DISPATCHER // same as GlobalScope.launch {}
    launch(Dispatchers.Default) { // creates a co at the application level hence it will execute on another background thread
        println("DEFAULT DISPATCHER thread name ${Thread.currentThread().name}") // will execute on thread t1
        delay(1000)
        println("DEFAULT DISPATCHER after delay thread name ${Thread.currentThread().name}") // will execute on thread t1 or other thread
    }

    // With parameter: UNCONFINED DISPATCHER
    launch(Dispatchers.Unconfined) { // inherits everything from the parent (the runBlocking co which runs on main)
        println("UNCONFINED DISPATCHER thread name ${Thread.currentThread().name}") // executes on main
        delay(1000)
        println("UNCONFINED DISPATCHER after delay ${Thread.currentThread().name}") // will execute on some other thread
    }


    launch(Dispatchers.Unconfined) { // inherits everything from the parent (the runBlocking co which runs on main)
        println("UNCONFINED DISPATCHER thread name ${Thread.currentThread().name}") // executes on main
        delay(1000)
        println("UNCONFINED DISPATCHER after delay ${Thread.currentThread().name}") // will execute on some other thread
    }

    println("Main thread")
}