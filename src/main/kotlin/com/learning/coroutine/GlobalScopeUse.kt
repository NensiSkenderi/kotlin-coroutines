package com.learning.coroutine

import kotlinx.coroutines.*

fun main() {


    //creates co at app level
    GlobalScope.launch {
        // file download -> we use GeneralScope for this because a download is not needed for ongoing activities
        // play music
    }

    //creates co at local scope
    runBlocking {
        launch {
            // login -> you want to login and close that operation right there
        }

    }


    /*
    use of GlobalScope.launch is discouraged bc if you create a co globally and
    forget about it, then it will keep on running in the background, consuming memory
     */
}