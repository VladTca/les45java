import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BankAccaunt> list = List.of(
                new BankAccaunt(new Person("John", "Doe", "asv@gmail.com"), "1234567890", 1000.0),
                new BankAccaunt(new Person("Jane", "Doedfe", "asv@gmail.com"), "1234567890", 10.0),
                new BankAccaunt(new Person("John", "Doade", "asv@gmail.com"), "1234567890", 1.0),
                new BankAccaunt(new Person("Jane", "Afcvoe", "asv@gmail.com"), "1234567890", 78.0),
                new BankAccaunt(new Person("John", "Vlkjnoe", "asv@gmail.com"), "1234567890", 13000.0),
                new BankAccaunt(new Person("Jane", "Shloe", "asv@gmail.com"), "1234567890", 1900.0),
                new BankAccaunt(new Person("John", "Ldlskoe", "asv@gmail.com"), "1234567890", 230.0),
                new BankAccaunt(new Person("Jane", "Dsdoe", "asv@gmail.com"), "1234567890", 980.0),
                new BankAccaunt(new Person("John", "Lfmhncbgoe", "asv@gmail.com"), "1234567890", 120000.0),
                new BankAccaunt(new Person("Jane", "Foe", "asv@gmail.com"), "1234567890", 15000.0)

        );
        List<BankAccaunt> beggars = list.stream().filter(a -> a.balance() < 100).toList();
        beggars.forEach(System.out::println);
        System.out.println("=========================");

        List<Person> persons = list.stream().map(a -> a.owner()).toList();
        persons.forEach(System.out::println);
        System.out.println("=========================");

        List<String> richMan = list.stream()
                .filter(a -> a.balance() > 10000)
                .map(a -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(a.owner().lName()).append(" ").append(a.owner().fName().charAt(0)).append(".;")
                            .append("IBAN:").append(a.IBAN()).append(";").append(a.owner().email());
                    return sb.toString();
                })
                .toList();
        richMan.forEach(System.out::println);


    }

}