package domain;

public class Operacion {
    private String dniCliente;
    private TipoOperacion tipo;
    private double monto;

    public Operacion(String dniCliente, TipoOperacion tipo, double monto){
        this.dniCliente = dniCliente;
        this.tipo = tipo;
        this.monto = monto;
    }

    public void deposito(Cliente cliente){
        cliente.setSueldo(cliente.getSueldo() + this.monto);
    }

    public void retiro(Cliente cliente){
        if(cliente.getSueldo() > this.monto){
            cliente.setSueldo(cliente.getSueldo() - this.monto);
        }
        else{
            System.out.println("Saldo insuficiente");
        }
    }
}
