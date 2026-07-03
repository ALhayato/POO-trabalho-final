package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import model.Paciente;
import model.Psicologo;

public class PsicologoTest {
    @Test
    public void testFazerVideoChamada() {
        Paciente a = new Paciente("Clara", "02465789632", 20, "1785435", null, "995486384");
        Psicologo psi = new Psicologo("Paulo", "47859635965", 30, "Pj59643", "354781", "Psicologo", "traumas");
        boolean res = psi.fazerVideoChamada(a);
        assertTrue(res, "falha na ligacao");
    }
}
