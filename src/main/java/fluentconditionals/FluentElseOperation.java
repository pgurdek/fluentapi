package fluentconditionals;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FluentElseOperation<T> {
    private boolean condition;
    private T returnValue = null;
//    private T givenValue;

    public FluentElseOperation(final boolean condition, T returnValue) {
        this.condition = condition;
        this.returnValue = returnValue;
    }

    public FluentElseOperation(final boolean condition) {
        this.condition = condition;
    }

    public void  orElse(Consumer<T> consumer){
        if(!condition){
            consumer.accept(returnValue);
        }
    }
    public void orElse(Runnable runnable){
        if(!condition){
            runnable.run();
        }
    }

    public T orElse(T value ){
        if(!condition){
            returnValue = value;
        }
        return returnValue;
    }

    public T orElse(Supplier<T> supplier){
        if(!condition){
            returnValue = supplier.get();
        }
        return returnValue;
    }


    public void orElseThrowE(RuntimeException runTimeException){
        if(!condition){
            throw runTimeException;
        }
    }

    public T orElseThrow(Supplier<RuntimeException> supplier){
        if(!condition){
            throw supplier.get();
        }
        return returnValue;
    }

    public T orElseThrow(RuntimeException runtTimeException){
        if(!condition){
            throw runtTimeException;
        }
        return returnValue;
    }

}
