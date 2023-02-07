package object;

/**
 * Classe Reader
 * Permet de créer un lecteur
 * Un lecteur est caractérisé par un nom et une adresse mail
 * Il est possible de récupérer/modifier le nom et l'adresse mail du lecteur
 */
public class Reader {
    private String name;
    private String address;

    /**
     * Constructeur vide de la classe Reader
     */
    public Reader() {
        this.name = "";
        this.address = "";
    }

    /**
     * Constructeur de la classe Reader
     * @param name , le nom du lecteur
     * @param address , l'adresse mail du lecteur
     */
    public Reader(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Méthode permettant de récupérer le nom du lecteur
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Méthode permettant de modifier le nom du lecteur
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Méthode permettant de récupérer l'adresse mail du lecteur
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Méthode permettant de modifier l'adresse mail du lecteur
     * @param address , l'adresse mail du lecteur
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Méthode de surcharge de la méthode toString() de la classe Reader
     * @return
     */
    @Override
    public String toString() {
        return "Lecteur: \n Nom: " + name + "\n Adresse: " + address;
    }
}
