package ar.edu.unahur.obj2.command.comandos;

import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class IFNZ extends OperacionSensilla{
    private List<Operable> listaInstrucciones;
    public IFNZ(List<Operable> listaInstrucciones){
        this.listaInstrucciones = listaInstrucciones;
    }
    @Override
    public void execute(Programable micro){
        if(micro.getAcumuladorA() != 0){
            super.execute(micro);
        }
    }

    @Override
    public void doExecute(Programable micro) {
        micro.run(listaInstrucciones);
    }
    

}
