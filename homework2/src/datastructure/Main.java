package datastructure;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tree directory = new Tree("home");
        directory.addChild(directory.getRoot(), "Datastructure");
        directory.addChild(directory.getRoot(), "ComputerPractice");
        directory.addChild(directory.findNode("Datastructure"), "List");
        directory.addChild(directory.findNode("Datastructure"), "Tree");
        directory.addChild(directory.findNode("ComputerPractice"), "Java");
        directory.addChild(directory.findNode("ComputerPractice"), "CPP");
        directory.addChild(directory.findNode("List"), "ArrayList");
        directory.addChild(directory.findNode("List"), "LinkedList");

        System.out.println();
        System.out.println("Hello, Start Terminal..");
        Scanner scan = new Scanner(System.in);

        while (true) {
            String currentNodePath = directory.getCurrentNodePath();
            System.out.print("SC-Terminal : " + currentNodePath + " $ ");

            String cmdLine = scan.nextLine();
            if(cmdLine.equals("exit")) {
                break;
            }

            directory.executeCommand(cmdLine);
        }
        System.out.println("Bye, End Terminal..");
    }
}
