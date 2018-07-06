import com.ua.bemyguest.service.CurrencyExchangeService;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CurrencyExchangeServiceTest {

    @Test
    public void convertToDollar() {
        CurrencyExchangeService currencyExchangeService = new CurrencyExchangeService();
        double result = currencyExchangeService.convertToDollar(2600.00);
        assertEquals((long) 100.0, (long)result);
    }
}