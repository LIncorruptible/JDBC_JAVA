package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Server
 * Permet de se connecter à la base de données
 * Initialise la base de données et les tables
 * Permet de stocker, récupérer des objets Book et Reader
 */
public class Server {
    /**
     * Déclaration d'un objet de type Connection
     */
    private Connection connection;

    /**
     * Méthode permettant de se connecter à la base de données
     * La base de données est nommée mabd
     * La base de données est créée si elle n'existe pas
     * Les tables sont créées si elles n'existent pas
     */
    public void connect() {
        String url = "jdbc:mysql://localhost:3306/mabd";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            createDatabase();
            createTables();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-2);
        }
    }

    /**
     * Méthode permettant de créer la base de données
     * Si la base de données existe déjà, elle ne sera pas recréée
     * Si la base de données n'existe pas, elle sera créée
     * La base de données est nommée mabd
     * La base de données est créée dans le serveur MySQL
     */
    public void createDatabase() {
        String query = "CREATE DATABASE IF NOT EXISTS mabd;";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("La base de données a été créée avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode permettant de créer les tables Books et Readers
     * Si les tables existent déjà, elles ne seront pas recréées
     * Si les tables n'existent pas, elles seront créées
     * La table Books contient les champs id, name et author
     * La table Readers contient les champs id, name et address
     * Les tables sont créées dans la base de données mabd
     */
    public void createTables() {
        String queryBooks = "CREATE TABLE IF NOT EXISTS Books ("
                + "id INT(11) NOT NULL AUTO_INCREMENT,"
                + "name VARCHAR(255) NOT NULL,"
                + "author VARCHAR(255) NOT NULL,"
                + "PRIMARY KEY (id));";
        String queryReaders = "CREATE TABLE IF NOT EXISTS Readers ("
                + "id INT(11) NOT NULL AUTO_INCREMENT,"
                + "name VARCHAR(255) NOT NULL,"
                + "address VARCHAR(255) NOT NULL,"
                + "PRIMARY KEY (id));";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(queryBooks);
            statement.executeUpdate(queryReaders);
            System.out.println("Les tables ont été créées avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode permettant de stocker un livre dans la base de données
     * Si le livre n'a pas de nom, il ne sera pas ajouté
     * @param book , le livre à ajouter
     */
    public void storeBook(Book book) {
        //Si le livre n'a pas de nom, on ne l'ajoute pas
        if (book.getName().equals("") && book.getAuthor().equals("")) {
            return;
        } else {
            String query = "INSERT INTO books (name, author) VALUES (?,?)";

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, book.getName());
                statement.setString(2, book.getAuthor());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Méthode permettant de vérifier si un livre existe déjà dans la base de données
     * @param book , le livre à vérifier
     * @return , true si le livre n'existe pas, false sinon
     */
    public boolean NonExistentBook(Book book) {
        String query = "SELECT * FROM books WHERE name = ? AND author = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            ResultSet result = statement.executeQuery();
            return !result.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Méthode permettant de stocker un lecteur dans la base de données
     * Si le lecteur n'a pas de nom, il ne sera pas ajouté
     * @param reader , le lecteur à ajouter
     */
    public void storeReader(Reader reader) {
        //Si le lecteur n'a pas de nom, on ne l'ajoute pas
        if (reader.getName().equals("") && reader.getAddress().equals("")) {
            return;
        } else {
            String query = "INSERT INTO readers (name, address) VALUES (?,?)";

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, reader.getName());
                statement.setString(2, reader.getAddress());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Méthode permettant de vérifier si un lecteur existe déjà dans la base de données
     * @param reader , le lecteur à vérifier
     * @return , true si le lecteur n'existe pas, false sinon
     */
    public boolean NonExistentReader(Reader reader) {
        String query = "SELECT * FROM readers WHERE name = ? AND address = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, reader.getName());
            statement.setString(2, reader.getAddress());
            ResultSet result = statement.executeQuery();
            return !result.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Méthode permettant de récupérer la liste des livres stockés dans la base de données
     * @return , la liste des livres
     */
    public List<Book> queryBookToList() {
        String query = "SELECT * FROM books";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            List<Book> bookList = new ArrayList<>();

            for (int i = 0; result.next(); i++) {
                Book book = new Book();
                book.setName(result.getString("name"));
                book.setAuthor(result.getString("author"));
                bookList.add(book);
            }

            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Méthode permettant de récupérer la liste des lecteurs stockés dans la base de données
     * @return , la liste des lecteurs
     */
    public List<Reader> queryReaderToList() {
        String query = "SELECT * FROM readers";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            List<Reader> readerList = new ArrayList<>();

            for (int i = 0; result.next(); i++) {
                Reader reader = new Reader();
                reader.setName(result.getString("name"));
                reader.setAddress(result.getString("address"));
                readerList.add(reader);
            }

            return readerList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Méthode de déconnexion de la base de données
     */
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}