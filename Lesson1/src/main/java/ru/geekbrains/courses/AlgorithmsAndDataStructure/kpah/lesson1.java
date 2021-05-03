package ru.geekbrains.courses.AlgorithmsAndDataStructure.kpah;

public class lesson1 {

    public static void main(String[] args) {
        //region1.1
//    Структура данных: данные о пациентах клиники.
//    Алгоритм: что бы напечатать слово на клавиатуре необходимо нажать клавишу, затем другую, третью, … ,если ошибся, то стереть и повторить снова ввод, и т.д.
        //endregion

        //region1.2
//    Структура данных в программировании - массив, стэк, очередь, графы, ….
//    Алгоритмы в программировании – поиск необходимого значения из массива данных.
        //endregion

        //region1.3
        // Ссылочный
        String a = "Hello World!";
        // Примитивный:
        int b = 3;
        // Свой класс:
        Cat c = new Cat("Name", "Color");

        System.out.println("Ссылочный: " + a);
        System.out.println("Примитивный: " + b);
        System.out.println("Свой класс: " + c.name);
        //endregion

        //region 1.4
        long t1 = System.nanoTime();
        int d = 5;
        int max;
        if(d >= b){
            max = d;
        } else{
            max = b;
        }
        System.out.println("Наибольшее значение: " + max);
        long t2 = System.nanoTime();
        long t = t2 - t1;
        System.out.println("Затраченное время: " + t + " нс");
        //endregion

    }

}
