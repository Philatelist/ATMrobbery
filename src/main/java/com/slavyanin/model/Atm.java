package com.slavyanin.model;

import javax.persistence.*;

@Entity
@Table(name = "atm")
public class Atm {

    public static final String TABLE_NAME = "atm";
    public static final String ID_COLUMN = "id";
    public static final String BANKNOTES_COLUMN = "banknotes";
    public static final String AMOUNT_COLUMN = "amount";

    @Id
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = BANKNOTES_COLUMN)
    private Integer banknotes;

    @Column(name = AMOUNT_COLUMN)
    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBanknotes() {
        return banknotes;
    }

    public void setBanknotes(Integer banknotes) {
        this.banknotes = banknotes;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atm atm = (Atm) o;

        if (banknotes != null ? !banknotes.equals(atm.banknotes) : atm.banknotes != null) return false;
        return amount != null ? amount.equals(atm.amount) : atm.amount == null;

    }

    @Override
    public int hashCode() {
        int result = banknotes != null ? banknotes.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "id=" + id +
                ", banknotes=" + banknotes +
                ", amount=" + amount +
                '}';
    }
}
