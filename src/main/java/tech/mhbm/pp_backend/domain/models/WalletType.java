package tech.mhbm.pp_backend.domain.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import tech.mhbm.pp_backend.domain.models.exceptions.InvalidEnumValueException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_wallet_type")
public class WalletType implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public WalletType() {
    }

    public WalletType(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Enum {
        USER(1L, "user"),
        MERCHANT(2L, "merchant");

        private Long id;
        private String description;

        Enum(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public WalletType get() {
            return new WalletType(id, description);
        }

        @JsonCreator
        public static Enum fromString(String key) {
            if (key != null) {
                for (Enum e : values()) {
                    if (e.description.equalsIgnoreCase(key) || e.id.toString().equals(key)) {
                        return e;
                    }
                }
            }
            throw new InvalidEnumValueException("Value: " + key + " is invalid for WalletType, use: user(1) or merchant(2)");
        }

        @JsonValue
        public String toValue() {
            return this.description;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletType that = (WalletType) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
