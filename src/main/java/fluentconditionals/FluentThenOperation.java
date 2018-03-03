package fluentconditionals;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FluentThenOperation<T> {

    private boolean condition;
    private T givenValue;

    public FluentThenOperation(final boolean condition) {
        this.condition = condition;
    }

    public FluentThenOperation(final boolean condition, final T value) {
        this.condition = condition;
        this.givenValue = value;
    }

    public FluentElseOperation then(Runnable runnable) {
        if (condition) {
            runnable.run();
        }
        return new FluentElseOperation(condition);
    }

    public FluentElseOperation<T> then(Consumer<T> consumer) {
        if (condition) {
            consumer.accept(givenValue);
        }
        return new FluentElseOperation<>(condition, givenValue);
    }

    public <T> FluentElseOperation<T> thenReturn(Supplier<T> supplierInt) {
        if (condition) {
            return new FluentElseOperation<>(condition, supplierInt.get());
        }
        T empty = null;
        return new FluentElseOperation<>(condition, empty);
    }

    public <T> FluentElseOperation<T> thenReturn(T value) {
        if (condition) {
            return new FluentElseOperation<>(condition, value);
        }
        T empty = null;
        return new FluentElseOperation<>(condition, empty);
    }
}
