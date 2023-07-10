package org.example.courier;

import com.github.javafaker.Faker;

public class CouriersData {
    public Registration baseCourier() {
        return new Registration("dashaSh1998", "mypassword","dasha");
    }
    public Registration registeredCourier() {
        return new Registration("mylogin","mypassword","dasha");
    }
    public Registration secondCourier() {
        return new Registration("dashamasha20", "1234", "dasha");
    }

    public Registration thirdCourier() {
        return new Registration(login,password,name);
    }

    public Registration emptyLoginCourier() {
        return new Registration(null, password, name);
    }

    public Registration emptyPasswordCourier() {
        return new Registration(login, "", name);
    }

    Faker faker = new Faker();

    String login = faker.funnyName().name();
    String password = faker.internet().password();
    String name = faker.name().firstName();

}
