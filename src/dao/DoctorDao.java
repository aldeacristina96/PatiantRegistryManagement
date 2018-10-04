
package dao;

import Model.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


public class DoctorDao {
    private Connection con;
    private PreparedStatement stmt1,stmt2;
    public DoctorDao(Connection con){
        this.con=con;
        try {
            this.stmt1=con.prepareStatement("select * from doctor where username = ?");
            this.stmt2=con.prepareStatement("insert into doctor values(null,?,?,?)");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
    
    }
    
    public Optional<Doctor> findUser(String username) throws SQLException{
        Doctor doc=null;
        stmt1.setString(1,username);
        ResultSet rs=stmt1.executeQuery();
        if(rs.next()){
            doc=new Doctor();
            doc.setId(rs.getInt(1));
            doc.setName(rs.getString(2));
            doc.setUsername(rs.getString(3));
            doc.setPassword(rs.getString(4));
            
            
        }
        return Optional.ofNullable(doc);
    
    }
    
    public void addUser(Doctor doc) throws SQLException{
        stmt2.setString(1,doc.getName());
        stmt2.setString(2,doc.getUsername());
        stmt2.setString(3,doc.getPassword());
        
    
    }
    
    
}
