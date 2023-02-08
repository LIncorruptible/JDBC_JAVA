package jdbc;

import java.util.List;

/**
 * Classe Client
 * Permet de se connecter/deconnecter au/du serveur et d'envoyer des objets Book et Reader
 */
public class Client {
    /**
     * Déclaration d'un objet de type Server
     */
    private Server server;

    /**
     * Connexion au serveur
     */
    public void connect() {
        server = new Server();
        server.connect();
    }

    /**
     * Envoi d'objet Book (livre) au serveur
     * @param book , le livre à envoyer
     */
    public void sendBook(Book book) {
        if (server.NonExistentBook(book)) {
            server.storeBook(book);
            System.out.println(book.toString() + "\nLe livre a été ajouté");
        } else {
            System.out.println(book.toString() + "\nLe livre existe déjà");
        }
    }

    /**
     * Envoi d'objet Reader (lecteur) au serveur
     * @param reader , le lecteur à envoyer
     */
    public void sendReader(Reader reader) {
        if (server.NonExistentReader(reader)) {
            server.storeReader(reader);
            System.out.println(reader.toString() + "\nLe lecteur a été ajouté");
        } else {
            System.out.println(reader.toString() + "\nLe lecteur existe déjà");
        }
    }

    /**
     * Envoi d'un couple livre/lecteur au serveur
     * @param book , le livre à envoyer
     * @param reader , le lecteur à envoyer
     */
    public void sendBookReader(Book book, Reader reader) {
        sendBook(book);
        sendReader(reader);
    }

    /**
     * Récupération de la liste des livres
     * @return , la liste des livres à partir d'une fonction de la classe Server
     */
    public List<Book> getBooks() {
        return server.queryBookToList();
    }

    /**
     * Récupération de la liste des lecteurs
     * @return , la liste des lecteurs à partir d'une fonction de la classe Server
     */
    public List<Reader> getReaders() {
        return server.queryReaderToList();
    }

    /**
     * Déconnexion du serveur
     */
    public void disconnect() {
        server.disconnect();
    }

}
