package entityBeans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Entreprise")
public class Entreprise extends Contact{

	long numSiret; //Syst�me d�Identification du R�pertoire des ETablissements

	public long getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(long numSiret) {
		this.numSiret = numSiret;
	}


}
