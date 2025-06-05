package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public abstract class OperacionSensilla implements Operable{
    private Programable microAnterior;

    @Override
    public void execute(Programable micro) {
        microAnterior = micro.copy();
        micro.setUltimaOperacion(this);
        doExecute(micro);
        micro.incProgramCounter();
    }
    public abstract void doExecute(Programable micro);
    @Override
    public void undo(Programable micro) {
        micro.copyFrom(microAnterior);
    }
    

}
