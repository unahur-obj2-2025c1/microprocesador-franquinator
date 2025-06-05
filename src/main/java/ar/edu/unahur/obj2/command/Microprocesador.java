package ar.edu.unahur.obj2.command;

import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable{
    private Integer acomuladorA;
    private Integer acomuladorB;
    private Integer programCounter = 0;
    private Integer[] memory = new Integer[1024];
    private Operable ultimaOperacion;
    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(o -> o.execute(this));
    }
    @Override
    public void incProgramCounter() {
        programCounter++;
    }
    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }
    @Override
    public void setProgramCounter(Integer value){
        programCounter = value;
    }
    @Override
    public void setAcumuladorA(Integer value) {
        acomuladorA = value;
    }
    @Override
    public Integer getAcumuladorA() {
        return acomuladorA;
    }
    @Override
    public void setAcumuladorB(Integer value) {
        acomuladorB = value;
    }
    @Override
    public Integer getAcumuladorB() {
        return acomuladorB;
    }
    @Override
    public void copyFrom(Programable programable) {
        acomuladorA = programable.getAcumuladorA();
        acomuladorB = programable.getAcumuladorB();
        programCounter = programable.getProgramCounter();
        memory = programable.getMemory();
        ultimaOperacion = programable.getUltimaOperacion();
    }
    @Override
    public Programable copy() {
        Programable micro = new Microprocesador();
        micro.setAcumuladorA(acomuladorA);
        micro.setAcumuladorB(acomuladorB);
        micro.setProgramCounter(programCounter);
        micro.setMemory(memory);
        micro.setUltimaOperacion(ultimaOperacion);
        return micro;
    }
    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }
    @Override
    public void setAddr(Integer addr) {
        verificarAddr(addr);
        memory[addr] = acomuladorA;
    }
    @Override
    public Integer getAddr(Integer addr) {
        verificarAddr(addr);
        return memory[addr];
    }
    public void verificarAddr(Integer addr){
        if(addr > 1023 || addr < 0){
            throw new MicroException("el addr debe ser entre 0 y 1024");
        }
    }
    @Override
    public Integer[] getMemory() {
        return memory;
    }
    @Override
    public void setMemory(Integer[] datos) {
        memory = datos;
    }
    @Override
    public void setUltimaOperacion(Operable operable) {
        ultimaOperacion = operable;
    }
    @Override
    public Operable getUltimaOperacion() {
        return ultimaOperacion;
    }
    @Override
    public void undo() {
        ultimaOperacion.undo(this);
    }

}