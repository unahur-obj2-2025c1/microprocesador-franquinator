package ar.edu.unahur.obj2.command;

import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;

public class ProgramBuilder {
    private List<Operable> listaComandos;
    
    public void Execute(Microprocesador micro){
        micro.run(listaComandos);
    }

}
