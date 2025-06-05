package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.comandos.ADD;
import ar.edu.unahur.obj2.command.comandos.LOD;
import ar.edu.unahur.obj2.command.comandos.LODV;
import ar.edu.unahur.obj2.command.comandos.NOP;
import ar.edu.unahur.obj2.command.comandos.STR;
import ar.edu.unahur.obj2.command.comandos.SWAP;

public class MicroprocesadorTest {
    private Microprocesador micro = new Microprocesador();
    @Test
    public void alEjecutar3NOPElPCAvanza3Posiciones(){
        micro.run(Arrays.asList(new NOP(),new NOP(),new NOP()));
        assertEquals(3, micro.getProgramCounter());
    }
    @Test
    public void alSumar17EnAy20EnB_AQuedaEn37Ben0yPCen4(){
        micro.run(Arrays.asList(new LODV(20),
                                new SWAP(),
                                new LODV(17),
                                new ADD()));
        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter());
        micro.undo();
        assertEquals(20, micro.getAcumuladorB());
        assertEquals(17, micro.getAcumuladorA());
    }
    @Test
    public void alSumar2_8_7ElAcomuladorAQuedaEn15YElBen0(){
        micro.run(Arrays.asList(new LODV(2),
                        new STR(0),
                        new LODV(8),
                        new SWAP(),
                        new LODV(5),
                        new ADD(),
                        new SWAP(),
                        new LOD(0),
                        new ADD()));
        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
    }
}
