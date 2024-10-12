package org.example;

import org.example.repository.RootsRepositoryImpl;
import org.example.repository.UserRepositoryImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static UserRepositoryImpl userRepository;
    private static RootsRepositoryImpl rootsRepository;

    public static void main(String[] args) {
        menuOne();
        String username = scanner.nextLine();
        menuTwo();
        String password = scanner.nextLine();
        String id = userRepository.checkPassword(username, password);
        if(id != null){
            menuFive(UUID.fromString(id));
        }
    }
    public static void menuOne(){
        System.out.println("""
                    
                    Akkountga kirish
                    
                    Username ni kiriting :  """);
    }

    public static void menuTwo(){
        System.out.println("""
                     
                     Password ni kiriting :  """);
    }

    public static void menuThree(){
        System.out.println("""
                    
                    Password yoki Username xato kiritildi! 
                    Qayta urinib ko'ring!
                    
                    """);
    }

    public static void menuFour(){
        List<String> data = new ArrayList<>();

    }

    public static void menuFive(UUID userId){
        System.out.println("""
                    
                    Sizning lug'atlaringiz
                    
                    """);

        List<String> distinctDates = rootsRepository.getDistinctDates(userId);
        for (int i = 0; i < distinctDates.size(); i++) {
            System.out.println((i + 1) + ". " + distinctDates.get(i));
        }

        System.out.print("\n\n Tanlab raqamini kiriting : ");
    }

}