package mapReduce.dto.People;

import rx.Observable;
import rx.functions.Func2;
import java.util.ArrayList;
import java.util.List;

public class PersonaM{
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Wilmer", 21));
        persons.add(new Person("Steven", 26));
        persons.add(new Person("Liseth", 21));
        persons.add(new Person("Edin", 31));
        persons.add(new Person("Bayron", 35));

        Observable miobservable =
                Observable

                        .from(persons.toArray())

                        .map((result) -> {

                            Person person = (Person) result;
                            return person.getAge();
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

        miobservable.subscribe((mayor) -> {
            System.out.println("" + " El mayor es: " + mayor);
            }
        );
    }
}
