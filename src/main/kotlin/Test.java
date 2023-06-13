import coroutines.CoroutinesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

public class Test {
    public static void main(String[] args) {
        int x = (int) CoroutinesKt.foo(
                "abc",
                new Continuation<Integer>() {
                    @NotNull
                    @Override
                    public CoroutineContext getContext() {
                        return null;
                    }

                    @Override
                    public void resumeWith(@NotNull Object o) {

                    }
                }
        );
    }
}
