package com.lambda.kup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class FilterPrimeNumbersTest {

        ArrayList<Integer> randomNumberList = new ArrayList<Integer>();
        Random randomNumber = new Random();

        @org.junit.jupiter.api.Test
        void getRandomNumbers() {

                for(int iterator = 0; iterator<=100; iterator++) {

                        randomNumberList.add(randomNumber.nextInt(200));
                        assert (randomNumberList.get(iterator) > 0);
                }

                assert (!randomNumberList.isEmpty());
                assert (randomNumberList.get(10) < 200);

        }

        @org.junit.jupiter.api.Test
        void getFilteredPrimeNumbers() {

                for (int iterator = 0; iterator < 100; iterator++) {
                        randomNumberList.add(randomNumber.nextInt(200));
                }

                Predicate<Integer> numberPrimeOrNot = no -> no > 1 && LongStream.rangeClosed(2, no / 2)
                        .noneMatch(i -> no % i == 0);

                List<Integer> storePrimeNumber = randomNumberList.stream().filter(numberPrimeOrNot).collect(Collectors.toList());

                for (int iterator = 0; iterator<100; iterator++) {

                        if(randomNumberList.get(iterator).equals(storePrimeNumber))
                        {
                                assert (true);
                        }
                }

        }
}