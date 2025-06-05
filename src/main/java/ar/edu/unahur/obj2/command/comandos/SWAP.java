package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class SWAP extends OperacionSensilla{
    @Override
    public void doExecute(Programable micro) {
        Integer valorAcomuladorA = micro.getAcumuladorA();
        micro.setAcumuladorA(micro.getAcumuladorB());
        micro.setAcumuladorB(valorAcomuladorA);
    }

}
