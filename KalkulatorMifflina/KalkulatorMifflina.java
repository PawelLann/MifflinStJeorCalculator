import java.util.InputMismatchException;
import java.util.Scanner;

public class KalkulatorMifflina {

    public static void main (String args[]) {


        double wzrost;
        double waga;
        int x = 1;
        double bmi;
        double podstawowaPrzemianaMaterii;



        do{
            Scanner odczyt = new Scanner(System.in);
            try {
                Printer.print("Podaj swoj wzrost w metrach - np. 1,75");
                wzrost = odczyt.nextDouble();
            }catch (InputMismatchException ex){
                Printer.print("Wprowadz wzrost w metrach uzywajac przecinka zamiast kropki");
                wzrost = odczyt.nextDouble();
            }
            Printer.print("Podaj swoja wage");
            waga = odczyt.nextDouble();

            double wzrostDoPotegi = Math.pow(wzrost, 2.0);
            bmi = waga/wzrostDoPotegi;



            if(bmi>18.5){
                if(bmi<25){
                    Printer.print("Twoja masa ciala jest w normie");}
                else{
                    Printer.print("Masz nadwage");}
            }
            else{
                Printer.print("Masz niedowage");
            }


            double wyborMetody;

            Printer.print("Teraz obliczymy Twoje zapotrzebowanie kaloryczne");
            Printer.print("Wybierz czy wolisz dokonac obliczen metoda uproszczona (wpisz 1), czy zaawansowana metoda Mifflina St Jeora (wpisz 2)");
            wyborMetody = odczyt.nextDouble();

            if(wyborMetody == 1){
                podstawowaPrzemianaMaterii = waga*24;
                double zapotrzebowanie = 0;
                String wartoscAktywnosci;

                Printer.print("Podaj swoja aktywnosc: 1/1.2/ 1.4/1.6/1.8 lub 2 gdzie 1 to najnizsza a 2 to najwyzsza aktywnosc");
                wartoscAktywnosci = odczyt.next();

                double aktywnosc = Double.valueOf(wartoscAktywnosci).doubleValue();
                zapotrzebowanie = podstawowaPrzemianaMaterii*aktywnosc;

                Printer.print("Twoje zapotrzebowanie wynosi" + " " + zapotrzebowanie);
            }
            else{

                double dzienneZuzycie = 0;
                double aktywnoscSilowa = 0;
                double aktywnoscAerobowa = 0;
                double spalonePoSilowni = 0;
                double spalonePoAerobach = 0;
                int intensywnosc = 0;
                int spalaneNaBiezaco = 0;
                podstawowaPrzemianaMaterii = waga*24;



                Printer.print("Podaj w minutach ile w sumie czasu w tygodniu poswiecasz na trening silowy");
                aktywnoscSilowa = odczyt.nextDouble();
                aktywnoscSilowa = (aktywnoscSilowa/7)*8;

                Printer.print("Podaj w minutach ile w sumie czasu w tygodniu poswiecasz na trening aerobowy");
                aktywnoscAerobowa = odczyt.nextDouble();
                aktywnoscAerobowa = aktywnoscAerobowa/7*7.5;

                if(aktywnoscSilowa != 0){
                    Printer.print("Podaj liczbę treningow silowych w tygodniu");
                    spalonePoSilowni = odczyt.nextDouble();
                    spalonePoSilowni = spalonePoSilowni*(0.06*podstawowaPrzemianaMaterii);
                }

                if(aktywnoscAerobowa != 0){
                    Printer.print("Podaj liczbe treningow aerobowych w tygodniu");
                    spalonePoAerobach = odczyt.nextDouble();
                }

                if(aktywnoscAerobowa != 0){
                    Printer.print("Podaj za pomocą liczby intensywnosc treningow aerobowych: 1 -lekka, 2 - srednia, 3 - wysoka");
                    intensywnosc = Double.valueOf(odczyt.nextDouble()).intValue();
                }

                switch(intensywnosc){
                    case 1: intensywnosc = intensywnosc*5;
                        break;
                    case 2: intensywnosc = intensywnosc*35;
                        break;
                    case 3: intensywnosc = intensywnosc*180;
                        break;
                }
                spalonePoAerobach = spalonePoAerobach*intensywnosc;


                Printer.print("Podaj swoj typ budowy ciala wpisujac 1,2 lub 3, gdzie: 1 - ektomorfik (osoba wysoka, smukla, o dlugich konczynach), 2 - mezomorfik (osoba silna, umiesniona, postawna), 3 - endomorfik (osoba przysadzista, okragla)");
                spalaneNaBiezaco = Double.valueOf(odczyt.nextDouble()).intValue();

                switch(spalaneNaBiezaco){
                    case 1: spalaneNaBiezaco = 800;
                        break;
                    case 2: spalaneNaBiezaco = 450;
                        break;
                    case 3: spalaneNaBiezaco = 300;
                        break;
                }

                dzienneZuzycie = podstawowaPrzemianaMaterii + aktywnoscSilowa + aktywnoscAerobowa + spalaneNaBiezaco + spalonePoSilowni + spalonePoAerobach;
                double efektTermiczny = dzienneZuzycie*0.1;
                double ostateczneZapotrzebowanie = dzienneZuzycie + efektTermiczny;
                Printer.print("Twoje zapotrzebowanie kaloryczne wynosi" + " " + ostateczneZapotrzebowanie);


            }
        }
        while(x<2);
    }

}