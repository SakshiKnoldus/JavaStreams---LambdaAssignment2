package com.lambda.kup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class FilterPrimeNumbers {

        public static void main(String[] args) {

                ArrayList<Integer> randomNumber = getRandomNumbers();
                getFilteredPrimeNumbers(randomNumber);

        }

         static ArrayList<Integer> getRandomNumbers() {

                ArrayList<Integer> randomNumberList = new ArrayList<Integer>();
                for(int iterator = 0; iterator <=100; iterator++)
                {
                        Random randomNumber = new Random();
                        randomNumberList.add(randomNumber.nextInt(200));
                }

                return randomNumberList;
        }

        static Predicate<Integer> numberPrimeOrNot = no -> no > 1 && LongStream.rangeClosed(2, no / 2)
                .noneMatch(i -> no % i == 0);

        static void getFilteredPrimeNumbers(ArrayList<Integer> getList) {

                List<Integer> storePrimeNumber = getList.stream().filter(numberPrimeOrNot).collect(Collectors.toList());
                System.out.println("Below are the prime numbers generated in a random list of numbers: ");
                System.out.println(storePrimeNumber);

        }


}
