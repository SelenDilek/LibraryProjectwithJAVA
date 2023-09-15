

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class KitapManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);

    public static void kitapMenu() throws InterruptedException {
        String tercih = "";
       do {// TODO Kullanıcı Çıkış Yapmadığı sürece menüde kalalım...
            System.out.println(
                    "\n============ TECHNO STUDY BOOTCAMP ============\n" +
                            "================== KITAP MENU =================\n" +
                            "\t   1- Kitap Listesi Yazdir\n" +
                            "\t   2- Yazardan Kitap Bulma\n" +
                            "\t   3- Kitap Turu veya Yayin Tarihi Ile Kitap Bulma\n" +
                            "\t   4- Bilgilerini Girerek Kitap Ekleme\n" +
                            "\t   5- Kitap Ismi Ile Kayit Silme \t\n" +
                            "\t   6- Kitap Odunc Al \t\n" +
                            "\t   7- Kitap Iade Et \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS");

            //TODO Kullanıcıdan alacağınız tercihe göre ilgili menü metodlarına yönlendirmeler yapın...
           System.out.println("Lütfen seçim yapınız. ");
           tercih = scan.nextLine().toUpperCase();

           switch (tercih){

               case "1": kitapListesiYazdir();
                   break;
               case "2": yazardanKitapBulma();
                   break;
               case "3": turVeyaYayinTarihiIleKitapBulma();
                   break;
               case "4": kitapEkle();
                   break;
               case "5": isimIleKitapSilme();
                   break;
               case "6": kitapOduncAl();
                   break;
               case "7": kitapIadeEt();
                   break;
               case "A": Helper.anaMenu();
                   break;
               case "Q": Helper.projeDurdur();
                   break;
               default:System.out.println("Lutfen gecerli bir tercih giriniz");
           }
            /*
                kitapListesiYazdir();
                // Yazar Ismiyle Kitap Bulma
                yazardanKitapBulma();
                // Kitap Turu veya Yayin Tarihi Ile Kitap Bulma
                turVeyaYayinTarihiIleKitapBulma();
                // Bilgilerini Girerek Kitap Ekleme
                kitapEkle();
                isimIleKitapSilme();
                kitapOduncAl();
                kitapIadeEt();
                Helper.anaMenu();
                Helper.projeDurdur();
                System.out.println("Lutfen gecerli bir tercih giriniz");
            */
        } while (!tercih.equalsIgnoreCase("q"));
        Helper.projeDurdur();

    }

    public static void kitapOduncAl() {
        try {
            System.out.println("Odunc almak istediginiz kitabin ismini giriniz: ");
            String kitapIsmi = scan.nextLine();

            for (Map.Entry<String, String> up : kitaplarMap.entrySet()) {
                if (up.getKey().equalsIgnoreCase(kitapIsmi)) {
                    kitaplarMap.remove(kitapIsmi);
                }
                oduncKitaplarMap.put(kitapIsmi, up.getValue());
            }
        }catch (Exception e){


            //TODO Kullanıcıdan alacağınız kitap ismiyle (Map te var olmalı)
            //TODO kitap ödünç alma metodunu tamamlayın...
            //NOT: Veritabanı'nda ödünç almayla alakalı ikinci bir map 'i tampon gibi kullanmalısınız...
            //Ödünç alındığında kitaplarMap 'ten düşüp bu map e eklenecek...
        }

    }
        public static void kitapIadeEt () {
        try {

            System.out.println("Iade etmek istediginiz kitabin ismini giriniz: ");
            String kitapIsmi = scan.nextLine();

            for (Map.Entry<String, String> up : oduncKitaplarMap.entrySet()) {
                if (up.getKey().equalsIgnoreCase(kitapIsmi)) {
                    oduncKitaplarMap.remove(kitapIsmi);
                }
                kitaplarMap.put(kitapIsmi, up.getValue());
            }
        }catch (Exception e){

        }

            //TODO Kullanıcıdan alacağınız kitap ismiyle (Map te var olmalı)
            //TODO kitap iade etme metodunu tamamlayın...
            //NOT: Veritabanı'nda iade etmeyle alakalı ikinci bir map 'i tampon gibi kullanmalısınız...
            //Kitap iade edildiğinde,  kitaplarMap 'e geri eklenmeli...
        }

    private static void isimIleKitapSilme() throws InterruptedException
    {//İPUCU METODU... Bu metodu değiştirmenize gerek yok.
        System.out.println("Silinecek kitabin ismini giriniz");
        String silinecekKitap = scan.nextLine();

        String silinecekValue = kitaplarMap.get(silinecekKitap);
        String sonucValue = kitaplarMap.remove(silinecekKitap);

        System.out.print(silinecekKitap + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        //ARTIK UYGUN YERLERDE BEKLEMEDİĞİNİZ SONUÇLAR İÇİN TRY CATCH KULLANABİLİRSİNİZ...
        //////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz kitap ismi bulunamadi");
        }/////////////////////////////////////////////////////////////////////////////////////////////////
    }

    private static void kitapEkle() {
        boolean turVarmi=true;
        do {
            System.out.println("Kitap adını giriniz: ");
            String kitapAdi = scan.nextLine();

            System.out.println("Yazar adını giriniz: ");
            String yazarAdi = scan.nextLine();

            System.out.println("Kitap türünü giriniz: ");
            System.out.println("TARIH, POLISIYE, KURGU, ROMAN, DESTAN, TANIMLANMAMIS_TUR");
            String kitapturu = scan.nextLine().toUpperCase();

            System.out.println("Kitap yayın yılını giriniz: ");
            String yayinYili = scan.nextLine();

            KitapTuru kitapTuru;

            switch (kitapturu) {
                case "TARIH":
                    kitaplarMap.put(kitapAdi, yazarAdi +","+ KitapTuru.TARIH +"," +yayinYili);
                    break;
                case "POLISIYE":
                    kitaplarMap.put(kitapAdi, yazarAdi +"," +KitapTuru.POLISIYE +","+ yayinYili);
                    break;
                case "KURGU":
                    kitaplarMap.put(kitapAdi, yazarAdi +","+ KitapTuru.KURGU +","+ yayinYili);
                    break;
                case "ROMAN":
                    kitaplarMap.put(kitapAdi, yazarAdi +","+ KitapTuru.ROMAN +","+ yayinYili);
                    break;
                case "DESTAN":
                    kitaplarMap.put(kitapAdi, yazarAdi +","+ KitapTuru.DESTAN +","+ yayinYili);
                    break;
                case "TANIMLANMAMIS_TUR":
                    kitaplarMap.put(kitapAdi, yazarAdi +","+ KitapTuru.TANIMLANMAMIS_TUR +","+ yayinYili);
                    break;
                default:
                    System.out.println("Yanlış giriş yaptınız. Tekrar giriş yapınız");
                    turVarmi=false;
            }
        }while (!turVarmi);

        //"A Tale of Two Cities", "Charles Dickens, Tarih, 1859" >> Kitap key,value su buna benzer şekilde...

        //TODO Kitap Adını, Yazar Adını, Kitap Türünü ve Yayınlanma Yılını Kullanıcıdan alarak,
        //TODO kitaplarMap'e ekleme yapınız...

        //TODO MÜMKÜNSE, kitap türünü, Enum olarak tanımlanan KitapTuru sınıfını kullanarak alınız...
        //KİTAP TÜRLERİ >>     TARIH, POLISIYE, KURGU, ROMAN, DESTAN, TANIMLANMAMIS_TUR
        //TODO Kullanıcı kitap türünü yanlış girdiği sürece , kullanıcıya
        //TODO "Hatali giris! Lutfen kitap turunu tekrar giriniz: " mesajı verin...
        //TODO while ve try-catch kullanılabilir... Giriş başarılı olursa try-catch bloğu kırılarak konsoldan
        //TODO yayınlama yılı alıp kitap ekleme işlemine devam edilebilir...
        //Kullanıcı tarafından girilen stringi, KitapTuru sınıfında tanımlanan türlerden birine çevirmeniz gerkecek...
        // kitapTuru değişkeni artık geçerli bir değere sahipse...
        // Diğer işlemlere devam edebilirsiniz.
        //System.out.println("Yayinlanma Tarihi: ");
        //String yayinTarihi = scan.nextLine();

        //TODO Ekleme işlemini tamamlayın...


    }

    public static void turVeyaYayinTarihiIleKitapBulma() throws InterruptedException {
        boolean varmi=true;
    do{
        String bilgi = "";
        //TODO kitaplar.Map'in Value larını almak için  Set<Map.Entry<String, String>> cinsinden myEntrySet tanımlayın...

        System.out.println("Istediginiz kitabin turunu veya yayın yılını yaziniz: ");
        System.out.println("(Tarih, Polisiye, Kurgu, Roman, Destan)");
        bilgi = scan.nextLine();

        //TODO Metodu kullanıcıdan alacağınız girdileri kullanarak tamamlayın...

        System.out.println(
                "\n============ TECHNO STUDY CONFLUENCE ==========\n" +
                        "================= KITAP LISTESI ===============\n" +
                        "Kitap Ismi    :   Yazar Ismi , Kitap Turu , Yayin Yili");

        for (Map.Entry<String, String> up : kitaplarMap.entrySet()) {
            String uyeListesi[] = up.getValue().split(",");
            if (uyeListesi[1].trim().equalsIgnoreCase(bilgi)) {
                System.out.println(up.getKey() + ":" + up.getValue());
                varmi=true;
                break;
            } else if (uyeListesi[2].trim().equalsIgnoreCase(bilgi)) {
                System.out.println(up.getKey() + ":" + up.getValue());
                varmi=true;
                break;
            } else{
                varmi=false;
            }
        }

    }while (!varmi);
    }


    public static void yazardanKitapBulma() throws InterruptedException {
        String yazarAdi = "";
        //TODO kitaplar.Map'in Value larını almak için  Set<Map.Entry<String, String>> cinsinden myEntrySet tanımlayın...
        System.out.println("Istediginiz yazar ismini yaziniz: ");
        yazarAdi = scan.nextLine();
        //TODO Metodu kullanıcıdan alacağınız girdileri kullanarak tamamlayın...

        System.out.println(
                "\n============ TECHNO STUDY CONFLUENCE ==========\n" +
                        "================= KITAP LISTESI ===============\n" +
                        "Kitap Ismi    :   Yazar Ismi , Kitap Turu , Yayin Yili");
        // printf veya String.format metodları kullanılarak daha düzgün bi çıktı elde edilebilir.
        // Şart değil, isteğe bağlı.

        for (Map.Entry<String, String> up : kitaplarMap.entrySet()) {
            String uyeListesi[] = up.getValue().split(",");
            if (uyeListesi[0].trim().equalsIgnoreCase(yazarAdi)) {
                System.out.println(up.getKey() + ":" + up.getValue());
            }

        }
    }
        public static void kitapListesiYazdir() throws InterruptedException
        { //Üye Listesi Yazdır Metodundan Faydalanabilirsiniz...

            //TODO kitaplar.Map'in Value larını almak için  Set<Map.Entry<String, String>> cinsinden myEntrySet tanımlayın...

            System.out.println(
                    "\n============ TECHNO STUDY CONFLUENCE ==========\n" +
                            "================= KITAP LISTESI ===============\n" +
                            "Kitap Ismi    :   Yazar Ismi , Kitap Turu , Yayin Yili");

            for (Map.Entry<String, String> kmp : kitaplarMap.entrySet()) {
                System.out.println(kmp.getKey() + ":" + kmp.getValue());
            }


            //TODO Kitapları listeleyecek metodu oluşturun...
            //Üye Listesi Yazdır Metodundan Faydalanabilirsiniz...
        }
    }
