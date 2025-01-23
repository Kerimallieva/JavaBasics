package org.example.calculator;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        //создаем объект scanner, чтобы программа могла считывать
        // ввод пользователя через консоль
        Scanner scanner = new Scanner(System.in);
        boolean continueCaltulate = true;

        System.out.println("Добро пожаловать в Калькулятор!");

        while (continueCaltulate){
            try {
                System.out.println("Введите первое число: ");
                double num1 = Double.parseDouble(scanner.nextLine());
/*Ты используешь scanner.nextLine() для считывания целой строки, а потом преобразуешь строку в число с помощью Double.parseDouble().
Если бы ты использовала scanner.nextDouble(), то программа сразу бы читала число, но:
Это может вызвать проблемы, если пользователь случайно введет буквы или смешанные символы.
nextLine() дает больше контроля, так как сначала считывает всё, а потом можно обработать строку (например, проверить ошибки).*/
                System.out.print("Введите оператор (+, -, *, /): ");
                char operator = scanner.nextLine().charAt(0);
/*scanner.nextLine() считывает строку.
.charAt(0) берет первый символ этой строки (оператор, который ввел пользователь).
Почему так? Потому что оператор — это всего один символ, а строка может быть длинной.*/
                System.out.println("Введите второе число: ");
                double num2 = Double.parseDouble(scanner.nextLine());

                double result = calculate(num1, num2, operator);
                System.out.println("Результат: " + result);
            }catch (NumberFormatException e){
                System.out.println("Ошибка: введено некорректное число. Попробуйте снова.");
                continue;
            }catch (IllegalArgumentException e){
                System.out.println("Ошибка: " + e.getMessage());
                continue;
            }


            System.out.println("Хотите выполнить еще одну операцию? (да/нет)");
            String response = scanner.nextLine().toLowerCase();
            continueCaltulate = response.equals("да");
        }

        System.out.println("До свидания");
        scanner.close();

    }

    public static double calculate(double num1, double num2, char operator){
        switch (operator){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            case '/':
                if(num2 == 0){
                    throw new IllegalArgumentException("Деление на ноль невозможно!");
                }
                return num1/num2;

            default:
                throw new IllegalArgumentException("Некорректный оператор. Используйте +, -, *, или /.");
        }
    }
}
