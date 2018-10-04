
package dao;

import Model.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PatientDao {
    
    private Connection con;
    private PreparedStatement stmt1,stmt2,stmt3;
    public PatientDao(Connection con){
        this.con=con;
        try {
            this.stmt1=con.prepareStatement("insert into patient values(null,?,?,?)");
            this.stmt2=con.prepareStatement("select * from patient");
            this.stmt3=con.prepareStatement("delete from patient where id = ?");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addPatient(Patient p) throws SQLException{
        stmt1.setString(1,p.getName());
        stmt1.setString(2,p.getAdress());
        stmt1.setInt(3,p.getId_disease());
        stmt1.executeUpdate();
    }
    
    public List<Patient> getAllPatients() throws SQLException{
        List<Patient> list=new ArrayList<>();
        ResultSet rs=stmt2.executeQuery();
        while(rs.next()){
            int id=rs.getInt(1);
            String name=rs.getString(2);
            String adress=rs.getString(3);
            int idDisease=rs.getInt(4);
            list.add(new Patient(id,name,adress,idDisease));
        }
        return list;
    }
    
    public void removePatient(int id) throws SQLException{
        stmt3.setInt(1,id);
        stmt3.executeUpdate();
        
    }
    
    
}
