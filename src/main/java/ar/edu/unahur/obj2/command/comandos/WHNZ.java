package ar.edu.unahur.obj2.command.comandos;

import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class WHNZ extends OperacionSensilla{
    private List<Operable> listaInstrucciones;
    public WHNZ(List<Operable> listaInstrucciones){
        this.listaInstrucciones = listaInstrucciones;
    }
    @Override
    public void execute(Programable micro){
        while(micro.getAcumuladorA() != 0){
            super.execute(micro);
        }
    }

    @Override
    public void executeEsp(Programable micro) {
        micro.run(listaInstrucciones);
    }
}
