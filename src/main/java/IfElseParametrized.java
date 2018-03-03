import fluentconditionals.FluentElseOperation;

import java.util.function.Consumer;

import static fluentconditionals.FluentConditionals.*;

public class IfElseParametrized {
    public static void main(String[] args) {
        Consumer<String> printLastChar = TestHelper::printLastChar;

         given("This")
                .when(true)
                .then(TestHelper::printFirstChar)
                .orElse(printLastChar);


        given(TestHelper::getAString)
                .when(TestHelper::somethingIsTrue)
                .then(TestHelper::printFirstChar)
                .orElse(TestHelper::printLastChar);
//
        given(TestHelper::getAString)
                .when(TestHelper::somethingIsTrue)
                .then(TestHelper::printFirstChar)
                .orElse(doNothing());

        given(TestHelper::getAString).when(true).then(TestHelper::printFirstChar).;
//                .when(!TestHelper.somethingIsTrue())
//                .then(TestHelper::printFirstChar)
//                .orElseThrow(new RuntimeException());
    }
}
