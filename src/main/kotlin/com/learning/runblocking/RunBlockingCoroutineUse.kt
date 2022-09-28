package com.learning.runblocking

import kotlinx.coroutines.delay

fun main() {

    /*
    runBlocking is generally used to write test cases to test
    suspending functions
     */
}

suspend fun mySuspFunc(){
    delay(1000) //do something
}