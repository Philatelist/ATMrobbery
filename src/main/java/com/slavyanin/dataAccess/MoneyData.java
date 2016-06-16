package com.slavyanin.dataAccess;

import com.slavyanin.domain.ATM;

import java.util.List;

public interface MoneyData {

    public void fillMoneyCells();

    public List<ATM> listMoney();

    public List<ATM> listAmount();
}
