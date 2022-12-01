package com.ing.adventofcode.day1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class CalorieCounting {
///Users/sv18et/AdventOfCode2022/Day1_input.txt
    public static void main(String[] args)
    {
        if(args.length == 0 )
        {
            System.out.println(" Enter the input file ");
            return;
        }

        if(args[0] == null ) {
            System.out.println(" Input file as first argument");
            return;
        }
        try {
        Path filePath = Path.of(args[0]);
        String content = Files.readString(filePath);
        String[] blocks = content.split("\\n[\\n]+");
        long elvesCount = Arrays.stream(blocks).count();
        System.out.println(" elvesCount = "+elvesCount);
        Stream calorieTotalWithEachElf =     Arrays.stream(blocks).map(block -> Arrays.stream(block.split("\\n")))
                .map(str -> str.mapToInt(e -> Integer.parseInt(e.toString())).reduce(0, (subtotal, element) -> subtotal+element));
        Stream calorieTotalWithEachElf2 = Arrays.stream(blocks).map(block -> Arrays.stream(block.split("\\n")))
                .map(str -> str.mapToInt(e -> Integer.parseInt(e.toString())).reduce(0, (subtotal, element) -> subtotal+element));

            OptionalInt val =     calorieTotalWithEachElf
                                  .mapToInt(e -> Integer.parseInt(e.toString()))
                                  .max();
            int sum = 0;
            if(val.isPresent())
                sum = val.getAsInt();
            System.out.println(" sum = "+sum);

            int cal =  calorieTotalWithEachElf2
                    .mapToInt(e -> Integer.parseInt(e.toString()))
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .limit(3)
                    .mapToInt(e -> Integer.parseInt(e.toString()))
                    .sum();
            System.out.println(" cal = "+cal);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
