 package rumahsakit;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author syswanto
 */
 public class Perintah {
    public void Add(Object object) {
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("RumahSakitPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
                em.persist(object);
                em.getTransaction().commit();
        } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
        } finally {
                em.close();
        }
    }
    
  public void update(long id,String nama, String alamat, String umur, String jenis_kamar, String nama_dokter ){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("RumahSakitPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        em.createQuery("UPDATE pasien e SET e.nama=?1,e.alamat=?2,e.umur=?3,e.jenis_kamar=?4,e.nama_dokter=?5 WHERE e.id=?6",pasien.class)
        .setParameter(1, nama).setParameter(2, alamat).setParameter(3, umur)
        .setParameter(4, jenis_kamar).setParameter(5, nama_dokter).setParameter(6, id).executeUpdate();       
        em.getTransaction().commit();
  }
  
  public void hapus(long id){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("RumahSakitPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        int hapusyu=em.createQuery("DELETE FROM pasien e WHERE e.id=:par").setParameter("par", id).executeUpdate();
        em.getTransaction().commit();
  }
  public void Show() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("RumahSakitPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM pasien e");
        List<pasien> result = query.getResultList();
        for (pasien e : result) {
                 System.out.println("ID Pasien : " + e.getId() + "\n NAMA : " + e.getNama()+ "\n Alamat : " 
                 + e.getAlamat()+ "\n Umur : " + e.getUmur()+ "\n Jenis Kamar : " + e.getJenis_kamar()
                 + "\n Nama Dokter : " + e.getNama_dokter());   
        }
    }
}
