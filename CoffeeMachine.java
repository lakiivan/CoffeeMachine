package machine;

import java.util.Scanner;

public class CoffeeMachine {
    int water;
    int milk;
    int coffeeBeans;
    int cups;
    int money;
    boolean notExit = true;
    static Scanner scanner2;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.cups = 9;
        this.money = 550;
        this.scanner2 = new Scanner(System.in);
    }

    public static void main(String[] args) {
        //stage 1
        //printIntroductionLines();

        //stage 2
        //Scanner scanner = new Scanner(System.in);
        //String necessaryIngidients = partyCheckNecessaryIngridients(scanner);
        //System.out.println(necessaryIngidients);

        //stage 3
        //String info = canItBeMade(scanner);
        //System.out.println(info);

        //stage 4
        //CoffeeMachine coffeeMachine = new CoffeeMachine();
        //System.out.println(coffeeMachine.machineStatus());
        //coffeeMachine.oneInteraction(scanner);
        //System.out.println(coffeeMachine.machineStatus());

        //stage 5
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (coffeeMachine.notExit) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner2.nextLine();
            System.out.println("Current action is " + action);
            coffeeMachine.checkAction(action);
        }
    }

    private void oneInteraction(Scanner scanner) {
        System.out.println("Write action (buy, fill, take): ");
        String action = scanner.nextLine();
        checkAction(action);
    }

    private void chooseAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner2.nextLine();
        checkAction(action);
    }

    private void checkAction(String action) {
        if (action.equals("buy")) {
            callBuyAction();
        } else if (action.equals("fill")) {
            callFillAction();
        } else if (action.equals("take")) {
            callTakeAction();
        } else if (action.equals("remaining")) {
            System.out.println(machineStatus());
        } else if (action.equals("exit")) {
            this.notExit = false;
        } else {
            System.out.println("Check action - You didnt choose valid action");
            System.out.println("");
        }
    }

    private void callTakeAction() {
        System.out.println("I gave you $" + this.money + "\n");
        this.money = 0;
    }

    private void callFillAction() {
        System.out.println("Write how many ml of water do you want to add: ");
        String waterAddedS = scanner2.nextLine();
        int waterAdded = Integer.parseInt(waterAddedS);
        this.water += waterAdded;
        System.out.println("Write how many ml of milk do you want to add: ");
        String milkAddedS = scanner2.nextLine();
        int milkAdded = Integer.parseInt(milkAddedS);
        this.milk += milkAdded;
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        String coffeeBeansAddedS = scanner2.nextLine();
        int coffeeBeansAdded = Integer.parseInt(coffeeBeansAddedS);
        this.coffeeBeans += coffeeBeansAdded;
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        String cupsAddedS = scanner2.nextLine();
        int cupsAdded = Integer.parseInt(cupsAddedS);
        this.cups += cupsAdded;
    }

    private void callBuyAction() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String choice = scanner2.nextLine();
        if (choice.equals("back")) {
            chooseAction();
        } else if (choice.equals("1")) {
            buyEspresso();
        } else if (choice.equals("2")) {
            buyLatte();
        } else if (choice.equals("3")) {
            buyCappuccino();
        } else {
            System.out.println("You didnt make valid choice!");
        }
    }

    private void buyEspresso() {
        boolean isPossible = true;
        if (this.water >= 250) {
            this.water -= 250;
        } else {
            System.out.println("Sorry, not enough water!");
            isPossible = false;
        }
        if (isPossible) {
            if (this.coffeeBeans >= 16) {
                this.coffeeBeans -= 16;
            } else {
                System.out.println("Sorry, not enough coffee beans!");
                isPossible = false;
            }
        }

        if (this.cups >= 1 && isPossible) {
            this.cups--;
        } else if (isPossible) {
            System.out.println("Sorry, not enough cups!");
            isPossible = false;
        }
        if (isPossible) {
            System.out.println("I have enough resources, making you a coffee!");
            this.money += 4;
        }
    }

    private void buyLatte() {
        boolean isPossible = true;
        if (this.water >= 350) {
            this.water -= 350;
        } else {
            System.out.println("Sorry, not enough water!");
            isPossible = false;
        }
        if (this.milk >= 75 && isPossible) {
            this.milk -= 75;
        } else if (isPossible) {
            System.out.println("Sorry, not enough milk!");
            isPossible = false;
        }

        if (this.coffeeBeans >= 20 && isPossible) {
            this.coffeeBeans -= 20;
        } else if (isPossible) {
            System.out.println("Sorry, not enough coffee beans!");
            isPossible = false;
        }
        if (this.cups >= 1 && isPossible) {
            this.cups--;
        } else if (isPossible) {
            System.out.println("Sorry, not enough cups!");
            isPossible = false;
        }
        if (isPossible) {
            System.out.println("I have enough resources, making you a coffee!");
            this.money += 7;
        }
    }

    private void buyCappuccino() {
        boolean isPossible = true;
        if (this.water >= 200) {
            this.water -= 200;
        } else {
            System.out.println("Sorry, not enough water!");
            isPossible = false;
        }
        if (this.milk >= 100 && isPossible) {
            this.milk -= 100;
        } else if (isPossible) {
            System.out.println("Sorry, not enough milk!");
            isPossible = false;
        }

        if (this.coffeeBeans >= 12 && isPossible) {
            this.coffeeBeans -= 12;
        } else if (isPossible) {
            System.out.println("Sorry, not enough coffee beans!");
            isPossible = false;
        }
        if (this.cups >= 1 && isPossible) {
            this.cups--;
        } else if (isPossible) {
            System.out.println("Sorry, not enough cups!");
            isPossible = false;
        }
        if (isPossible) {
            System.out.println("I have enough resources, making you a coffee!");
            this.money += 6;
        }
    }

    private String machineStatus() {
        String status;
        String firstLine = "The coffee machine has:";
        String water = String.format("%d of water  %n", this.water);
        String milk = String.format("%d of milk  %n", this.milk);
        String coffeeBeans = String.format("%d of coffee beans %n", this.coffeeBeans);
        String cups = String.format("%d of disposable cups %n", this.cups);
        String money = String.format("%d of money %n", this.money);
        status = firstLine + "\n" + water + milk + coffeeBeans + cups + money;
        return status;
    }


    private static void printIntroductionLines() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    private static String partyCheckNecessaryIngridients() {
        System.out.println("Write how many cups of coffee you will need:");
        int noCupsCoffee = scanner2.nextInt();
        int water = calculateWater(noCupsCoffee);
        int milk = calculateMilk(noCupsCoffee);
        int coffeeBeans = calculateCoffeeBeans(noCupsCoffee);
        String intro = String.format("For %d  cups of coffee you will need:", noCupsCoffee);
        String necessaryWater = String.format("%d ml of water", water);
        String necessaryMilk = String.format("%d ml of milk", milk);
        String necessaryCoffeeBeans = String.format("%d g of coffee beans", coffeeBeans);
        return intro + "\n" + necessaryWater + "\n" + necessaryMilk + "\n" + necessaryCoffeeBeans;
    }

    private static int calculateWater(int noCupsCoffee) {
        return noCupsCoffee * 200;
    }

    private static int calculateMilk(int noCupsCoffee) {
        return noCupsCoffee * 50;
    }

    private static int calculateCoffeeBeans(int noCupsCoffee) {
        return noCupsCoffee * 15;
    }

    private static String canItBeMade(Scanner scanner) {
        System.out.println("Write how many ml of water the coffee machine has: ");
        int mlWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int mlMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int gCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int noOfCups = scanner.nextInt();
        int noOfCupsThatCanBeMade = calculateNoOfCupsThatCanBeMade(mlWater, mlMilk, gCoffeeBeans);
        return whatCanBeMade(noOfCups, noOfCupsThatCanBeMade);
    }

    private static int calculateNoOfCupsThatCanBeMade(int mlWater, int mlMilk, int gCoffeeBeans) {
        int noOfCupsThatCanBeMade = 0;
        int currWater = mlWater;
        int currentMilk = mlMilk;
        int currentCoffeeBeans = gCoffeeBeans;
        while (canCupBeMade(currWater, currentMilk, currentCoffeeBeans)) {
            currWater -= 200;
            currentMilk -= 50;
            currentCoffeeBeans -= 15;
            noOfCupsThatCanBeMade++;
        }
        return noOfCupsThatCanBeMade;
    }

    private static boolean canCupBeMade(int currWater, int currentMilk, int currentCoffeeBeans) {
        return currWater >= 200 && currentMilk >= 50 && currentCoffeeBeans >= 15;
    }

    private static String whatCanBeMade(int noOfCups, int noOfCupsThatCanBeMade) {
        String canItBeMade;
        int diff = Math.abs(noOfCups - noOfCupsThatCanBeMade);
        if (noOfCups == noOfCupsThatCanBeMade) {
            canItBeMade = "Yes, I can make that amount of coffee";
        } else if (noOfCups >= noOfCupsThatCanBeMade) {
            canItBeMade = "No, I can make only " + noOfCupsThatCanBeMade + " cup(s) of coffee";
        } else {
            canItBeMade = "Yes, I can make that amount of coffee (and even " + diff + " more than that)";
        }
        return canItBeMade;
    }
}
