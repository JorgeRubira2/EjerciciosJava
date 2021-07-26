
package D23.M07;


class Persona{
    /*
    public static final String MARRON="Marron";
    public static final String VERDE="Verde";
    public static final String AZUL="Azul";
    
    public static final String TRISTE="Triste";
    public static final String ALEGRE="Alegre";
    */
    
    public enum Color{
        MARRON,VERDE,AZUL
    }
    
    public enum Animo{
        TRISTE,ALEGRE
    }
    
    public enum DiasSemana{
        LUNES,MARTES,MIERCOLES,JUEVES,VIERNES
    }

    private Color colorOjos;
    private Animo animo;

    public Persona(Color colorOjos) {
        //this.colorOjos = colorOjos;
    }

    public Color getColorOjos() {
        return colorOjos;
    }
    
    public void hacerCosas(DiasSemana dia){
        switch(dia){
            case LUNES:
                System.out.println("Gimnasio");
                break;
            case MARTES:
                System.out.println("Bici");
                break;
            case MIERCOLES:
                System.out.println("AAA");
                break;
            case JUEVES:
                System.out.println("33");
                break;
            case VIERNES:
                System.out.println("424");
                break;
        }
    }
    
    public int getValor(){
        return 3;
    }
    
    public final static int VALOR_COMPROBAR=4;
    
    public void pruebasSwitch(){
        int b=4;
        int a=3;
        switch(a){  //No se pueden poner long, float, double
            case 2:
                System.out.println("Gimnasio");
                break;
            case VALOR_COMPROBAR:
                System.out.println("Bici");
                break;
        }        
    }
}


public class EjemploConstantes {
    
    
    
    public static void main(String[] args) {
        Persona p1=new Persona(Persona.Color.MARRON);
        Persona p2=new Persona(Persona.Color.VERDE);
        Persona p3=new Persona(Persona.Color.AZUL);

        for(Persona.DiasSemana dia : Persona.DiasSemana.values()){
            p1.hacerCosas(dia);    
        }
        
        /*int a=1; //long, float, double
        switch(a){
            case 1:
            case 2:
            case 3:
                System.out.println("Bici");
                break;
            default:    //else
                System.out.println("No hacer nada");
                break;                  
        } */
        //Gimnasio Pulgar
        //Gimnasio Bici carita

    }
}
