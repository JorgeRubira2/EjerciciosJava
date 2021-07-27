
public class Ejercicio06LambdasTest {
	@Test
    public void testCompararIntegers() {
        Ejercicio06Lambdas instance = new Ejercicio06Lambdas();
        Comparator<Integer> resultado = instance.compararIntegers();
        assertEquals(true, resultado.compare(1, 3)<0);
        assertEquals(true, resultado.compare(3, 1)>0);
        assertEquals(true, resultado.compare(2, 2)==0);
    }

    @Test
    public void testCompararStrings() {
        Ejercicio06Lambdas instance = new Ejercicio06Lambdas();
        Comparator<String> result = instance.compararStrings();
        assertEquals(true, result.compare("1", "3")<0);
        assertEquals(true, result.compare("3", "1")>0);
        assertEquals(true, result.compare("2", "2")==0);
        assertEquals(true, result.compare(null, "2")<0);
        assertEquals(true, result.compare("2", null)>0);
        assertEquals(true, result.compare(null, null)==0);
    }

    @Test
    public void testCompararPersonasPorEdadAscendente() {
        Ejercicio06Lambdas instance = new Ejercicio06Lambdas();
        Comparator<Persona> result = instance.compararPersonasPorEdadAscendente();
        assertEquals(true, result.compare(new Persona("A", 24),new Persona("A", 29))<0);
        assertEquals(true, result.compare(new Persona("A", 29),new Persona("A", 24))>0);
        assertEquals(true, result.compare(new Persona("A", 24),new Persona("A", 24))==0);
    }

    @Test
    public void testCompararPersonasPorEdadDescendente() {
        Ejercicio06Lambdas instance = new Ejercicio06Lambdas();
        Comparator<Persona> result = instance.compararPersonasPorEdadDescendente();
        assertEquals(true, result.compare(new Persona("A", 24),new Persona("A", 29))>0);
        assertEquals(true, result.compare(new Persona("A", 29),new Persona("A", 24))<0);
        assertEquals(true, result.compare(new Persona("A", 24),new Persona("A", 24))==0);
    }

    @Test
    public void testCompararPersonasPorCiudadYNombre() {
        Ejercicio06Lambdas instance = new Ejercicio06Lambdas();
        Comparator<Persona> result = instance.compararPersonasPorCiudadYNombre();
        assertEquals(true, result.compare(new Persona("B", "A"),new Persona("A", "B"))<0);
        assertEquals(true, result.compare(new Persona("A", "B"),new Persona("B", "A"))>0);
        assertEquals(true, result.compare(new Persona("A", "A"),new Persona("A", "A"))==0);
    }
}
