package execute_app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import object.Book;
import object.Reader;

/**
 * Classe MainProgram
 * Permet de lancer l'application
 * Permet de gérer les livres et les lecteurs
 * Permet d'écrire et de lire les livres et les lecteurs dans un fichier
 * Permet d'afficher la liste des livres et des lecteurs
 * Permet de récupérer la liste des livres et des lecteurs depuis un fichier
 */
public class MainProgram {
    /**
     * Ecrire les lecteurs dans un fichier
     * @param readers , la liste des lecteurs
     * @return , true si l'écriture s'est bien passée, false sinon
     */
    public static boolean writeReaderToFile(List<Reader> readers) {
        try {
            FileWriter fw = new FileWriter("readers.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Reader r : readers) {
                bw.write(r.getName() + "_" + r.getAddress());
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Lire les lecteurs depuis un fichier
     * @param readers , la liste des lecteurs
     * @return , true si la lecture s'est bien passée, false sinon
     */
    public static boolean readReaderFromFile(List<Reader> readers) {
        try {
            Scanner input = new Scanner(new File("readers.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] reader = line.split("_");
                readers.add(new Reader(reader[0], reader[1]));
            }
            input.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Ecrire les livres dans un fichier
     * @param books , la liste des livres
     * @return , true si l'écriture s'est bien passée, false sinon
     */
    public static boolean writeBookToFile(List<Book> books) {
        try {
            FileWriter fw = new FileWriter("books.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Book b : books) {
                bw.write(b.getName() + "_" + b.getAuthor());
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Lire les livres depuis un fichier
     * @param books , la liste des livres
     * @return , true si la lecture s'est bien passée, false sinon
     */
    public static boolean readBookFromFile(List<Book> books) {
        try {
            Scanner input = new Scanner(new File("books.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] book = line.split("_");
                books.add(new Book(book[0], book[1]));
            }
            input.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Variables Tampons pour les livres et les lecteurs
        String bookName, bookAuthor, readerName, readerAddress;
        Book book = null;
        Reader reader = null;
        List<Book> books = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();

        //Créer les fichiers s'ils n'existent pas
        try {
            File booksFile = new File("books.txt");
            File readersFile = new File("readers.txt");
            if (booksFile.createNewFile()) {
                System.out.println("Fichier books.txt créé");
            }
            if (readersFile.createNewFile()) {
                System.out.println("Fichier readers.txt créé");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Lecture des livres et des lecteurs depuis les fichiers
        if (readBookFromFile(books) && readReaderFromFile(readers)) {
            System.out.println("Lecture des livres et des lecteurs terminée");
        } else {
            System.out.println("Erreur lors de la lecture des livres et des lecteurs");
        }

        while (true) {
            System.out.println("\nChoisir une option parmis les suivantes : ");
            System.out.println("1. Saisir un livre");
            System.out.println("2. Saisir un lecteur");
            System.out.println("3. Afficher les livres et les lecteurs");
            System.out.println("4. Stocker les livres et les lecteurs dans un fichier");
            System.out.println("5. Stopper l'application");

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
                    System.out.println("Stockage des livres et des lecteurs dans un fichier");
                    if (writeBookToFile(books) && writeReaderToFile(readers)) {
                        System.out.println("Stockage terminé");
                    } else {
                        System.out.println("Erreur lors du stockage");
                    }
                    break;
                case 5:
                    System.out.println("Fin de l'application");
                    System.exit(0);
                default:
                    System.out.println("Option non valide!");
                    break;
            }
        }
    }
}

