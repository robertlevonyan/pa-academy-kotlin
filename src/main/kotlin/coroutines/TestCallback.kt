package coroutines

class TestCallback : Runnable {
    var onRunCompletedCallback: OnRunCompletedCallback? = null

    override fun run() {
        println("aa")

        onRunCompletedCallback?.onCompleted(5)
    }

    interface OnRunCompletedCallback {
        fun onCompleted(result: Int)
    }
}