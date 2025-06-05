package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.ADD;
import ar.edu.unahur.obj2.command.comandos.IFNZ;
import ar.edu.unahur.obj2.command.comandos.LOD;
import ar.edu.unahur.obj2.command.comandos.LODV;
import ar.edu.unahur.obj2.command.comandos.NOP;
import ar.edu.unahur.obj2.command.comandos.STR;
import ar.edu.unahur.obj2.command.comandos.SWAP;
import ar.edu.unahur.obj2.command.comandos.WHNZ;

public class ProgramBuilder {
    private List<Operable> listaComandos = new ArrayList<>();

    public List<Operable> getOperaciones(){
        return listaComandos;
    }
    
    public void Execute(Microprocesador micro){
        micro.run(listaComandos);
    }
    public ProgramBuilder ADD(){
        listaComandos.add(new ADD());
        return this;
    }
    public ProgramBuilder LOD(Integer addr){
        listaComandos.add(new LOD(addr));
        return this;
    }
    public ProgramBuilder LODV(Integer val){
        listaComandos.add(new LODV(val));
        return this;
    }
    public ProgramBuilder NOP(){
        listaComandos.add(new NOP());
        return this;
    }
    public ProgramBuilder STR(Integer addr){
        listaComandos.add(new STR(addr));
        return this;
    }
    public ProgramBuilder SWAP(){
        listaComandos.add(new SWAP());
        return this;
    }
    public ProgramBuilder IFNZ(List<Operable> listaInstrucciones){
        listaComandos.add(new IFNZ(listaInstrucciones));
        return this;
    }
    public ProgramBuilder WHNZ(List<Operable> listaInstrucciones){
        listaComandos.add(new WHNZ(listaInstrucciones));
        return this;
    }
}
