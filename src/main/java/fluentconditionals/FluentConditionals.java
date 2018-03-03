package fluentconditionals;

import java.util.function.Supplier;

public class FluentConditionals {


    public static Runnable doNothing  = () -> {};


    public  static  <T> FluentGivenOperation<T> given(T value){
        return new FluentGivenOperation<>(value);
    }

    public  static <T> FluentGivenOperation<T> given(Supplier<T> supplier){
        return new FluentGivenOperation<>(supplier.get());
    }

    public static FluentThenOperation<?> when(boolean condition){
        return new FluentThenOperation<>(condition);
    }

    public static FluentThenOperation<?> when(PredicateWithOutArgs predicate){
        return new FluentThenOperation<>(predicate.test());
    }

    public static Runnable doNothing(){
        return doNothing;
    }
    @FunctionalInterface
    public interface PredicateWithOutArgs {
      boolean  test();
    }
}