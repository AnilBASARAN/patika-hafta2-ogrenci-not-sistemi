public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat1, int mat2, int fizik1, int fizik2, int kimya1, int kimya2) {
// mat1 sınav notu, mat2 ise sözlü notu yerine geçecek, böylece 3 ders için 6 değişken girilecek

        // sozlu notu için de 0 ile 100 arasında girilme şartı var

        if (mat1 >= 0 && mat1 <= 100) {
            this.mat.yaziliNote = mat1;
        }

        if (mat2 >= 0 && mat2 <= 100) {
            this.mat.sozluNote = mat2;
        }

        if (fizik1 >= 0 && fizik1 <= 100) {
            this.fizik.yaziliNote = fizik1;
        }

        if (fizik2 >= 0 && fizik2 <= 100) {
            this.fizik.sozluNote = fizik2;
        }

        if (kimya1>= 0 && kimya1 <= 100) {
            this.kimya.yaziliNote = kimya1;
        }

        if (kimya2 >= 0 && kimya2 <= 100) {
            this.kimya.sozluNote = kimya2;
        }

    }

    public void isPass() {

        // yazılı ve sozlu notların girilip girilmediğini boolean değer atayarak kontrol ediyoruz, eğer 2 si de girildiyse isCheckPass'ı
        // true dönüyoruz

        boolean isSozluNotlarGirildi = (this.mat.sozluNote != 0 && this.fizik.sozluNote != 0 && this.kimya.sozluNote != 0);
        boolean isYaziliNotlarGirildi = (this.mat.yaziliNote != 0 && this.fizik.yaziliNote != 0 && this.kimya.yaziliNote != 0);



        if (isSozluNotlarGirildi && isYaziliNotlarGirildi) {

            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }

        } else {

            if (!isSozluNotlarGirildi) System.out.println(" Sozlu Notlar tam olarak girilmemiş");
            if(this.mat.sozluNote == 0 )System.out.println(" Matematik sözlu notu eksik veya hatalı");
            if(this.fizik.sozluNote == 0 )System.out.println(" Fizik sözlu notu eksik veya hatalı");
            if(this.kimya.sozluNote == 0 )System.out.println(" Kimya sözlu notu eksik veya hatalı");


            if (!isYaziliNotlarGirildi) System.out.println(" Yazılı Notlar tam olarak girilmemiş");
            if(this.mat.yaziliNote == 0 )System.out.println(" Matematik yazılı notu eksik veya hatalı");
            if(this.fizik.yaziliNote == 0 )System.out.println(" Fizik yazılı notu eksik veya hatalı");
            if(this.kimya.yaziliNote == 0 )System.out.println(" Kimya yazılı notu eksik veya hatalı");

        }
    }







    public void calcAvarage() {
        this.fizik.ortalamaNote = (this.fizik.yaziliNote * 0.8) + (this.fizik.sozluNote * 0.2);
        this.mat.ortalamaNote = (this.mat.yaziliNote * 0.8) + (this.mat.sozluNote * 0.2);
        this.kimya.ortalamaNote = (this.kimya.yaziliNote * 0.8) + (this.kimya.sozluNote * 0.2);
        double averageNumber = (this.fizik.ortalamaNote + this.kimya.ortalamaNote + this.mat.ortalamaNote) / 3;

        // average değerini virgülden sonra 2 hane göstermesi için

        averageNumber = (int)(Math.round(averageNumber * 100))/100.0;
        this.avarage = averageNumber;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.ortalamaNote);
        System.out.println("Fizik Notu : " + this.fizik.ortalamaNote);
        System.out.println("Kimya Notu : " + this.kimya.ortalamaNote);
    }

}