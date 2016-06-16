package com.slavyanin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ATM")
public class ATM {

    @Column(name = "BANKNOTES")
    private ArrayList<Integer> banknotes;

    @Column(name = "AMOUNT")
    private ArrayList<Integer> amount;

}
