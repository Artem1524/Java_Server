package project.server.utility.dataprovider.impl;

import project.server.base.dto.ClientServiceDto;
import project.server.utility.dataprovider.DataProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ServiceDataProvider implements DataProvider {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
            "dd:MM:yyyy EEEE HH:mm:ss:SSS z",
            Locale.getDefault());

    private ClientServiceDto data;

    public ServiceDataProvider() {
        data = new ClientServiceDto();
    }

    public ClientServiceDto getData() {
        return data;
    }

    public ServiceDataProvider withServiceName(String serviceName) {
        data.setServiceName(serviceName);
        return this;
    }

    public ServiceDataProvider withStartDate(Date startDate) {
        data.setStartDate(startDate);
        return this;
    }

    @Override
    public String getStringData() {
        return String.format("'Название сервиса': %s, 'Дата начала': %s",
                data.getServiceName(), formatDate(data.getStartDate()));
    }

    private String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }
}
