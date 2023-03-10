package dataForTest;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class StudentGenerationWithFaker {

    public static Student studentGeneration() {
        Student student = new Student();
        Faker faker = new Faker(new Locale("ru"));
        Faker faker1 = new Faker(new Locale("en"));
        student.setFirstName(faker.name().firstName());
        student.setLastName(faker.name().lastName());
        student.setEmail(faker1.internet().emailAddress());
        String[] genders = {"Male", "Female", "Other"};
        student.setGender(pickingRandomValue(genders));
        student.setPhoneNumber(8 + faker.phoneNumber().subscriberNumber(9));
        LocalDate birthday = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        student.setDayOfBirth(birthday.format(DateTimeFormatter.ofPattern("dd")));
        student.setMonthOfBirth(StringUtils.capitalize(birthday.getMonth().name().toLowerCase()));
        student.setYearOfBirth(String.valueOf(birthday.getYear()));
        String[] subjects = {"English", "Maths", "Biology"};
        student.setSubject(pickingRandomValue(subjects));
        String[] hobbies = {"Sports", "Reading", "Music"};
        student.setHobby(pickingRandomValue(hobbies));
        student.setAddress(faker.address().fullAddress());
        String[] states = {"NSR", "Uttar Pradesh", "Haryana"};
        student.setState(pickingRandomValue(states));
        student.setCity(pickingRandomValue(randomCities(student)));
        return student;
    }

    public static String pickingRandomValue(String[] array) {
        Random random = new Random();
        int min = 0;
        int max = (array.length - 1);
        int diff = max - min;
        int randomNumber = random.nextInt(diff + 1) + min;
        return array[randomNumber];
    }

    public static String[] randomCities(Student student) {
        String[] cities = null;
        switch (student.getState()) {
            case "NSR":
                cities = new String[]{"Delhi", "Gurgaon", "Noida"};
                break;
            case "Uttar Pradesh":
                cities = new String[]{"Agra", "Lucknow", "Merrut"};
                break;
            case "Haryana":
                cities = new String[]{"Karnal", "Panipat"};
                break;
        }
        return cities;
    }
}
