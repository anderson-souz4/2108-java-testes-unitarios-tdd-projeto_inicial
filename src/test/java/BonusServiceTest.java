import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {

    @Test
    void deveriaRetornarZeroComSalarioAcimaDe10000() {
        BonusService service = new BonusService();
        Assertions.assertThrows(IllegalArgumentException.class,
                () ->  service.calcularBonus(new Funcionario("Anderson", LocalDate.now(), new BigDecimal("10001"))));
    }

    @Test
    void deveriaRetornarDezPorCentoDoSalarioMenorQue10000() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Anderson", LocalDate.now(), new BigDecimal("2500")));
        Assertions.assertEquals(new BigDecimal("250.00"), bonus);


    }


}
