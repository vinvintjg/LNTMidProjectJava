package vincent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class Main {

    
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        Random r=new Random();
        ArrayList<Karyawan> list_karyawan=new ArrayList<>();
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        int pil=-1;
        while(pil!=0){
            System.out.println("1. Insert data karyawan");
            System.out.println("2. View data karyawan");
            System.out.println("3. Update data karyawan");
            System.out.println("4. Delete data karyawan");
            System.out.println("0. Exit");
            System.out.print(">> ");
            pil=Integer.parseInt(in.nextLine());
            if(pil==1){
                compare(list_karyawan);
                create_update(list_karyawan, 0);
                compare(list_karyawan);
            }
            else if(pil==2){
                compare(list_karyawan);
                cetak(list_karyawan);
            }
            else if(pil == 3){
                compare(list_karyawan);
                cetak(list_karyawan);
                create_update(list_karyawan,1);
                compare(list_karyawan);
            }
            else if(pil == 4){
                compare(list_karyawan);
                cetak(list_karyawan);
                delete(list_karyawan);
            }
        }
    }
    
    public static void cetak(ArrayList<Karyawan> list_karyawan){
        System.out.println("|----|----------------------------------|---------------------------------|------------------------|-----------------|-----------------------|");
        System.out.println("|No. | Kode Karyawan                    |Nama Karyawan                    | Jenis Kelamin          |Jabatan          |Gaji Karyawan          |");
        System.out.println("|----|----------------------------------|---------------------------------|------------------------|-----------------|-----------------------|");
        for(int i=0; i<list_karyawan.size(); i++)
        {
            System.out.print("|"+(i+1)+".  | ");
            for (int j = 0; j < 33-list_karyawan.get(i).getId().length(); j++) {
                System.out.print(" ");
            }
            System.out.print(list_karyawan.get(i).getId());
            System.out.print("|");
            
            for (int j = 0; j < 33-list_karyawan.get(i).getNama().length(); j++) {
                System.out.print(" ");
            }
            System.out.print(list_karyawan.get(i).getNama());
            System.out.print("|");
            
            for (int j = 0; j < 24-list_karyawan.get(i).getJk().length(); j++) {
                System.out.print(" ");
            }
            System.out.print(list_karyawan.get(i).getJk());
            System.out.print("|");
            
            for (int j = 0; j < 17-list_karyawan.get(i).getJabatan().length(); j++) {
                System.out.print(" ");
            }
            System.out.print(list_karyawan.get(i).getJabatan());
            System.out.print("|");
            
            String gaji = String.valueOf(list_karyawan.get(i).getGaji());
            for (int j = 0; j < 23-gaji.length(); j++) {
                System.out.print(" ");
            }
            System.out.print(list_karyawan.get(i).getGaji());
            System.out.println("|");
        }
        System.out.println("|----|----------------------------------|---------------------------------|------------------------|-----------------|-----------------------|");
    }
    
    public static void compare(ArrayList<Karyawan> list_karyawan){
    	for(int i = 0 ; i<list_karyawan.size()-1;i++){
            for(int j = 0; j < list_karyawan.size()-1-i;j++) {
                if(list_karyawan.get(i).getNama().compareTo(list_karyawan.get(j).getNama()) > 1){
                    Karyawan temp = list_karyawan.get(j);
                    list_karyawan.set(j , list_karyawan.get(j+1) );
                    list_karyawan.set(j+1 , temp );
                }
            }
        }
    }
    
    public static void delete(ArrayList<Karyawan> list_karyawan){
        Scanner in=new Scanner(System.in);
        int idx = -1;
        System.out.println("Input nomor urut karyawan yang ingin dihapus: ");
        idx = Integer.parseInt(in.nextLine());
        list_karyawan.remove(idx-1);
    }
    
    public static void create_update(ArrayList<Karyawan> list_karyawan, int mode){
        Scanner in=new Scanner(System.in);
        Random r=new Random();
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // membuat ID random karyawan
        char a1=alpha.charAt(r.nextInt(alpha.length())), a2=alpha.charAt(r.nextInt(alpha.length()));
        int kode_num=r.nextInt(9998-1000)+1000;
        String id=Character.toString(a1)+Character.toString(a2)+"-"+kode_num;

        
        if(mode == 0)
        {
            String nama="", jk="", jabatan="";
            while(nama.length()<3){
                    System.out.print("Input nama karyawan (>= 3): ");
                    nama=in.nextLine();
            }

            int cek=0;
            while(cek==0){
                    System.out.print("Input jenis kelamin (Laki-laki | Perempuan) (Case Sensitive): ");
                    jk=in.nextLine();
                    if(jk.equals("Laki-laki") || jk.equals("Perempuan")) cek=1;
            }

            cek=0;
            while(cek==0){
                    System.out.print("Input jabatan (Manager | Supervisor | Admin) (Case Sensitive): ");
                    jabatan=in.nextLine();
                    if(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")) cek=1;
            }
            System.out.println("Berhasil menambahkan karyawan dengan id "+id);
            
            
            list_karyawan.add(new Karyawan(id, nama, jk, jabatan));
            int ctr=0;
            for(int i=0; i<list_karyawan.size(); i++){
                if(list_karyawan.get(i).getJabatan().equals(jabatan)){
                        ctr++;
                }
            }
            if(ctr%3==1 && ctr !=1){
                int bonus=(int)list_karyawan.get(list_karyawan.size()-1).getBonus() * 10;
                String bon = "";
                if(bonus == 100)
                {
                    bon = "10";
                }
                else if(bonus == 75)
                {
                    bon = "7.5";
                }
                else if(bonus == 50)
                {
                    bon = "5";
                }
                System.out.println("Bonus sebesar " + bon + "% telah diberikan kepada karyawan dengan id ");
                for(int i=0; i<list_karyawan.size(); i++){
                    if(list_karyawan.get(i).getJabatan().equals(jabatan) && ctr!=1){
                        System.out.print(list_karyawan.get(i).getId());
                        int gaji=list_karyawan.get(i).getGaji();
                        list_karyawan.get(i).setGaji(gaji+((gaji*bonus) / 1000));
                        if(ctr>1) System.out.print(", ");
                        ctr--;
                    }
                }
                System.out.println("");
            }
        }
        else if(mode == 1)
        {
            System.out.println("Input nomor urutan karyawan yang ingin diupdate: ");
            int idx = Integer.parseInt(in.nextLine());
            
            String nama="", jk="", jabatan="";
            
            if(!nama.equals("0"))
            {
                list_karyawan.get(idx-1).setNama(nama);
            }
            if(!jk.equals("0"))
            {
                list_karyawan.get(idx-1).setJk(jk);
            }
            if(!jabatan.equals("0"))
            {
                list_karyawan.get(idx-1).setJabatan(jabatan);
                if(jabatan.equals("Supervisor")){
                    list_karyawan.get(idx-1).setGaji(6000000);
                }else if(jabatan.equals("Manager")){
                        list_karyawan.get(idx-1).setGaji(8000000);
                }else{
                        list_karyawan.get(idx-1).setGaji(4000000);
                }
            }
            
            while(nama.length()<3){
                    System.out.print("Input nama karyawan [>= 3]: ");
                    nama=in.nextLine();
            }

            int cek=0;
            while(cek==0){
                    System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
                    jk=in.nextLine();
                    if(jk.equals("Laki-laki") || jk.equals("Perempuan")) cek=1;
            }

            cek=0;
            while(cek==0){
                    System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
                    jabatan=in.nextLine();
                    if(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")) cek=1;
            }
            System.out.println("Berhasil mengupdate karyawan dengan id "+list_karyawan.get(idx-1).getId());
            list_karyawan.get(idx-1).setNama(nama);
            list_karyawan.get(idx-1).setJk(jk);
            list_karyawan.get(idx-1).setJabatan(jabatan);
            
            if(jabatan.equals("Manager")){
                list_karyawan.get(idx-1).setGaji(8000000);
            }
            else if(jabatan.equals("Supervisor")){
                list_karyawan.get(idx-1).setGaji(6000000);
            }
            else if(jabatan.equals("Admin")){
                list_karyawan.get(idx-1).setGaji(4000000);
            }
        
       
        }
        
        System.out.println("ENTER to return");
        String ent=in.nextLine();
    }
}
