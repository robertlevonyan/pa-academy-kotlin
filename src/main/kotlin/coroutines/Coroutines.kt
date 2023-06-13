package coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.suspendCoroutine

fun main() {
    val job = Job()
    val supervisor = SupervisorJob()
    val coroutineScope = CoroutineScope(supervisor + Dispatchers.IO + exceptionHandler)
    coroutineScope.launch(Dispatchers.IO) {
//        println("Start ${System.currentTimeMillis()}")
//        launch {
//            delay(1000)
//            println("1 ${System.currentTimeMillis()}")
//        }
//        val asyncValue = async(Dispatchers.IO) {
//            foo(null)
//            delay(2000)
//            println("2 ${System.currentTimeMillis()}")
//        }


        println("1 ${currentCoroutineContext()}")

        withContext(Dispatchers.Main) {
            println("2 ${currentCoroutineContext()}")
            delay(1000)
        }
        println("3 ${currentCoroutineContext()}")

        val startTime = System.currentTimeMillis()

        val async1 = async {
            async1()
        }
        val async2 = async {
            async2()
        }

//        delay(2000)
        val endTime = System.currentTimeMillis()

        println(endTime - startTime)
        println(async1.await() + async2.await())
        val endTime2 = System.currentTimeMillis()
        println(endTime2 - startTime)
    }
    coroutineScope.launch {
        val callbackResult: Int = replaceCallback()

    }

    Thread.sleep(15000)
}

suspend fun async1(): Int {
    delay(1000)
    return 1
}

suspend fun async2(): Int {
    delay(2000)
    return 2
}

val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    println(throwable)
}

suspend fun foo(a: String?): Int {
    delay(500)
    println(a!!)
    return 1
}

suspend fun replaceCallback(): Int = suspendCoroutine { continuation ->
    TestCallback().apply {
        onRunCompletedCallback = object : TestCallback.OnRunCompletedCallback {
            override fun onCompleted(result: Int) {
                continuation.resumeWith(Result.success(result))
            }
        }
    }
}
