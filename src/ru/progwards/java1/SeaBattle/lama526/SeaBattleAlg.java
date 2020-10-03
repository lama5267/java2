package ru.progwards.java1.SeaBattle.lama526;

import ru.progwards.java1.SeaBattle.SeaBattle;
import java.util.Arrays;

public class SeaBattleAlg {
    // Тестовое поле создаётся конструктором
    //     SeaBattle seaBattle = new SeaBattle(true);
    //
    // Обычное поле создаётся конструктором по умолчанию:
    //     SeaBattle seaBattle = new SeaBattle();
    //     SeaBattle seaBattle = new SeaBattle(false);
    //
    // Посомтреть результаты стрельбы можно в любой момент,
    // выведя объект класса SeaBattle на консоль. Например так:
    //     System.out.println(seaBattle);
    //
    //
    // Вид тестового поля:
    //
    //           0 1 2 3 4 5 6 7 8 9    координата x
    //         0|.|.|.|.|.|.|.|X|.|.|
    //         1|.|.|.|.|.|X|.|.|.|.|
    //         2|X|X|.|.|.|.|.|.|.|.|
    //         3|.|.|.|.|.|.|.|X|X|X|
    //         4|.|.|.|.|X|.|.|.|.|.|
    //         5|.|.|.|.|X|.|.|Х|.|.|
    //         6|.|.|.|.|.|.|.|Х|.|X|
    //         7|X|.|X|.|.|.|.|Х|.|X|
    //         8|X|.|.|.|.|.|.|X|.|.|
    //         9|X|.|.|.|X|.|.|.|.|.|

    private static final int MINUS = 0b01; // стреляем в уменьшение координаьы
    private static final int PLUS = 0b10; // стреляем в увеличение координаты

    char field[][];
    SeaBattle seaBattle;
    int hits;
    boolean doPrint = true;

    void init(SeaBattle seaBattle) {
        this.seaBattle = seaBattle;
        hits = 0;
        field = new char[seaBattle.getSizeY()][seaBattle.getSizeX()];
        for (int i = 0; i < seaBattle.getSizeY(); i++) {
            Arrays.fill(field[i], ' ');
        }
    }

    void print() {
        if (!doPrint)
            return;
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            String str = "|";
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                str += field[y][x] + "|";
            }
            System.out.println(str);
        }
        System.out.println("------------------------------------");
    }

    boolean checkCoords(int x, int y) {
        return x >= 0 && x < seaBattle.getSizeX() && y >= 0 && y < seaBattle.getSizeY();
    }

    void incHit(SeaBattle.FireResult result) {
        if (result != SeaBattle.FireResult.MISS)
            hits++;
    }

    void markFire(int x, int y, SeaBattle.FireResult result) {
        if (result == SeaBattle.FireResult.MISS)
            field[y][x] = '*';
        else
            field[y][x] = 'X';
    }

    SeaBattle.FireResult fire(int x, int y) {
        if (checkCoords(x,y) && hits < 20 && field[y][x] == ' ') {
            SeaBattle.FireResult result = seaBattle.fire(x, y);
            markFire(x, y, result);
            incHit(result);
            if (result == SeaBattle.FireResult.DESTROYED)
                markDestroyed();
            print();
            return  result;
        }
        return SeaBattle.FireResult.MISS;
    }

    private void markDestroyed() {
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                if (field[y][x] == 'X')
                    markDestroyed(x, y);
            }
        }
    }

    void markDestroyed(int x, int y) {
        markDot(x-1, y-1);
        markDot(x-1, y);
        markDot(x-1, y+1);
        markDot(x+1, y-1);
        markDot(x+1, y);
        markDot(x+1, y+1);
        markDot(x, y-1);
        markDot(x, y+1);
    }

    private void markDot(int x, int y) {
        if (checkCoords(x,y) && field[y][x] == ' ') {
            field[y][x] = '.';
        }
    }

    SeaBattle.FireResult fireAndKill(int x, int y) {
        SeaBattle.FireResult result = fire(x, y);
        if (result == SeaBattle.FireResult.HIT)
            killShip(x,y);
        return result;
    }

    private void killShip(int x, int y) {
        boolean desytroyed = killVertikal(x,y);
        if (!desytroyed)
            killHorisontal(x,y);
    }

    int direction;
    private boolean killHorisontal(int x, int y) {
        direction = PLUS | MINUS;
        boolean destroyed = false;
        int i = 1;
        do {
            if ((direction&PLUS) != 0)
                destroyed = checkHit(fire(x+i, y), PLUS);
            if ((direction&MINUS) != 0)
                destroyed = checkHit(fire(x-i, y), MINUS);
            i++;
        } while (direction != 0 && !destroyed);
        return destroyed;
    }

    private boolean killVertikal(int x, int y) {
        direction = PLUS | MINUS;
        boolean destroyed = false;
        int i = 1;
        do {
            if ((direction&PLUS) != 0)
                destroyed = checkHit(fire(x, y+i), PLUS);
            if ((direction&MINUS) != 0)
                destroyed = checkHit(fire(x, y-i), MINUS);
            i++;
        } while (direction != 0 && !destroyed);
        return destroyed;
    }

    private boolean checkHit(SeaBattle.FireResult result, int fireDirection) {
        switch (result) {
            case DESTROYED :
                direction = 0;
                return true;
            case HIT:
                return false;
            case MISS:
                direction &= ~fireDirection;
                return false;
            default:
                return false;
        }
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        init(seaBattle);
        algorithm3();
    }

    void stepFire(int offset) {
        for (int y = 0; y < seaBattle.getSizeY(); y++) {
            for (int x = y+offset; x < seaBattle.getSizeX(); x+=4)
                fireAndKill(x, y);

            for (int x = y-offset; x >= 0; x-=4)
                fireAndKill(x, y);
        }
    }

    void algorithm3() {
        stepFire(3);
        stepFire(1);
        stepFire(0);
        stepFire(2);
    }

    void algoritm1() {
        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                SeaBattle.FireResult fireResult = fireAndKill(x,y);
            }
        }
    }


    static void test() {
        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        System.out.println(seaBattle.getResult());
    }

    static void comp() {
        SeaBattleAlg alg = new SeaBattleAlg();
        alg.doPrint = false;
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            SeaBattle seaBattle = new SeaBattle();
            alg.battleAlgorithm(seaBattle);
            result += seaBattle.getResult();
        }
        System.out.println(result/1000);
    }

    // функция для отладки
    public static void main(String[] args) {
        test();
    }
}

