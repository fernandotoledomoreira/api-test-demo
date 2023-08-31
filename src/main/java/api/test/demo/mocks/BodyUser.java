package api.test.demo.mocks;

import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;

@Getter
@Setter
public class BodyUser {
    Object name, job;

    public BodyUser() {
        Faker faker = new Faker();
        this.name = faker.name().fullName();
        this.job = faker.job().position();
    }
}
