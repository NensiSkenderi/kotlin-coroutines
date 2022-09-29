package com.learning.runblocking

import com.learning.coroutine.runblocking.mySuspFunc
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class RunBlockingTest {

    @Test
    fun myTest(){
        Assert.assertEquals(10, 5+5)
    }

    fun testMySuspFunc() = runBlocking {
        mySuspFunc()
    }
}