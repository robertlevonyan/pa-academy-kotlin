import kotlinx.coroutines.*
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import kotlin.coroutines.CoroutineContext

fun main() {
    val job = Job()
    val supervisor = SupervisorJob()
    val coroutineScope = CoroutineScope(supervisor + Dispatchers.IO + exceptionHandler)
    coroutineScope.launch(Dispatchers.IO) {
        println("Start ${System.currentTimeMillis()}")
        launch {
            delay(1000)
            println("1 ${System.currentTimeMillis()}")
        }
        launch(Dispatchers.IO) {
            foo(null)
            delay(2000)
            println("2 ${System.currentTimeMillis()}")
        }
        launch {
            delay(1000)
            println("3 ${System.currentTimeMillis()}")
        }
    }

    Thread.sleep(5000)
}

val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    println(throwable)
}

suspend fun foo(a: String?) {
    delay(500)
    println(a!!)
}