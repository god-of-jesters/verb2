package com.example.verb2;

import java.util.Random;

public class Solution {
    private Random random = new Random();
    private String o = "";
    public int[] getTask(String operation, int hard) {
        int param1;
        int param2;

        switch (operation){
            case "Сложение":
                o = "+";
                break;
            case "Вычитание":
                o = "-";
                break;
            case "Умножение":
                o = "*";
                break;
            case "Деление":
                o = "/";
                break;
            case "Извлечение корня":
                o = "<span>&#8730;3<span>";
                break;
        }

        switch (hard) {
            case 1:
                switch (operation) {
                    case "Сложение":
                        param1 = random.nextInt(10) + 2;
                        param2 = random.nextInt(10) + 2;
                        return new int[]{param1, param2, param1 + param2};

                    case "Вычитание":
                        param1 = random.nextInt(10) + 2;
                        param2 = random.nextInt(10) + 2;
                        return new int[]{param1, param2, Math.abs(param1 - param2)};

                    case "Умножение":
                        param1 = random.nextInt(10) + 2;
                        param2 = random.nextInt(10) + 2;
                        return new int[]{param1, param2, param1 * param2};

                    case "Деление":
                        param1 = random.nextInt(30) + 10;
                        param2 = random.nextInt(4) + 2;
                        while (param1 % param2 != 0) {
                            param1 = random.nextInt(10) + 2;
                            param2 = random.nextInt(10) + 2;
                        }
                        return new int[]{param1, param2, param1 / param2};
                    case "Извлечение корня":
                        param1 = random.nextInt(10) + 2;
                        param2 = 0;
                        return new int[]{param1 * param1, param2, param1};
                }
            case 2:
                switch (operation) {
                    case "Сложение":
                        param1 = random.nextInt(20) + 5;
                        param2 = random.nextInt(20) + 5;
                        return new int[]{param1, param2, param1 + param2};

                    case "Вычитание":
                        param1 = random.nextInt(20) + 5;
                        param2 = random.nextInt(20) + 5;
                        return new int[]{param1, param2, Math.abs(param1 - param2)};

                    case "Умножение":
                        param1 = random.nextInt(20) + 5;
                        param2 = random.nextInt(20) + 5;
                        return new int[]{param1, param2, param1 * param2};

                    case "Деление":
                        param1 = random.nextInt(40) + 10;
                        param2 = random.nextInt(10) + 2;
                        while (param1 % param2 != 0) {
                            param1 = random.nextInt(40) + 10;
                            param2 = random.nextInt(10) + 2;
                        }
                        return new int[]{param1, param2, param1 / param2};
                    case "Извлечение корня":
                        param1 = random.nextInt(10) + 4;
                        param2 = 0;
                        return new int[]{param1 * param1, param2, param1};
                }
            case 3:
                switch (operation) {
                    case "Сложение":
                        param1 = random.nextInt(25) + 10;
                        param2 = random.nextInt(25) + 10;
                        return new int[]{param1, param2, param1 + param2};

                    case "Вычитание":
                        param1 = random.nextInt(25) + 10;
                        param2 = random.nextInt(25) + 10;
                        return new int[]{param1, param2, Math.abs(param1 - param2)};

                    case "Умножение":
                        param1 = random.nextInt(25) + 10;
                        param2 = random.nextInt(25) + 10;
                        return new int[]{param1, param2, param1 * param2};

                    case "Деление":
                        param1 = random.nextInt(85) + 15;
                        param2 = random.nextInt(10) + 2;
                        while (param1 % param2 != 0) {
                            param1 = random.nextInt(85) + 15;
                            param2 = random.nextInt(10) + 2;
                        }
                        return new int[]{param1, param2, param1 / param2};
                    case "Извлечение корня":
                        param1 = random.nextInt(10) + 10;
                        param2 = 0;
                        return new int[]{param1 * param1, param2, param1};
                }
            default:
                return new int[]{0,0,0};
        }
    }
    public String getO(){
        return o;
    }
}
