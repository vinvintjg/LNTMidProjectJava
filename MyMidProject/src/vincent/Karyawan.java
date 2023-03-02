package vincent;

public class Karyawan {
    private String id, nama, jk, jabatan;
    private int gaji;
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public Karyawan(String id, String nama, String jk, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.jk = jk;
        this.jabatan = jabatan;
        this.bonus=5;
        this.gaji=4000000;
        if(jabatan.equalsIgnoreCase("Manager")){
            this.bonus=10;
            this.gaji=8000000;
        }
        if(jabatan.equalsIgnoreCase("Supervisor")){
            this.bonus=7.5;
            this.gaji=6000000;
        }
    }
    
    public Karyawan(String id, String nama, String jk, String jabatan, int gaji, double bonus) {
        this.id = id;
        this.nama = nama;
        this.jk = jk;
        this.jabatan = jabatan;
        this.bonus=bonus;
        this.gaji=gaji;
    }
}
