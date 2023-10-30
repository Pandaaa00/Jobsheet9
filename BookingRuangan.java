import java.util.Scanner;

public class BookingRuangan {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        // Variabel untuk menyimpan informasi ruangan
        String namaRuangan;
        int kapasitasRuangan;
        double hargaPerJam = 30000, diskonBulan = 0.0;

        boolean pesanLagi = true;

        while (pesanLagi) {
            System.out.println("=======================================");
            System.out.println("           Aplikasi Booking Ruangan");
            System.out.println("=======================================");
            System.out.println("Mau Ngapain? :");
            System.out.println("1. Pemesanan lengkap");
            System.out.println("2. Periksa ketersediaan ruangan");
            System.out.print("Masukkan nomor tindakan (1/2): ");
            int tindakan = input.nextInt();
            input.nextLine(); 

            if (tindakan == 1) {
    
                System.out.print("Masukkan nama ruangan: ");
                namaRuangan = input.nextLine();

                System.out.print("Masukkan kapasitas ruangan: ");
                kapasitasRuangan = input.nextInt();

                System.out.print("Masukkan jumlah jam yang ingin dipesan: ");
                double jumlahJam = input.nextDouble();

                System.out.print("Masukkan tanggal pemesanan (dd/mm/yyyy): ");
                String tglPemesanan = input.next();

                // Mendapatkan bulan dari tglPemesanan
                int bulan = Integer.parseInt(tglPemesanan.split("/")[1]);

                if (bulan >= 1 && bulan <= 4) {
                    diskonBulan = 0.05;
                }

                double totalHarga = hargaPerJam * jumlahJam;
                double jumlahDiskonBulan = totalHarga * diskonBulan;
                totalHarga -= jumlahDiskonBulan;

                if (kapasitasRuangan > 100) {
                    double diskon = 0.10; // diskon 10% jika kapasitas lebih dari 100
                    double jumlahDiskon = totalHarga * diskon;
                    totalHarga -= jumlahDiskon;
                } else if (kapasitasRuangan > 50) {
                    double diskon = 0.05; // diskon 5% jika kapasitas lebih dari 50
                    double jumlahDiskon = totalHarga * diskon;
                    totalHarga -= jumlahDiskon;
                }

                System.out.println("\n=======================================");
                System.out.println("            Detail Pemesanan");
                System.out.println("=======================================");
                System.out.println("Nama Ruangan: " + namaRuangan);
                System.out.println("Kapasitas Ruangan: " + kapasitasRuangan + " orang");
                System.out.println("Harga per Jam: $" + hargaPerJam);
                System.out.println("Jumlah Jam yang Dipesan: " + jumlahJam + " jam");
                System.out.println("Total Harga: $" + totalHarga);
                
            } else if (tindakan == 2) {
                // Periksa ketersediaan ruangan
                System.out.print("Masukkan kapasitas ruangan yang ingin diperiksa: ");
                kapasitasRuangan = input.nextInt();
                if (kapasitasRuangan > 500) {
                    System.out.println("Ruangan tidak tersedia.");
                } else {
                    System.out.println("Ruangan tersedia.");
                }
            } else {
                System.out.println("Tindakan tidak valid.");
            }

            System.out.print("\nApakah Anda ingin melakukan tindakan lainnya? (iya/tidak): ");
            String jawaban = input.next();
            if (jawaban.equalsIgnoreCase("tidak")) {
               System.out.println("================= Terimakasih Telah Berkunjung ================= ");
               pesanLagi = false;
            }
            input.nextLine(); 
        }

       
        input.close();
    }
}