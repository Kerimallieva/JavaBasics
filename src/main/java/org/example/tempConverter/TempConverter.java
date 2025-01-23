package org.example.tempConverter;

import java.util.Scanner;

/*
Конвертер температуры

Описание: Напиши программу, которая будет конвертировать температуру между:

Цельсиями (°C)
Кельвинами (K)
Фаренгейтами (°F)
Пример работы программы:

mathematica
Копировать
Редактировать
Введите температуру: 25
Введите единицу измерения (C, K, F): C
Введите единицу, в которую хотите перевести (C, K, F): F
Результат: 77.0°F
Хотите выполнить еще одну операцию? (да/нет): да
...
* */
public class TempConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean wantContinueCalculate = true;

        System.out.println("Добро пожаловать в TempConverter!");

        while (wantContinueCalculate){
            try {
                System.out.println("Введите температуру: ");
                double temp = Double.parseDouble(scanner.nextLine());

                System.out.println("Введите единицу измерения (C, K, F): ");
                char temp1 = scanner.nextLine().charAt(0);

                System.out.println("Введите единицу, в которую хотите перевести (C, K, F): ");
                char temp2 = scanner.nextLine().charAt(0);


                double result = tempConverter(temp, temp1,temp2);
                System.out.println("Результат:" + result);
            }catch (NumberFormatException e){
                System.out.println("Ошибка: введите корректное число.");
            }catch (IllegalArgumentException e){
                System.out.println("Ошибка: " + e.getMessage());
            }

            System.out.println("Хотите продолжить? (да/нет)");
            String response = scanner.nextLine().toLowerCase();
            wantContinueCalculate = response.equals("да");

        }

        System.out.println("До свидания");
        scanner.close();
    }

    private static double tempConverter(double temp, char temp1, char temp2) {
        if (temp1 == temp2){
            return temp;
        }

        switch (temp1){
            case 'C':
                if(temp2 == 'F'){
                    return temp * 9/5 + 32;
                }else if(temp2 == 'K'){
                    return temp + 273.15;
                }
                break;
            case 'K':
                if(temp2 == 'C'){
                    return temp - 273.15;
                }else if(temp2 == 'F'){
                    return (temp - 273.15) * 9/5 + 32;
                }
                break;
            case 'F':
                if(temp2 == 'C'){
                    return (temp - 32) * 5/9;
                }else if(temp2 == 'K'){
                    return (temp - 32) * 5/9 + 273.15;
                }
                break;
            default:
                throw  new IllegalArgumentException("Некорректная единица измерения!");
        }
        throw new IllegalArgumentException("Некорректное преобразование!");
    }
}
