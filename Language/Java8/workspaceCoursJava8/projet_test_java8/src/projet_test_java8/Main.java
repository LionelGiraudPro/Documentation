package projet_test_java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {


		Function<String, Double> testToDoubleDescriptor = (s) -> Double.valueOf(s) *2;
		ToDoubleFunction<String> testToDouble = Double::valueOf;
		Consumer<Double> doubleConsumer = (Double d) -> d+=3d;
		Function<Double, Double> andThenFunc = (Double d) -> Double.valueOf(d.intValue() * 3);
		Double d = 8.94d;
		
		System.out.println(testToDoubleDescriptor.apply("1.8695"));
		System.out.println(testToDouble.applyAsDouble("1.698"));
		System.out.println(testToDoubleDescriptor.andThen(andThenFunc).apply("1.8695"));
		System.out.println("Double avant :"+d);
		doubleConsumer.accept(d);
		System.out.println("Double après :"+d);
		
        List<Personne> listP = Arrays.asList(

                new Personne(1.80, 70, "A", "Nicolas", Couleur.BLEU),

                new Personne(1.56, 50, "B", "Nicole", Couleur.VERRON),

                new Personne(1.75, 65, "C", "Germain", Couleur.VERT),

                new Personne(1.68, 50, "D", "Michel", Couleur.ROUGE),

                new Personne(1.96, 65, "E", "Cyrille", Couleur.BLEU),

                new Personne(2.10, 120, "F", "Denis", Couleur.ROUGE),

                new Personne(1.90, 90, "G", "Olivier", Couleur.VERRON)

        );
        
        Stream<Personne> sp = listP.stream();


        long count = sp .filter(x -> x.getPoids() > 50).peek(x -> System.out.println(x))

                        .map(x -> x.getPoids()).peek(x -> System.out.println(x))

                        .count();


        System.out.println("Nombre d'éléments : " + count);

	}

}
