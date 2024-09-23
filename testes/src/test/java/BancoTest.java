import com.example.Banco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BancoTest {

    private static Banco b;

    @BeforeEach
    public void setUp(){
        b = new Banco("123", 1000);
    }

    @Test
    public void testAccountHolder(){
        String result = b.getAccountHolder();
        assertEquals("123",result);
    }

    @Test
    public void testNotAccountHolder(){
        String result = b.getAccountHolder();
        assertNotEquals("132",result);
    }

    @Test
    public void testAccountHolderInt(){
        String result = b.getAccountHolder();
        assertNotEquals(132,result);
    }

    @Test
    public void testBalance(){
        double result = b.getBalance();
        assertEquals(1000,result);
    }

    @Test
    public void testNotBalance(){
        double result = b.getBalance();
        assertNotEquals(100,result);
    }

    @Test
    public void testNotBalanceString(){
        double result = b.getBalance();
        assertNotEquals("100",result);
    }

    @Test
    public void testDeposit(){
        b.deposit(500);
        double result = b.getBalance();
        assertEquals(1500,result);
    }

    @Test
    public void testDepositInvalidTrue(){
        b.deposit(-500);
        double result = b.getBalance();
        assertEquals(1000,result);
    }

    @Test
    public void testDepositInvalid(){
        b.deposit(-500);
        double result = b.getBalance();
        assertNotEquals(1500,result);
    }

    @Test
    public void testWithdraw(){
        boolean result = b.withdraw(400);
        assertTrue(result);
    }

    @Test
    public void testWithdrawFalse(){
        boolean result = b.withdraw(5000);
        assertFalse(result);
    }

    @Test
    public void testWithdrawInvalid(){
        boolean result = b.withdraw(-50);
        assertFalse(result);
    }
    
}
