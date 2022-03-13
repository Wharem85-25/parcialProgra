package PromedioF;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.MathObservable;


public class NumFunction {
    public static void main(String[] args) {
        Integer[] listNumbers = {2, 5, 6, 8, 10, 35, 2, 10};

        Observable numbers = Observable.from(listNumbers);

        MathObservable
                .from(numbers)
                .averageInteger(numbers)
                .subscribe((promedio) -> {
                    System.out.println("El promedio es: " + promedio);
                });

        Observable.from(listNumbers)
                .filter(
                        new Func1<Integer, Boolean>() {
                            @Override
                            public Boolean call(Integer valor) {
                                return valor >= 10;
                            }
                        }
                )
                .subscribe(ValorM ->{
                            System.out.println("Valor igual o mayor a 10: "+  ValorM) ;
                        }
                );
        Observable sumaNumbers= (Observable) Observable
                .from(listNumbers)
                .reduce(
                        new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer acumular, Integer actual) {
                                return acumular + actual;
                            }
                        }
                );
        sumaNumbers.subscribe((sumatoria) -> {
            System.out.println("La suma total es: " + sumatoria);
        });
    }
}



