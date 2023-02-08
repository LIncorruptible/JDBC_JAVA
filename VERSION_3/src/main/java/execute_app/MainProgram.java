package execute_app;

import jdbc.Book;
import jdbc.Client;
import jdbc.Reader;
import jdbc.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe MainProgram
 * Permet de lancer l'application
 * Permet de créer un client et de se connecter au serveur
 * Permet de récupérer les informations saisies par l'utilisateur
 * Permet d'envoyer les informations saisies par l'utilisateur au serveur
 * Permet de récupérer la liste des livres et des lecteurs
 * Permet d'afficher la liste des livres et des lecteurs de la BDD
 */
public class MainProgram {
    public static void main(String[] args) {

        /**
         * Création d'un objet de type Client
         * Connexion au serveur
         */
        Client client = new Client();
        client.connect();

        /**
         * Création d'un objet de type Scanner
         * Permet de récupérer les informations saisies par l'utilisateur
         */
        Scanner input = new Scanner(System.in);

        /**
         * Déclaration des variables
         * bookName, bookAuthor, readerName, readerAddress : les variables qui vont contenir les informations saisies par l'utilisateur
         * book : le livre qui va être ajouté à la liste des livres
         * reader : le lecteur qui va être ajouté à la liste des lecteurs
         * books : la liste des livres
         * readers : la liste des lecteurs
         */
        String bookName, bookAuthor, readerName, readerAddress;
        Book book = null;
        Reader reader = null;
        List<Book> books = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();

        while (true) {
            System.out.println("\nChoisir une option parmis les suivantes : ");
            System.out.println("1. Saisir un livre");
            System.out.println("2. Saisir un lecteur");
            System.out.println("3. Envoyer les livres et les lecteurs saisies au serveur");
            System.out.println("4. Lister les livres de la BDD");
            System.out.println("5. Lister les lecteurs de la BDD");
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

