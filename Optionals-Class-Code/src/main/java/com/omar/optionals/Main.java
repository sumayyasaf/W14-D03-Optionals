package com.omar.optionals;

import com.omar.homework.codealong.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        String username = null;

//        Creating optionals

//        1. .empty(): creates an empty optional
        Optional<String> nameOptional = Optional.empty();

        System.out.println(nameOptional);

//        2. .of(): creates an optional of the provided value in the arguments
        Optional<String> nameOptional2 = Optional.of("Mihai");

        System.out.println(nameOptional2);

//        3. ofNullable(): creates an optional of the provided value that can be a null value

        Optional<String> usernameOptional = Optional.ofNullable(username);

        System.out.println(usernameOptional);



//        isPresent() and isEmpty()
        System.out.println(usernameOptional.isEmpty());
        System.out.println(nameOptional2.isPresent());


//        ifPresent() and ifPresentOrElse()
        usernameOptional.ifPresent((value)-> System.out.println("Presnet value"));
        usernameOptional.ifPresentOrElse((value)-> System.out.println("Optional is empty"),()-> System.out.println("Empty Optional"));

        if(usernameOptional.isPresent()){
            System.out.println("value is there");
        }
        else{
            System.out.println("value is not there");
        }

        Optional<String> emptyOptional = Optional.empty();



//        Getting the value from the optional

        System.out.println(nameOptional2.get());
//        System.out.println(emptyOptional.get());

        if(emptyOptional.isPresent()){
            System.out.println(emptyOptional.get());
        }
        else{
            System.out.println("Optional is empty");
        }


//        orElse()
        String optionalValue = nameOptional2.orElse(retrunValue());

        System.out.println(optionalValue);

//        String emptyOptionalValue = emptyOptional.orElse(retrunValue());
//
//        System.out.println(emptyOptionalValue);

//        orElseGet()
        String optionalValue2 = nameOptional2.orElseGet(()-> retrunValue());

        System.out.println(optionalValue2);


        System.out.println(nameOptional2);

        System.out.println(nameOptional2.map(value->value.toUpperCase()).get());

//        filter(): will return the optional if the predicate condition is true
//        or it will return an empty optional if the condition is not true
        System.out.println(nameOptional2.filter(value->value.equals("Omar")));

        List<Optional<String>> namesOptional = new ArrayList<>(Arrays.asList(Optional.of("Aron"),Optional.of("Kathrin")));


        System.out.println(namesOptional);

        namesOptional.stream()
                .filter(value->value.get().charAt(0) == 'A')
                .forEach((value)-> System.out.println(value.get()));




    }

    public static String retrunValue(){
        System.out.println("Method called");
        return "Default Student";
    }
}