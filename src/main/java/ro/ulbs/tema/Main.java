package ro.ulbs.tema;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        p1();
    }

    static void p1(){
        List<Contact> contacts = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("input_tema.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                Contact contact = new Contact(parts[0], parts[1], parts[2], parts[3]);
                contacts.add(contact);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Contact c : contacts) {
            c.printContact();
        }
        System.out.println();
        Collections.sort(contacts, Comparator.comparing(Contact::getFirstName));
        Collections.sort(contacts, Comparator.comparing(Contact::getLastName));
        Collections.sort(contacts, Comparator.comparing(Contact::getPhoneType));
        for (Contact c : contacts) {
            c.printContact();
        }

        Map<String, Integer> phoneCounts = new HashMap<>();
        for (Contact contact : contacts) {
            phoneCounts.put(contact.phoneNumber, phoneCounts.getOrDefault(contact.phoneNumber, 0) + 1);
        }

        try{
            FileOutputStream fos = new FileOutputStream("output_tema.txt");
            OutputStreamWriter sw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(sw);
            for (Contact contact : contacts) {
                String line = contact.toString();
                if (phoneCounts.get(contact.phoneNumber) >= 2) {
                    line += " *";
                }
                writer.write(line);
                writer.write(System.lineSeparator());
                System.out.println("s-a scris");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
