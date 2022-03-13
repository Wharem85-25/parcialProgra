package products;

import rx.Observable;
import rx.functions.Func2;
import java.util.ArrayList;
import java.util.List;

import products.Products;

public class SumatoriaP {
    public static void main(String[] args) {

        List<Products> products = new ArrayList<>();
        products.add(new Products("ps4", 300));
        products.add(new Products("gamecube", 300));
        products.add(new Products("external disk,", 200));
        products.add(new Products("laptop", 800));
        products.add(new Products("vr", 230));


        Observable sumProducts =
                Observable
                        .from(products.toArray())
                        .map((result) -> {
                            Products product = (Products) result;
                            return product.getPrice();
                        })
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                                    @Override
                                    public Integer call(Integer acumular, Integer actual) {
                                        return acumular + actual;
                                    }
                                }

                        );

        sumProducts.subscribe((sumatoria) -> {
            System.out.println("" + " Sumatoria: " + sumatoria);
        });

        Observable masCaro =
                Observable
                        .from(products.toArray())
                        .map((result) -> {
                            Products producto = (Products) result;
                            return producto.getPrice();
                        })
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                                    @Override
                                    public Integer call(Integer acumular, Integer actual) {
                                        if (actual > acumular){
                                            acumular = actual;
                                        }return acumular;

                                    }
                                }
                        );

        masCaro.subscribe((mayor) -> {
                    System.out.println("" + " El mayor es: " + mayor);
            }
        );
    }
}

