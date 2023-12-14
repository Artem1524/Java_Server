package project.server.utility.dto;

import project.server.utility.base.ClientInfoData;

import java.io.Serializable;

public class ClientDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String secondName;
    private String familyName;
    private ClientInfoData clientInfoData;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public ClientInfoData getClientInfoData() {
        return clientInfoData;
    }

    public void setClientInfoData(ClientInfoData clientInfoData) {
        this.clientInfoData = clientInfoData;
    }
}
