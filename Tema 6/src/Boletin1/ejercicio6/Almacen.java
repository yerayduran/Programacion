package Boletin1.ejercicio6;

public class Almacen {

    private static final int MAXIMO_DE_CAJAS = 20;
    private static int numeroDeClientes = 0;

    private Caja cajas[] = new Caja[MAXIMO_DE_CAJAS];

    public Almacen() {
        inicializarCajas();
    }

    private void inicializarCajas() {
        int i;

        for (i = 0; i < cajas.length; i++){
            cajas[i] = new Caja((i + 1));
        }
    }

    public void abrirCaja(int numeroCaja) throws CajaException{
        if(numeroCaja <= 0 || numeroCaja > MAXIMO_DE_CAJAS){
            throw new CajaException("Estas esquizofrenico no existe esa caja");
        }

        cajas[numeroCaja - 1].abrirCaja();
    }

    public void cerrarCaja(int numeroCaja) throws CajaException{
        if(numeroCaja <= 0 || numeroCaja > MAXIMO_DE_CAJAS){
            throw new CajaException("Estas esquizofrenico no existe esa caja");
        }

        cajas[numeroCaja - 1].cerrarCaja();
    }

    public String nuevoCliente() throws CajaException{

        int cajaAtendidaParaLosClientes;

        cajaAtendidaParaLosClientes = cajaMenosCliente();

        cajas[cajaAtendidaParaLosClientes].agregarNuevoClienteCaja(numeroDeClientes);

        String info = "Es usted el cliente " + numeroDeClientes +  " y se le atendera en la caja " + (cajaAtendidaParaLosClientes +1);

        numeroDeClientes++;
        return info;
    }

    public int atenderCliente(int numeroCaja) throws CajaException{
        if (numeroCaja <= 0 || numeroCaja > MAXIMO_DE_CAJAS) {
            throw new CajaException("No existe la caja " + numeroCaja);
        }
        return cajas[numeroCaja - 1].atenderCliente();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cajas.length; i++) {
            if (cajas[i].isEstaAbierta()) {
                sb.append("Caja " + (i + 1) + " tiene tantos clientes esperando " + cajas[i].tamañoColaCliente());
            }
        }

        return sb.toString();
    }

    private int cajaMenosCliente() throws CajaException {
        int menorNumeroClientes = Integer.MAX_VALUE;
        int cajaConMenosClientes = 0;
        boolean abierta = false;

        for (int i = 0; i < cajas.length; i++) {
            if(cajas[i].isEstaAbierta()) {
                abierta = true;
                if(cajas[i].tamañoColaCliente() < menorNumeroClientes) {
                    menorNumeroClientes = cajas[i].tamañoColaCliente();
                    cajaConMenosClientes = i;
                }
            }
        }
        if(!abierta) {
            throw new CajaException("Error.No hay cajas abiertas");
        }
        return cajaConMenosClientes;
    }

}