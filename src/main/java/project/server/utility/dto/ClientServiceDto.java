package project.server.utility.dto;

import java.io.Serializable;
import java.util.Date;

public class ClientServiceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String serviceName;
    private Date startDate;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
