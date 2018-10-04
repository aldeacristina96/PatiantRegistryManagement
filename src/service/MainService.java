
package service;

import Model.Disease;
import Model.Doctor;
import Model.Patient;
import dao.DiseaseDao;
import dao.DoctorDao;
import dao.PatientDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MainService {
    private Connection con;
    private MainService(){
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    
    private static final class SingletonHolder{
        private static final MainService SINGLETON=new MainService();
    }
    
    public static MainService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    
    public boolean login(String username,String password) throws SQLException{
        boolean rezult=false;
        DoctorDao docDao=new DoctorDao(con);
        Optional<Doctor> optional=docDao.findUser(username);
        
        if(optional.isPresent()){
            if(optional.get().getPassword().equals(password)){
                rezult=true;
            }
        
        }
            return rezult;
    
    }
    
    public boolean findUser(String username) throws SQLException{
        DoctorDao docDao=new DoctorDao(con);
        Optional<Doctor> optional =docDao.findUser(username);
        if(optional.isPresent()){
        
            return true;
        }
        return false;
    }
    public void addPatient(Patient p) throws SQLException{
        PatientDao patientDao=new PatientDao(con);
        patientDao.addPatient(p);
              
    }
    
    public List<Patient> showAllPatients() throws SQLException{
        List<Patient> list=null;
        PatientDao dao=new PatientDao(con);
        list=dao.getAllPatients();
        return list;
        
    }
    public List<Disease> showAllDiseases() throws SQLException{
        List<Disease> list=null;
        DiseaseDao dao=new DiseaseDao(con);
        list=dao.getAllDiseases();
        return list;
    }
    public void removePatient(Patient p) throws SQLException{
        int id=p.getId();
        PatientDao dao=new PatientDao(con);
        dao.removePatient(id);
    
    }
}
