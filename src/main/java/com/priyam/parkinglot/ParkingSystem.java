package com.priyam.parkinglot;

import com.priyam.parkinglot.model.ParkingLot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author prigupta8
 */
public class ParkingSystem {

    public static void main(String...strings) throws FileNotFoundException {

        ParkingSystem parkingSystem = new ParkingSystem();

        Scanner scanner = new Scanner(System.in);

        if(strings != null && strings.length > 0)  {
            File file = new File(strings[0]);
            scanner = new Scanner(file);
        }

        parkingSystem.initializeParkingSystem(scanner);

    }

    public ParkingLot initializeParkingSystem(Scanner scanner) {


        ParkingLot parkinglot = null;
        while(scanner.hasNext()) {
            String command = scanner.next();
            switch(command) {
                case "exit":
                    System.exit(0);
                    break;
                case "create_parking_lot":
                    parkinglot = new ParkingLot(scanner.nextInt());
                    System.out.println(String.format("Created a parking lot with %s slots", parkinglot.getSize()));
                    break;
                case "park":
                    if(parkinglot == null)
                        System.out.println("proivde the size of the parkin lot first");
                    else
                        System.out.println(parkinglot.parkCar(scanner.next(), scanner.next()));;
                    break;
                case "leave":
                    if(parkinglot == null)
                        System.out.println("proivde the size of the parkin lot first");
                    else
                        System.out.println(parkinglot.leaveCar(scanner.nextInt()));
                    break;
                case "status":
                    if(parkinglot == null)
                        System.out.println("proivde the size of the parkin lot first");
                    else
                        System.out.println(parkinglot.getParkingLotStatus());
                    break;
                case "registration_numbers_for_cars_with_colour":
                    if(parkinglot == null)
                        System.out.println("proivde the size of the parkin lot first");
                    else
                        System.out.println(parkinglot.getRegistrationNumbersByCarColor(scanner.next()));
                    break;
                case "slot_numbers_for_cars_with_colour":
                    if(parkinglot == null)
                        System.out.println("proivde the size of the parkin lot first");
                    else
                        System.out.println(parkinglot.getSlotNumbersByCarColor(scanner.next()));
                    break;
                case "slot_number_for_registration_number":
                    if(parkinglot == null)
                        System.out.println("proivde the size of the parkin lot first");
                    else
                        System.out.println(parkinglot.getSlotNumberByCarRegistrationNumber(scanner.next()));
                    break;

                default:
                    System.out.println("Invalid command");
                    break;
            }

        }
        return parkinglot;

    }

}
