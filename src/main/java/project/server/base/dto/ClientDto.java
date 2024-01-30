package project.server.base.dto;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class ClientDto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "email")
	private String email;
	
	@Column(name = "firstname")
    private String firstName;
    
    @Column(name = "secondname")
    private String secondName;
    
    @Column(name = "familyname")
    private String familyName;
    
    @Column(name = "passwordhash")
    private int passwordHash;
    
    //@Column(name = "clientInfoData")
    //private ClientInfoData clientInfoData;
    
    public ClientDto() {
	}

	public ClientDto(String email, int passwordHash, String firstName, String secondName, String familyName) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.secondName = secondName;
        this.familyName = familyName;
    }

    public int getId() {
        return id;
    }
    
	public String getEmail() {
		return email;
	}
    
	public void setEmail(String email) {
		this.email = email;
	}

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
    
    public int getPasswordHash() {
		return passwordHash;
	}
    
	public void setPasswordHash(int passwordHash) {
		this.passwordHash = passwordHash;
	}

    /*public ClientInfoData getClientInfoData() {
        return clientInfoData;
    }

    public void setClientInfoData(ClientInfoData clientInfoData) {
        this.clientInfoData = clientInfoData;
    }*/
}
