package Practica.Naves;



public class Nave implements INave{

    private boolean viento=false;
    private double fuerzaViento=(Math.random()-0.5)/3;
    
    private double altura=0;
    private double metrosRecorridos=0;
    private int velocidad=0;
    private double anguloNave=0;
    
    private int giro=0;
    private boolean propulsion=false;
    
    private double dx=0;
    private double dy=0;
    
    public void time(){
        if (propulsion){
            dy+=Math.cos(-anguloNave*Math.PI*2/360);
            dx-=Math.sin(-anguloNave*Math.PI*2/360);
            if (viento){
                dx+=fuerzaViento;
            }
        }
        dy-=0.5;
        velocidad=(int)Math.sqrt(dx*dx+dy*dy);
        anguloNave+=giro/300.0;
        
        altura+=dy/100;
        metrosRecorridos+=dx/100;
    }

    public boolean isViento() {
        return viento;
    }

    public double getFuerzaViento() {
        return fuerzaViento;
    }
    
    
    
    @Override
    public int getAltura() {
        return (int)altura;
    }

    @Override
    public int getMetrosRecorridos() {
        return (int)metrosRecorridos;
    }

    @Override
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public int getAngulo() {
        return (int)anguloNave;
    }

    @Override
    public void girarMando(int angulo) {
        angulo=Math.max(-45, Math.min(45, angulo));
        giro=angulo;
    }

    @Override
    public void setPropulsion(boolean valor) {
        propulsion=valor;
    }

    public boolean getPropulsion() {
        return propulsion;
    }
    
}
