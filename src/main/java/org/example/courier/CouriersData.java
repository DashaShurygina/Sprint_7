package org.example.courier;

public class CouriersData {
    public Registration baseCourier() {
        return new Registration("dashamasha2023", "1234", "dasha");
    }

    public Registration secondCourier() {
        return new Registration("dashamasha20", "1234", "dasha");
    }

    public Registration thirdCourier() {
        return new Registration("dashamasha30", "1234", "dasha");
    }

    public Registration emptyLoginCourier() {
        return new Registration(null, "1234", "dasha");
    }

    public Registration emptyPasswordCourier() {
        return new Registration("dashamasha40", "", "dasha");
    }

}
