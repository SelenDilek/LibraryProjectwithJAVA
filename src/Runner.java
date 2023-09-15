

public class Runner {
    // BU SINIFTA BİR DEĞİŞİKLİK YAPMANIZA GEREK YOK...
    // METODLARI DOLDURMAYA BAŞLADIKÇA ÇALIŞICAK...

    public static void main(String[] args) throws InterruptedException {

        Veritabani.baslangicUyelerVeritabaniOlustur();
        Veritabani.baslangicKitaplarVeritabaniOlustur();
        Helper.anaMenu();
    }
}