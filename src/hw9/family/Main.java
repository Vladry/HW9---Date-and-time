package hw9.family;

import hw9.family.Animals.Dog;
import hw9.family.Animals.DomesticCat;
import hw9.family.Animals.Fish;
import hw9.family.Animals.RoboCat;
import hw9.family.Controller.FamilyController;
import hw9.family.DAO.CollectionFamilyDao;
import hw9.family.People.*;
import hw9.family.service.FamilyService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //исходник с данными по создаваемым семьям:
        List<List<String>> familyData = new ArrayList<>(Arrays.asList(
                Arrays.asList("Leontiy", "Zoya", "Fedotov"),
                Arrays.asList("Petya", "Natasha", "Gandzapety"),
                Arrays.asList("Grigory", "Liza", "Morarik"),
                Arrays.asList("Anton", "Olya", "Glory"),
                Arrays.asList("Pavel", "Tanya", "Primetime"),
                Arrays.asList("Viktor", "Lyuba", "Wonder"),
                Arrays.asList("Marik", "Katya", "Pendik"),
                Arrays.asList("Svyatoslav", "Tonya", "Krutovar"),
                Arrays.asList("Vladik", "Lena", "Mirolyub"),
                Arrays.asList("Sergey", "Nadya", "Rudakov"),
                Arrays.asList("Maks", "Rebekka", "Petrik"),
                Arrays.asList("Vladymir", "Nyura", "Levinsky"),
                Arrays.asList("Yura", "Klavdia", "Shifer"),
                Arrays.asList("Taras", "Marta", "Mirolyub"),
                Arrays.asList("Vovan", "Galya", "Gagik"),
                Arrays.asList("Vertal", "Alla", "Pendiks")
        )
        );

        //создание сервиса DAO:
        CollectionFamilyDao<Family> familyMemStorage = new CollectionFamilyDao<>();//создаём хранилище1
        FamilyService service = new FamilyService(familyMemStorage);
        FamilyController controller = new FamilyController(service);

        //задание прочих входных параметров для создания семей:
        Random rnd = new Random();
        int amntOwn, amntAdopted;
        LocalDate dadBirthDate, momBirthDate;

        for (List<String> names : familyData) {
            amntOwn = rnd.nextInt(4);
            amntAdopted = rnd.nextInt(3);
            dadBirthDate = LocalDate.of(1973, 5 , 13);
            momBirthDate = dadBirthDate.plusYears(10L).plusMonths(2L).plusDays(13);


            //создание семей и испытании метода createNewFamily():
            service.createNewFamily(names.get(0), names.get(1), names.get(2),
                    dadBirthDate, momBirthDate, amntOwn, amntAdopted);
        }


        controller.doControl();
    }
}



