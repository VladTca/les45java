import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
private List<BankAccaunt> list;
    @BeforeEach
    void setUp() {
       list = List.of(
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

    }

    @Test
    @DisplayName("Get accounts with balance under 100")
    void testGetAccountsWithLowBalance() {
        List<BankAccaunt> accounts =new ArrayList<>(list);

        List<BankAccaunt> result = accounts.stream().filter(a -> a.balance() < 100).toList();

        assertEquals(3, result.size());
        assertEquals("Doedfe", result.get(0).owner().lName());
        assertEquals(10.0, result.get(0).balance());
    }

    @Test
    @DisplayName("Get list of all account owners")
    void testGetAllAccountOwners() {
        List<BankAccaunt> accounts = new ArrayList<>(list);

        List<Person> result = accounts.stream().map(BankAccaunt::owner).toList();

        assertEquals(10, result.size());
        assertEquals("John", result.get(0).fName());
        assertEquals("Jane", result.get(1).fName());
    }

    @Test
    @DisplayName("Format rich accounts with balance above 10000")
    void testFormatRichAccounts() {
        List<BankAccaunt> accounts = new ArrayList<>(list);

        List<String> result = accounts.stream()
                .filter(a -> a.balance() > 10000)
                .map(a -> a.owner().lName() + " " + a.owner().fName().charAt(0) + ".;" +
                        "IBAN:" + a.IBAN() + ";" + a.owner().email())
                .toList();

        assertEquals(3, result.size());
        assertEquals("Vlkjnoe J.;IBAN:1234567890;asv@gmail.com", result.get(0));
    }
}