public class Liebre extends Competidor{

    public Liebre() {
        super("Liebre");
    }

    @Override
    public void avanzar() {
        int aleatorio = Carrera.random.nextInt(10) + 1;

        if(aleatorio < 3) {
            sumPosicion(9);
        }else if(aleatorio < 4) {
            sumPosicion(-12);
        }else if(aleatorio < 7) {
            sumPosicion(1);
        }else if(aleatorio < 9){
            sumPosicion(-2);
        }
    }
}
