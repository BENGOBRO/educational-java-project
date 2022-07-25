package coffee;

import java.util.Scanner;

public class CoffeeMachine {

    static final String buy = "buy";
    static final String fill = "fill";
    static final String take = "take";
    static final String remaining = "remaining";
    static final String exit = "exit";
    static final String espresso = "1";
    static final String latte = "2";
    static final String cappuccino = "3";
    static final String back = "back";

    static final int waterEspresso = 250;
    static final int waterLatte = 350;
    static final int waterCappuccino = 200;
    static final int milkLatte = 75;
    static final int milkCappuccino = 100;
    static final int coffeeEspresso = 16;
    static final int coffeeLatte = 20;
    static final int coffeeCappuccino = 12;
    static final int moneyEspresso = 4;
    static final int moneyLatte = 7;
    static final int moneyCappuccino = 6;

    int countWater = 400;
    int countMilk = 540;
    int countCoffee = 120;
    int countCups = 9;
    int money = 550;
    int toInt = 0;
    String amountToAdd = "";
    boolean terminate = false;

    static Scanner scanner = new Scanner(System.in);

    public String inputData() {
        String action = scanner.nextLine();
        return action;
    }

    public void buy() {
        System.out.println(" ");
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String decision = inputData();

        if (decision.equals(back)) {
            return;
        } else {
            if (countCups - 1 >= 0) {
                if (decision.equals(espresso)) {
                    if (countWater - waterEspresso >= 0 && countCoffee - coffeeEspresso >= 0) {
                        countWater -= waterEspresso;
                        countCoffee -= coffeeEspresso;
                        money += moneyEspresso;
                        countCups--;
                        System.out.println("I have enough resources, making you a coffee!");
                        System.out.println(" ");
                    } else if (countWater - waterEspresso < 0) {
                        System.out.println("Sorry, not enough water!");
                        System.out.println(" ");
                    } else {
                        System.out.println("Sorry, not enough coffee!");
                        System.out.println(" ");
                    }

                } else if (decision.equals(latte)) {
                    if (countWater - waterLatte >= 0 && countMilk - milkLatte >= 0 && countCoffee - coffeeLatte >= 0) {
                        countWater -= waterLatte;
                        countMilk -= milkLatte;
                        countCoffee -= coffeeLatte;
                        money += moneyLatte;
                        countCups--;
                        System.out.println("I have enough resources, making you a coffee!");
                        System.out.println(" ");
                    } else if (countWater - waterLatte < 0) {
                        System.out.println("Sorry, not enough water!");
                        System.out.println(" ");
                    } else if (countMilk - milkLatte < 0) {
                        System.out.println("Sorry, not enough milk!");
                        System.out.println(" ");
                    } else {
                        System.out.println("Sorry, not enough coffee!");
                        System.out.println(" ");
                    }

                } else if (decision.equals(cappuccino)) {
                    if (countWater - waterCappuccino >= 0 && countMilk - milkCappuccino >= 0 && countCoffee - coffeeCappuccino >= 0) {
                        countWater -= waterCappuccino;
                        countMilk -= milkCappuccino;
                        countCoffee -= coffeeCappuccino;
                        money += moneyCappuccino;
                        countCups--;
                        System.out.println("I have enough resources, making you a coffee!");
                        System.out.println(" ");
                    } else if (countWater - waterCappuccino < 0) {
                        System.out.println("Sorry, not enough water!");
                        System.out.println(" ");
                    } else if (countMilk - milkCappuccino < 0) {
                        System.out.println("Sorry, not enough milk!");
                        System.out.println(" ");
                    } else {
                        System.out.println("Sorry, not enough coffee!");
                        System.out.println(" ");
                    }
                }
            } else {
                System.out.println("Sorry, not enough cups!");
                System.out.println(" ");
            }
        }
    }

    public void fill() {
        System.out.println(" ");
        System.out.println("Write how many ml of water you want to add: ");
        amountToAdd = inputData();
        toInt = Integer.parseInt(amountToAdd);
        countWater += toInt;

        System.out.println("Write how many ml of milk you want to add: ");
        amountToAdd = inputData();
        toInt = Integer.parseInt(amountToAdd);
        countMilk += toInt;

        System.out.println("Write how many grams of coffee beans you want to add: ");
        amountToAdd = inputData();
        toInt = Integer.parseInt(amountToAdd);
        countCoffee += toInt;

        System.out.println("Write how many disposable cups of coffee you want to add: ");
        amountToAdd = inputData();
        toInt = Integer.parseInt(amountToAdd);
        countCups += toInt;
        System.out.println(" ");
    }

    public void take() {
        System.out.println(" ");
        System.out.println("I gave you $" + money);
        System.out.println(" ");
        money = 0;
    }

    public void remaining() {
        System.out.println(" ");
        System.out.println("The coffee machine has:");
        System.out.println(countWater + " ml of water");
        System.out.println(countMilk + " ml of milk");
        System.out.println(countCoffee + " g of coffee beans");
        System.out.println(countCups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println(" ");
    }

    public static void main(String[] args) {

        CoffeeMachine machine = new CoffeeMachine();

        while (!machine.terminate) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = machine.inputData();

            switch (action) {
                case buy:
                    machine.buy();
                    break;

                case fill:
                    machine.fill();
                    break;

                case take:
                    machine.take();
                    break;

                case remaining:
                    machine.remaining();
                    break;

                case exit:
                    machine.terminate = true;
                    break;

                default:
                    System.out.println("Он зашел сюда");
            }
        }
    }
}

