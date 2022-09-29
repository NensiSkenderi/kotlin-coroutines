package com.learning.coroutine.async

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Main thread starts: ${Thread.currentThread().name}")

    val jobDeferred: Deferred<Unit> = async {
        println("other work starts: ${Thread.currentThread().name}")
        delay(1000)
        println("other work finishes: ${Thread.currentThread().name}")
    }

    val jobDeferredReturnString: Deferred<String> = async {
        println("other work starts: ${Thread.currentThread().name}")
        delay(1000)
        println("other work finishes: ${Thread.currentThread().name}")
        "Nensi Skenderi"
    }

    jobDeferred.join()
    println("Main thread finishes: ${Thread.currentThread().name}")


    /*
     when using async the output and logic is the same as with launch but,

     1) async returns an object of type Deferred (generic type), its a subclass of Job interface
     2) we can return anything
     3) if we dont want to use the returned String, the .join() function
        will wait for co to finish, but if we want to return it we need to
        use .await() function like val name = jobDeferred.await()
     4) is a suspending function
     5) so, you can retrieve data with await()
     */
}