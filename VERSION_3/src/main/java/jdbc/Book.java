package jdbc;

public class Book {
    private String name;
    private String author;

    /**
     * Constructeur vide de la classe Book
     */
    public Book() {
        this.name = "";
        this.author = "";
    }

    /**
     * Constructeur de la classe Book
     * @param name , le nom du livre
     * @param author , l'auteur du livre
     */
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    /**
     * Méthode permettant de récupérer le nom du livre
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Méthode permettant de modifier le nom du livre
     * @param name , le nouveau nom du livre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Méthode permettant de récupérer l'auteur du livre
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Méthode permettant de modifier l'auteur du livre
     * @param author , le nouveau nom de l'auteur
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Méthode de surcharge de la méthode toString() de la classe Book
     * @return
     */
    @Override
    public String toString() {
        return "Livre: \n Nom: " + name + "\n Auteur: " + author;
    }
}