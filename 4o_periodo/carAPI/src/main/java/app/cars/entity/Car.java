package app.cars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int year;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("cars")
    private Brand brand;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("cars")
    @JoinTable(name = "car_owner")
    private List<Owner> owners;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("cars")
    @JoinTable(name = "car_accessory")
    private List<Accessory> accessories;
}
