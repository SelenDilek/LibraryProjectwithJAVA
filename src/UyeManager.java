

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UyeManager extends Veritabani {
    static Scanner scan = new Scanner(System.in);

    public static void uyeMenu() throws InterruptedException {
        String tercih = "";

        do { //TODO Kullanıcı Çıkış Yapmadığı Sürece, Menüyü Görmeye Devam Etsin...

            System.out.println(
                    "\n========== TECHNO STUDY CONFLUENCE =========\n" +
                            "================= UYE MENU =================\n" +
                            "\n" +
                            "\t   1- Uye Listesi Yazdir\t\n" +
                            "\t   2- Soyisimden Uye Bulma\n" +
                            "\t   3- Sehire Gore Uye Bulma\n" +
                            "\t   4- Bilgilerini Girerek Uye Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS\n");

            //TODO Kullanıcıdan alacağınız tercihe göre ilgili menü metodlarına yönlendirmeler yapın...
            System.out.println("Lütfen seçim yapınız. ");
            tercih = scan.nextLine().toUpperCase();

            switch (tercih) {

                case "1":
                    uyeListesiYazdir();
                    break;
                case "2":
                    soyisimdenUyeBulma();
                    break;
                case "3":
                    sehreGoreUyeBulma();
                    break;
                case "4":
                    uyeEkleme();
                    break;
                case "5":
                    tcNoIleUyeSil();
                    break;
                case "A":
                    Helper.anaMenu2();
                    break;
                case "Q":
                    Helper.projeDurdur();
                    break;
                default:
                    System.out.println("Lutfen gecerli bir tercih giriniz");
            }


               /* // Uye Listesi Yazdir
                uyeListesiYazdir();
                // Soyisimden Uye Bulma
                soyisimdenUyeBulma();
                // Sehre Gore Uye Bulma
                sehreGoreUyeBulma();
                // Bilgilerini Girerek Uye Ekleme
                uyeEkleme();
                // Kimlik No Ile Kayit Silme
                tcNoIleUyeSil();
                Helper.anaMenu();
                System.out.println("Lutfen gecerli tercih yapiniz: ");*/


        } while (!tercih.equalsIgnoreCase("q"));
        Helper.projeDurdur();
    }

    public static void tcNoIleUyeSil() throws InterruptedException {
    String tcNo="";
        //TODO Kullanıcıdan alacağınız kimlik no ile ilgili üyeyi kayıtlardan siliniz...
        System.out.println("Silinecek uyeye ait kimlik no giriniz: ");
        tcNo=scan.nextLine();
        //TODO Gerekli atamaları yapınız. Aşağıdaki try-catch bloğu yardımcı olabilir...

        for (Map.Entry<String,String> ump : uyelerMap.entrySet()){
            if (ump.getKey().equalsIgnoreCase(tcNo)){
                uyelerMap.remove(tcNo);
            }
        }
        System.out.print("silinecekUye " +" Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        //try {
        //    boolean sonuc = sonucValue.equals(silinecekValue);
        //} catch (Exception e) {
        //    System.out.println("Istediginiz Tc numarasi ile uye bulunamadi.");
        //}
    }

    public static void uyeEkleme() {
        System.out.println("TC no giriniz: ");
        String tcNo = scan.nextLine();

        System.out.println("İsim giriniz: ");
        String isim = scan.nextLine();

        System.out.println("Soyisim giriniz: ");
        String soyIsim = scan.nextLine();

        System.out.println("Şehir giriniz: ");
        String sehir = scan.nextLine();

        System.out.println("Doğum yılı giriniz: ");
        String dogumYili = scan.nextLine();

        uyelerMap.put(tcNo,isim + ","+ soyIsim+","+sehir+","+dogumYili);

        //TODO Kullanıcıdan Tc no , Isim, Soyisim, Sehir, Dogum Yili alınız...
        //TODO Aldığınız değeri UyelerMap mapine uygun şekilde ekleyiniz...

    }

    public static void sehreGoreUyeBulma() throws InterruptedException {
        String sehir = "";
        //TODO Kullanıcıdan aldığınız girdiyle, UyelerMap'inde şehir araması yapın;
        //TODO Girilen şehire sahip tüm üyeleri map veya liste olarak döndürünüz...
        System.out.println("Aradiginiz Uyenin Sehrini Giriniz:");
        sehir = scan.nextLine();
        System.out.println(
                "\n============= TECHNO STUDY CONFLUENCE =============\n" +
                        "=============== SEHIR ILE UYE ARAMA ===============\n" +
                        "TcNo : Isim , Soyisim , Sehir, D.Yili");
        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... Zorunlu değil...

        for (Map.Entry<String, String> up : uyelerMap.entrySet()) {
            String uyeListesi[] = up.getValue().split(",");
            if (uyeListesi[2].trim().equalsIgnoreCase(sehir)) {
                System.out.println(up.getKey() + ":" + up.getValue());
            }
        }
    }

    public static void soyisimdenUyeBulma() throws InterruptedException {
        boolean bulunduMu = true;
        System.out.println("Aradiginiz uyenin soyisminin tamamini ya da birkismini giriniz: ");
        String soyisim = scan.nextLine();
        String ilkHarf="";
        String ikinciHarf="";
        String ilkucHarf="";
        String ilkDortHarf="";

     do {
         try {

             if (soyisim.length() >=1) {
                  ilkHarf = soyisim.substring(0, 1).toUpperCase();
             } else if (soyisim.length() >=2) {
                  ilkHarf = soyisim.substring(0, 1).toUpperCase();
                 ikinciHarf = soyisim.substring(1, 2).toLowerCase();

             } else if (soyisim.length() >=3) {


                  ilkucHarf = soyisim.substring(0, 3).toLowerCase();
             }
             else {
                 ilkDortHarf = soyisim.substring(0, 4).toLowerCase();
             }

             Thread.sleep(1000);

             System.out.println(
                     "\n========== TECHNO STUDY BOOTCAMP ===========\n" +
                             "=========== SOYISIM ILE UYE ARAMA ==========\n" +
                             "TcNo : Isim , Soyisim , Sehir , D.Yili");

             //"469922399405", "Ali, Can, Izmir, 2008"
             for (Map.Entry<String, String> up : uyelerMap.entrySet()) {
                 String uyeListesi[] = up.getValue().split(",");


                 if (uyeListesi[1].trim().equalsIgnoreCase(soyisim)) {
                     System.out.println(up.getKey() + ":" + up.getValue());
                     bulunduMu = true;

                     break;
                 } else if ((uyeListesi[1].trim().contains(ilkHarf) && uyeListesi[1].trim().contains(ikinciHarf)) ) {
                     System.out.println(up.getKey() + ":" + up.getValue());
                     bulunduMu = true;
                     break;
                 } else
                     bulunduMu = false;
             }

         } catch (Exception e) {

             System.out.println("Sorun var..");
             System.out.println(e.getMessage());
         }
     }while (!bulunduMu);

    }

    public static void uyeListesiYazdir() throws InterruptedException {
        //İPUCU METODU: Bu metodu değiştirmenize gerek yok...

        Set<Map.Entry<String, String>> uyelerEntrySet = uyelerMap.entrySet();

        System.out.print("Uye Listesi yazdiriliyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                "\n========== TECHNO STUDY CONFLUENCE =========\n" +
                        "=============== UYE LISTESI ================\n" +
                        "TcNo : Isim , Soyisim , Sehir , D.Yili");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir...
        for (Map.Entry<String, String> each : uyelerEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            System.out.println(eachKey + " : " + eachValue + " | ");
        }
    }
}
