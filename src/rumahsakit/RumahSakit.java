package rumahsakit;

import java.util.Scanner;
/**
 *
 * @author syswanto
 */
public class RumahSakit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        pasien ps =new pasien();
        Perintah tambah = new Perintah();
        Scanner input=new Scanner(System.in);
        String nama,alamat,umur,jenis_kamar,nama_dokter,jwb;
        long id = 0;
        
        System.out.println("RUMAH SAKIT NURUL HIDAYAH 99");
        System.out.println("Harap Di Isi Dengan Benar");
        System.out.print("Nama Pasien : ");nama = input.nextLine();
        System.out.print("Alamat : ");alamat=input.nextLine();
        System.out.print("Umur : ");umur=input.nextLine();
        System.out.print("Jenis Kamar : ");jenis_kamar=input.nextLine();
        System.out.print("Nama dokter : ");nama_dokter=input.nextLine();
        
        ps.setNama(nama);
        ps.setAlamat(alamat);
        ps.setUmur(umur);
        ps.setJenis_kamar(jenis_kamar);
        ps.setNama_dokter(nama_dokter);
        tambah.Add(ps);
        
        System.out.println("Apakah data anda ingin diperlihatkan ? jawab ya/no");jwb=input.nextLine();
        if(jwb.equals("ya")){
        tambah.Show();
        }
        
        System.out.println("Apakah data anda ingin di ubah ? jawab ya/tidak");jwb=input.nextLine();
        if(jwb.equals("ya")){  
        System.out.print("Nama Pasien : ");nama = input.nextLine();
        System.out.print("Alamat : ");alamat=input.nextLine();
        System.out.print("Umur : ");umur=input.nextLine();
        System.out.print("Jenis Kamar : ");jenis_kamar=input.nextLine();
        System.out.print("Nama dokter : ");nama_dokter=input.nextLine();
            tambah.update(id,nama,alamat,umur,jenis_kamar,nama_dokter);
            tambah.Show();
        }
        
        System.out.println("Apakah data anda ingin di hapus? jawab ya/tidak");jwb=input.nextLine();
        if(jwb.equals("ya")){
            System.out.print("ID Pasien : ");id=input.nextLong();
            tambah.hapus(id);
            tambah.Show();
        }
        
    }
}