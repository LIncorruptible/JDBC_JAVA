package execute_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import object.Book;
import object.Reader;
public class MainProgram {
    public static void main(String[] args) {
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
            System.out.println("3. Afficher les livres et les lecteurs");
            System.out.println("4. Stopper l'application");

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
                    System.out.println("Liste des livres :");
                    for (Book b : books) { System.out.println(b); }
                    System.out.println("Liste des lecteurs :");
                    for (Reader r : readers) { System.out.println(r); }
                    break;
                case 4:
                    System.out.println("Fin de l'application");
                    System.exit(0);
                default:
                    System.out.println("Option non valide!");
                    break;
            }
        }
    }
}

