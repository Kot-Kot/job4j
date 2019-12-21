package ru.job4j.loop;

public class Fitness {
    public int calc(int ivan, int nik) {
        //Иван за месяц увеличивает силу тяги в 3 раза за счет такой диеты,
        // а Николай - за месяц увеличивает силу тяги в 2 раза.
        int month = 0;
        while (ivan < nik) {
            month++;
            ivan *= 3;
            nik *= 2;
        }
        return month;
    }
}
