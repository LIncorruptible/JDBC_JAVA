package execute_app;

import jdbc.Book;
import jdbc.Client;
import jdbc.Reader;
import jdbc.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Client client = new Client();
        client.connect();

        Scanner input = new Scanner(System.in);

        //Variables Tampons pour les livres et les lecteurs
        String bookName, bookAuthor, readerName, readerAddress;
        Book book = null;
        Reader reader = null;
        List<Book> books = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();

        while (true) {
            System.out.println("\nChoisir une option parmis les suivantes : ");
            System.out.println("1. Saisir un livre");
            System.out.println("2. Saisir un lecteur");
            System.out.println("3. Envoyer les livres et les lecteurs au serveur");
            System.out.println("4. Lister les livres");
            System.out.println("5. Lister les lecteurs");
            System.out.println("6. Déconnecter");

            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Renseigner un nouveau livre :");

                    System.out.println("Entrez le nom du livre :");
                    bookName = input.nextLine();

                    System.out.println("Entrez l'auteur du livre :");
                    bookAuthor = input.nextLine();

                    book = new Book(bookName, bookAuthor);

                    if (books.contains(book)) {
                        System.out.println("Le livre existe déjà");
                    } else {
                        books.add(book);
                        System.out.println("Le livre a été ajouté");
                    }
                    break;
                case 2:
                    System.out.println("Renseigner un nouveau lecteur :");

                    System.out.println("Entrez le nom du lecteur :");
                    readerName = input.nextLine();

                    System.out.println("Entrez l'adresse @ du lecteur :");
                    readerAddress = input.nextLine();

                    reader = new Reader(readerName, readerAddress);

                    if (readers.contains(reader)) {
                        System.out.println("Le lecteur existe déjà");
                    } else {
                        readers.add(reader);
                        System.out.println("Le lecteur a été ajouté");
                    }
                    break;
                case 3:
                    System.out.println("Envoi les livres et lecteurs saisis au serveur :");

                    for (Book b : books) { client.sendBook(b); }
                    for (Reader r : readers) { client.sendReader(r); }

                    System.out.println("Envoi terminé");
                    books.clear();
                    readers.clear();
                    break;
                case 4:
                    System.out.println("Liste des livres :");
                    for (Book b : client.getBooks()) {
                        System.out.println(b);
                    }
                    break;
                case 5 :
                    System.out.println("Liste des lecteurs :");
                    for (Reader r : client.getReaders()) {
                        System.out.println(r);
                    }
                    break;
                case 6:
                    client.disconnect();
                    System.out.println("Déconnecté avec succès!");
                    System.exit(0);
                default:
                    System.out.println("Option non valide!");
                    break;
            }
        }
    }
}

