package practice.second.dice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Dice {
    @Id   // pk값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // 기본 키 값이 DB에서 자동생성(Auto_increment)
    private Long id;

    private Long number;
    private Long playerId;

    public Dice(long number) {
        this.number = number;
    }

    public Dice() {}   // JPA는 기본 생성자가 필요함
}
