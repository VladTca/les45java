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
       list = Main.getBankAccaunts();

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