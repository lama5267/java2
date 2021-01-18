package ru.progwards.java2.lessons.calculator;

public class Calculator {
    String expr;
    int pos;

    boolean hasNex() {
        return pos < expr.length();
    }

    String getSym() throws Exception {//получает следующий символ
        if (!hasNex())//проверяет что допустим 2 + должна следовать число 2 + 2
            throw new Exception("unexpected end");
        return expr.substring(pos, ++pos);
    }

    String checkSym() throws Exception {//проверяет что идет дальше
        if (!hasNex())
            throw new Exception("unexpected end");
        return expr.substring(pos,pos+1);
    }

    int getNum() throws Exception {//получаем число
        return Integer.parseInt(getSym());
    }

    String okOperation(String op) throws Exception {
        if ("+-*/)".contains(op))
            return op;
        throw new Exception("unknown op "+op);
    }

    String getOperation() throws Exception {// получаем + - и тд
        return okOperation(getSym());
    }

    String checkOperation() throws Exception {
        return okOperation(checkSym());
    }


    public Calculator(String expr) {
        this.expr = expr;
        pos = 0;
    }

    int term2() throws Exception {
        String str = checkSym();
        if (str.equals("(")) {//проверяет на открытие скобки
            getSym();
            int res = expresion();//переходим в метод экспресиен
            if (getSym().equals(")"))
                return res;
            throw new Exception(") expected");
        } else
            return getNum();
    }

    int term() throws Exception {
        int res = term2();//вызывает терн 2
        while (hasNex()) {
            String op = checkOperation();
            if ("*/".contains(op)) {//проверяуем операц на умнож. и деление
                getOperation();
                int num = term2();
                switch (op) {
                    case "*" -> res *= num;
                    case "/" -> res /= num;
                }
            } else
                return res;
        }
        return res;
    }

    int expresion() throws Exception {
        int res = term();//вызывает терн
        while (hasNex()) {
            String op = checkOperation();
            if ("+-".contains(op)) {//проверяем + -
                getOperation();
                int num = term();
                switch (op) {
                    case "+" -> res += num;
                    case "-" -> res -= num;
                }
            } else
                return res;
        }
        return res;
    }

    // expression ::= number { (+-*/) number }число операция число

    // expression ::= term ("+"|"-") term
    // term ::= temr2 ("*"|"/") term2
    // term2 ::= "(" expression ")" | number
    static int calculate(String expr)  throws Exception {
        return new Calculator(expr).expresion();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(calculate("(2+3)*(2+2)"));
    }
}
