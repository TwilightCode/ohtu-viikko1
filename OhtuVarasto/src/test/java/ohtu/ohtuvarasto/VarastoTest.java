package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void lisataanNegatiivinenMaara() {
        double saldo = varasto.getSaldo();
        varasto.lisaaVarastoon(-0.1);
        assertEquals(saldo, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisataanOKMaara() {
        double saldo = varasto.getSaldo();
        varasto.lisaaVarastoon(5.7);
        assertEquals(saldo + 5.7, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisataanLiikaaMaara() {
        varasto.lisaaVarastoon(8);
        varasto.lisaaVarastoon(4);
        assertEquals(varasto.getTilavuus(), varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void PoistetaanNegatiivinenMaara() {
        varasto.lisaaVarastoon(5.7);
        double saldo = varasto.getSaldo();
        varasto.otaVarastosta(-0.7);
        assertEquals(saldo, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void PoistetaanLiikaaMaara() {
        varasto.lisaaVarastoon(5.7);
        varasto.otaVarastosta(8);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void PoistetaanOKMaara() {
        varasto.lisaaVarastoon(5.7);
        double saldo = varasto.getSaldo();
        varasto.otaVarastosta(3);
        assertEquals((saldo - 3), varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void konstr() {
        varasto = new Varasto(-1);
        varasto = new Varasto(0);
        varasto = new Varasto(1, 1);
        varasto = new Varasto(1, 2);
        varasto = new Varasto(-1, 2);
        varasto = new Varasto(-1, -1);
        varasto.toString();
    }
}
