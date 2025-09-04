package quizgame;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class CustomerSupport {
    static Scanner  sc = new Scanner(System.in);
    static final String logFile = "/home/sukish/IdeaProjects/ConsoleBasedQuizGame/Log";

    public static void mainPage(){
        System.out.println("Welcome to customer support page");
        System.out.println("""
                1.Raise a ticket
                2.Review ticket
                3.return to main menu
                """);
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                customerQueries();
                break;
            case 2:
               reviewTicket();
               break;
            case 3:
                QuizGame.quizGame();
                break;
        }
    }

    public static void customerQueries(){
        final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm:ss");
        System.out.println("Frequently asked questions: ");
        System.out.println("""
                1.Problem in Timer
                2.Marks isn't updating properly
                3.Leaderboard not updating
                4.If your problem isn't listed here enter 4
                """);
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                System.out.println("Timer option is only available in medium and hard level."+'\n'+"Which level did you select?");
                QuizGame.displayLevel();
                int choice = sc.nextInt();
                sc.nextLine();
                if(choice == 1){
                    System.out.println("Timer isn't available in easy level try other modes for timer.");
                } else if (choice == 2 || choice == 3) {
                    System.out.println("Sorry for the inconvenience can you enter the specific problem down below.");
                    String log = sc.nextLine();
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(logFile))) {
                        LocalDateTime timeAndDate = LocalDateTime.now();
                        String formatedDate = timeAndDate.format(dateFormat);
                        Random random = new Random();
                        int ticketNumber = random.nextInt(9999) + 1000;
                        bw.write("Ticket number: "+ticketNumber);
                        bw.newLine();
                        bw.write(" | Problem in timer: ");
                        bw.write(log + " | ");
                        bw.write(" Log entered at: "+formatedDate + '|');
                        bw.newLine();
                        bw.flush();
                        System.out.println("Your ticket has been raised we will get back to you." +'\n'+"Ticket Number: "+ticketNumber);
                        System.out.println("Returning to main menu");
                        mainPage();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }else {
                    System.out.println("Invalid option returning to main page.");
                    mainPage();
                }
                break;
            case 2:
                System.out.println("Which difficulty did you face the issue? ");
                QuizGame.displayLevel();
                choice = sc.nextInt();
                if(choice == 3){
                    System.out.println("Hard mode has negative marks of 1 for wrong answers.");
                    System.out.print("If you checked it and still facing problem then press (y): ");

                }
        }
    }

    public static void reviewTicket(){
        System.out.println("Enter your ticket number to review it.");
        int ticketNumber = sc.nextInt();
        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line = br.readLine();
            String newLine;
            if(line.contains(ticketNumber+"")){
                System.out.println(line);
                while ((newLine = br.readLine()) != null){
                    System.out.println(newLine);
                }
            }else System.out.println("Invalid ticket number");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}