package classes

sealed interface Request

class Success(val user: User) : Request {
    companion object {
        init {
        }
        const val TEST = "test"
    }
}

internal class Failure(val error: Exception) : Request

object MyObject : Request

fun login(login: String, password: String): Request {
    return Failure(NullPointerException())
}

fun main() {
    val loginResult = login("aa", "bb")

    val isLoginSuccess = when (loginResult) {
        is Success -> {
            Success.TEST
            println("Success ${loginResult.user}")
            true
        }

        is Failure -> {
            println(loginResult.error)
            false
        }

        MyObject -> false
    }
}