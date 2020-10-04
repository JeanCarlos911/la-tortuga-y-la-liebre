public abstract class Competidor{
    private int posicion = 1;
    private final int meta = 70;
    private final String nombre;

    public Competidor(String nombre) {
        this.nombre = nombre;
    }

    public void sumPosicion(int posicion) {
        this.posicion += posicion;
        if(this.posicion < 1)
            this.posicion = 1;
        if(this.posicion > 70)
            this.posicion = 70;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void avanzar();

}
