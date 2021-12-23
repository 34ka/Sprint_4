package praktikum;

public class Praktikum {

    static String nameAndSurname = "ТимотейШевроле";

    public static void main(String[] args) {
        Account account = new Account(nameAndSurname);

        account.checkNameToEmboss();
    }
}
