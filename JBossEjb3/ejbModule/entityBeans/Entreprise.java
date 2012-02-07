package entityBeans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Entreprise")
public class Entreprise extends Contact{

	String numSiret; //Syst�me d�Identification du R�pertoire des ETablissements

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}


}
