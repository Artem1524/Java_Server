package project.server.utility.dataprovider.impl;

import project.server.utility.base.ClientInfoData;
import project.server.utility.dataprovider.DataProvider;
import project.server.utility.dto.ClientDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class ClientDataProvider implements DataProvider {
    private ClientDto data;

    public ClientDataProvider() {
        data = new ClientDto();
    }

    public ClientDto getClientDto() {
        return data;
    }

    public ClientDataProvider withFirstName(String firstName) {
        data.setFirstName(firstName);
        return this;
    }

    public ClientDataProvider withFamilyName(String familyName) {
        data.setFamilyName(familyName);
        return this;
    }

    public ClientDataProvider withSecondName(String secondName) {
        data.setSecondName(secondName);
        return this;
    }

    public ClientDataProvider withClientInfoData(BigDecimal balance, Integer position) {
        data.setClientInfoData(
                new ClientInfoData(balance, position)
        );
        return this;
    }

    @Override
    public String getStringData() {
        return String.format("'ФИО': %s %s %s, 'Данные': Баланс = %s, Позиция = %d",
                data.getFamilyName(), data.getFirstName(), data.getSecondName(),
                formatBalance(data.getClientInfoData().getBalance()), data.getClientInfoData().getPosition());
    }

    public String formatBalance(BigDecimal balance) {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setGroupingUsed(true);
        formatter.setMinimumFractionDigits(2);
        formatter.setRoundingMode(RoundingMode.FLOOR);
        return formatter.format(balance);
    }
}
