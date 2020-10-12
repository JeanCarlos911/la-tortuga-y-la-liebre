public class Tortuga extends Competidor{

    public Tortuga() {
        super("Tortuga");
    }

    @Override
    public void avanzar() {
        int aleatorio = Carrera.random.nextInt(10) + 1;

        if(aleatorio < 6) {
            sumPosicion(3);
        }else if(aleatorio < 8) {
            sumPosicion(-6);
        }else{
            sumPosicion(1);
        }
    }
}
