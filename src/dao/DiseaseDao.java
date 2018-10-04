
package dao;

import Model.Disease;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DiseaseDao {
    Connection con;
    PreparedStatement stmt1;
    public DiseaseDao(Connection con){
        this.con=con;
        try {
            stmt1=con.prepareStatement("select * from disease");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Disease> getAllDiseases() throws SQLException{
        List<Disease> list=new ArrayList<>();
        Disease disease=null;
        ResultSet rs=stmt1.executeQuery();
        while(rs.next()){
            int id=rs.getInt(1);
            String name=rs.getString(2);
            list.add(new Disease(id,name));
            
            
        
        }
        return list;
        
    }
    
}
