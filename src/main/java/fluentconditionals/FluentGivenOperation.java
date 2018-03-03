package fluentconditionals;

public class FluentGivenOperation<T>{

    private T value;

    public FluentGivenOperation(T value){
        this.value = value;
    }

    public FluentThenOperation<T> when(boolean condition){
        return new FluentThenOperation<>(condition,value);
    }

    public FluentThenOperation<T> when(FluentConditionals.PredicateWithOutArgs predicate){
        return new FluentThenOperation<>(predicate.test(),value);
    }

}

