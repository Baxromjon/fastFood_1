package ai.fl.demofoods.component;

import ai.fl.demofoods.entity.*;
import ai.fl.demofoods.entity.enums.RoleName;
import ai.fl.demofoods.repository.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * created by Baxromjon
 * 04.02.2022
 **/


@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    //    @Autowired
//    CountryRepository countryRepository;
//    @Autowired
//    RegionRepository regionRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    ValueMeasurementRepository valueMeasurementRepository;
    @Autowired
    RoleRepository roleRepository;

    @Value(value = "${spring.sql.init.mode}")
    private String initialMode;

    @Override
    public void run(String... args) {
        if (initialMode.equals("always")) {
            RoleName[] roleNames=RoleName.values();
            List<Role> roles=new ArrayList<>();
            for (RoleName name:roleNames){
                roles.add(new Role(name));
                roleRepository.saveAll(roles);
            }
            User admin = new User(
                    "Admin",
                    "Adminov",
                    "+998990068005",
                    passwordEncoder.encode("root123"),
                    roleRepository.findByRoleName(RoleName.ADMIN)
            );
            userRepository.save(admin);

//            Country uzbekiston = new Country(
//                    "O`zbekiston"
//            );

//            countryRepository.save(uzbekiston);
//            Region andijon = new Region("Andijon", uzbekiston);
//            Region buxoro = new Region("Buxoro", uzbekiston);
//            Region namangan = new Region("Namangan", uzbekiston);
//            Region fargona = new Region("Farg`ona", uzbekiston);
//            Region toshkent = new Region("Toshkent", uzbekiston);
//            Region sirdaryo = new Region("Sirdaryo", uzbekiston);
//            Region jizzax = new Region("Jizzax", uzbekiston);
//            Region samarqand = new Region("Samarqand", uzbekiston);
//            Region qashqadaryo = new Region("Qashqadaryo", uzbekiston);
//            Region surxondaryo = new Region("Surxondaryo", uzbekiston);
//            Region navoiy = new Region("Navoiy", uzbekiston);
//            Region xorazm = new Region("Xorazm", uzbekiston);
//            Region toshkents = new Region("Toshkent shahri", uzbekiston);
//            Region nukus = new Region("Qoraqalpog`iston Respublikasi", uzbekiston);
//            List<Region> regions = Arrays.asList(andijon, fargona, namangan, toshkent, toshkents, samarqand, sirdaryo, jizzax, qashqadaryo, surxondaryo, navoiy, xorazm, buxoro, nukus);
//            regionRepository.saveAll(regions);                R

            Measurement liter = new Measurement("litr");
            Measurement dona = new Measurement("dona");
            Measurement kg = new Measurement("kg");
            List<Measurement> measurements = Arrays.asList(liter, dona, kg);
            measurementRepository.saveAll(measurements);

            ValueMeasurement yarim = new ValueMeasurement("0.5", liter);
            ValueMeasurement bir = new ValueMeasurement("1", liter);
            ValueMeasurement birYarim = new ValueMeasurement("1.5", liter);
            ValueMeasurement ikki = new ValueMeasurement("2", liter);
            ValueMeasurement besh = new ValueMeasurement("5", liter);
            ValueMeasurement birDona = new ValueMeasurement("1", dona);
            ValueMeasurement birKilo = new ValueMeasurement("1", kg);
            List<ValueMeasurement> valueMeasurements = Arrays.asList(yarim, bir, birYarim, ikki, besh, birDona);
            valueMeasurementRepository.saveAll(valueMeasurements);
        }
    }

}
