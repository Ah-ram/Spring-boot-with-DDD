package practice.third.card.entity;

import java.util.Objects;

public enum CardStatusEffect {
    NORMAL((long) 0),
    BURN((long) 1),         // 화상
    FREEZE((long) 2),       // 빙결
    STUN((long) 3),         // 스턴
    POISON((long) 4),       // 독
    SLEEP((long) 5),        // 수면
    PARALYSIS((long) 6),    // 마비
    SHIELD((long) 7),       // 보호막
    CURSE((long) 8),        // 저주
    REGENERATION((long) 9); // 재생

    private final Long value;

    CardStatusEffect(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public static String getNameByValue(Long value) {
        for (CardStatusEffect effect : CardStatusEffect.values()) {
            if (Objects.equals(effect.value, value)) {
                return effect.name();
            }
        }
        return "UNKNOWN";
    }

    public static Long getValueByName(String name) {
        try {
            return CardStatusEffect.valueOf(name.toUpperCase()).value;
        } catch (IllegalArgumentException e) {
            return (long) -1;
        }
    }

}
