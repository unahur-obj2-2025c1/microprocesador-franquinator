package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class STR extends OperacionSensilla{
    private Integer addr;

    public STR(Integer addr){
        this.addr = addr;
    }

    @Override
    public void executeEsp(Programable micro) {
        micro.setAddr(addr);
    }

}