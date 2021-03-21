package com.log.jdk8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author pengmin
 * @date 2021/3/21 15:26
 */

public class RegexDemo {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = bufferedReader.readLine()) != null && input.length() > 0) {
            if (input.matches("^[\\d]{2,3}$")) {
                System.out.println("number!");
            } else {
                System.out.println("not number!");
            }
        }
    }
}
