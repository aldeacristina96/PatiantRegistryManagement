
package Model;


public class Patient {
    private int id;
    private String name;
    private String adress;
    private int id_disease;

 public Patient(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Patient(int id, String name, String adress, int idDisease) {
        this.id=id;
        this.name=name;
        this.adress=adress;
        this.id_disease=idDisease;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getId_disease() {
        return id_disease;
    }

    public void setId_disease(int id_disease) {
        this.id_disease = id_disease;
    }

    public Patient(String name, String adress, int id_disease) {
        this.name = name;
        this.adress = adress;
        this.id_disease = id_disease;
    }

   
    
    @Override
    public String toString(){
        return this.name+","+this.adress+",disease id: "+this.id_disease;
    }
    
    
}
