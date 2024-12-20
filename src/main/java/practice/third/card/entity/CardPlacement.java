package practice.third.card.entity;

import java.util.Objects;

public enum CardPlacement {
    HAND((long) 1),       // 손패
    FIELD((long) 2),      // 필드
    GRAVEYARD((long) 3),  // 무덤
    LOST_ZONE((long) 4);  // 로스트존

    private final Long value;

    CardPlacement(Long value) {
        this.value = value;
    }

    public  Long getValue() {
        return value;
    }

    public static String getNameByValue(Long value) {
        for (CardPlacement placement : CardPlacement.values()) {
            if (Objects.equals(placement.value, value)) {
                return placement.name();
            }
        }
        return "UNKNOWN";
    }

    public static Long getValueByName(String name) {
        try {
            return CardPlacement.valueOf(name.toUpperCase()).value;
        } catch (IllegalArgumentException e) {
            return (long) -1;
        }
    }

}
