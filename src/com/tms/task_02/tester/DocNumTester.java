package com.tms.task_02.tester;

import java.io.*;
import java.util.*;

public class DocNumTester implements Tester {
    /**
     * Метод для запуска, проверки и сохранения данных в отчет
     */
    public void startProg() {
        Scanner scanner = new Scanner(System.in);
        List list = checkAndWriteAdressList(scanner);
        HashSet<String> docNum = checkAndWriteDocNumbersSet(list);
        HashMap<String, String> reportMap = checkAndWriteReportMap(docNum);
        saveReport(reportMap);

        scanner.close();
    }

    /**
     * Метод получает из консоли адреса документов и сохраняет их в ArrayList
     * @param scanner - принимаемая на вход, введенная с клавиатуры строка
     * @return - возвращает ArrayList адресов файлов
     */
    private ArrayList checkAndWriteAdressList(Scanner scanner) {
        var pathList = new ArrayList<>();
        try {
            for (; ; ) {
                System.out.println("Введите путь к файлу(адрес файла)... ");
                String path = scanner.next();
                if (path.equals("0")) {
                    System.out.println("Ввод  и сохранение адресов - Завершено! Количество введенных адресов - " + pathList.size());
                    break;
                }
                pathList.add(path);
            }
        } catch (
                InputMismatchException e) {
            System.out.println("Ошибка ввода адреса!");
        } finally {
            scanner.close();
        }
        return pathList;
    }

    /**
     * Метод считывает номера документов из файла и записыват в HashSet
     * @param list - приимаемый на вход Arraylist адресов документов
     * @return возвращает HashSet уникальных номеров документов
     */
    private static HashSet<String> checkAndWriteDocNumbersSet(List list) {
        HashSet<String> temp = new HashSet<>();
        //Считываем имена документов из фалов и сохраняем в HashSet
        for (Object element : list) {
            try (FileReader reader = new FileReader((String) element);
                 BufferedReader reader1 = new BufferedReader(reader)) {
                String line = reader1.readLine();
                while (line != null) {
                    temp.add(line);
                    line = reader1.readLine();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Считывание и сохранение номеров документов в HashSet - Завершено. Размер HashSet - " + temp.size());
        return temp;
    }

    /**
     * Метод проводит валидацию документов и записывает в HashMap с указанием результата проверки
     * @param mySet - принимаемый на вход HashSet номеров документов
     * @return - возвращает HashMap проверенных адресов
     */
    private static HashMap<String, String> checkAndWriteReportMap(HashSet<String> mySet) {
        HashMap<String, String> reportMap = new HashMap<>();
        String value = "";
        for (String element : mySet) {
            value = checkRules(element);
            reportMap.put(element, value);

        }
        System.out.println("Валидация номеров документов и заполнение МАПЫ - Завершено. Размер Мапы - " + reportMap.size());
        return reportMap;
    }

    /**
     * Метод сохраняет список адресов в файл отчета
     * @param map Принимаемый на вход HashMap проверенных номеров документов
     */
    private static void saveReport(HashMap<String, String> map) {
        try (FileWriter report = new FileWriter("D:\\TeachMeSkills\\TMS_Lesson_10_HW\\Report.txt")) {
            int count = 1;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                report.write(count + ". " + entry + "\n");
                count++;
            }

            System.out.println("Файл отчета создан.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param str
     * @return
     */
    private static String checkRules(String str) {
        String result = "";
        if (str != null) {
            if (str.length() != 15) {
                result = " Длина документа не соответствует регламенту.";

            } else if (checkStringStart(str, "docnum") || checkStringStart(str, "kontrakt")) {
                result = " Документ прошел валидацию";

            } else {
                result = " Формат документа не соответствует регламенту.";
            }

        }
        return result;
    }

    /**
     * Метод позволяет проверить, является ли заданная последовательность символов началом строки
     *
     * @param str          - строка, принимаемая на вход
     * @param charSequence - последовательность символов, принимаемая на вход
     * @return возвращает строку
     */
    private static boolean checkStringStart(String str, String charSequence) {
        String result = "";
        if (isValid(str)) {
            charSequence = charSequence.toLowerCase();
            str = str.toLowerCase();
            if (str.startsWith(charSequence)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Данный метод проверяет, корректно ли введена строка
     *
     * @param str - принимает введенную строку
     * @return - возвращает булево значние
     */
    private static boolean isValid(String str) {
        if (str != null && !str.isEmpty()) {
            return true;
        } else {
            System.out.print("Введенное значение не корректно. Строка пуста или null");
            return false;
        }
    }
}
