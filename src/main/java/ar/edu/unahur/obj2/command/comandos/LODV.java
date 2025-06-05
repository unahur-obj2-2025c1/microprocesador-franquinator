package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LODV extends OperacionSensilla{

    private Integer val;

    public LODV(Integer val){
        this.val = val;
    }

    @Override
    public void doExecute(Programable micro) {
        micro.setAcumuladorA(val);
    }

}
